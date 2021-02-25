package ru.geekbrains.evstigneeva.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private MyServer myServer;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private static final long TIME_OUT_MILLS = 2 * 60 * 1000;
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

            new Thread(() -> {
                try {
                    Thread.sleep(TIME_OUT_MILLS);
                    if (name.length() == 0) {
                        closeConnection();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    authentication();
                    readMessages();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException("Проблемы при создании обработчика клиента");
        }
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
