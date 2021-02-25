package ru.geekbrains.evstigneeva.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class ClientHandler {
    private MyServer myServer;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private static final long LOGIN_TIME_OUT_MILLS = 2 * 60 * 1000;
    private static final long LAST_MESSAGE_TIME_OUT_MILLS = 3 * 60 * 1000;
    private Long lastMessageTime = 0l;
    private String name;

    public String getName() {
        return name;
    }

    public ClientHandler(MyServer myServer, Socket socket) {
        try {
            this.myServer = myServer;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.name = "";

            startAuthWaiter();
            startMainThread();
            startDisconnectingInactiveUserProcess();

        } catch (IOException e) {
            throw new RuntimeException("Проблемы при создании обработчика клиента");
        }
    }

    private void startMainThread() {
        new Thread(() -> {
            try {
                authentication();
                lastMessageTime = new Date().getTime();
                readMessages();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }).start();
    }

    private void startAuthWaiter() {
        new Thread(() -> {
            try {
                Thread.sleep(LOGIN_TIME_OUT_MILLS);
                if (name.length() == 0) {
                    System.out.println("timeout exception logout unauthorized client");
                    closeConnection();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void startDisconnectingInactiveUserProcess() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10000);
                    long timeDifference = new Date().getTime() - lastMessageTime;

                    if (timeDifference >= LAST_MESSAGE_TIME_OUT_MILLS) {
                        closeConnection();
                        return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void authentication() throws IOException {
        while (true) {
            String str = in.readUTF();
            if (str.startsWith("/auth")) {
                String[] parts = str.split("\\s");
                String nick = myServer.getAuthService().getNickByLoginPass(parts[1], parts[2]);
                if (nick == null) {
                    sendMsg("Неверные логин/пароль");
                    continue;
                }
                if (myServer.isNickBusy(nick)) {
                    sendMsg("Учетная запись уже используется");
                    continue;
                }
                sendMsg("/authok " + nick);
                name = nick;
                myServer.broadcastMsg(name + " зашел в чат");
                myServer.subscribe(this);
                return;
            }
        }
    }

    public void readMessages() throws IOException {
        while (true) {
            String strFromClient = in.readUTF();
            lastMessageTime = new Date().getTime();
            System.out.println("от " + name + ": " + strFromClient);
            if (strFromClient.equals("/end")) {
                return;
            }
            if (strFromClient.startsWith("/w")) {
                processPersonalMessage(strFromClient);
            } else {
                myServer.broadcastMsg(name + ": " + strFromClient);
            }
        }
    }

    private void processPersonalMessage(String strFromClient) {
        String[] parts = strFromClient.split("\\s");
        String nick = parts[1];
        StringBuilder messageUser = new StringBuilder();
        for (int i = 2; i < parts.length; i++) {
            messageUser.append(" ").append(parts[i]);
        }
        myServer.sendDirectMessage(nick, messageUser.toString());
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        myServer.unsubscribe(this);
        myServer.broadcastMsg(name + " вышел из чата");
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
