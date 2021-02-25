package ru.geekbrains.evstigneeva.client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {

    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner;

    public MyClient() {
        scanner = new Scanner(System.in);
        try {
            openConnection();
        } catch (IOException | InterruptedException ignored) {
        }
    }

    public void openConnection() throws IOException, InterruptedException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        authenticate();

        Thread threadReader = new Thread(() -> {
            try {
                while (true) {
                    String consoleMessage = scanner.nextLine();
                    out.writeUTF(consoleMessage);
                    if (consoleMessage.equalsIgnoreCase("/end")) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        threadReader.start();

        while (true) {
            String strFromServer = in.readUTF();
            System.out.println("Сервер сказал: " + strFromServer);
            if (strFromServer.equalsIgnoreCase("/end")) {
                break;
            }
        }

        closeConnection();
    }

    private void authenticate() throws IOException {
        while (true) {
            sendAuthRequest();
            String strFromServer = in.readUTF();
            if (strFromServer.startsWith("/authok")) {
                System.out.println("Auth successful");
                break;
            }
            System.out.println("Auth Unsuccessful: " + strFromServer);
        }
    }

    private void sendAuthRequest() {
        try {
            System.out.println("Username: ");
            String username = scanner.nextLine();
            System.out.println("Password: ");
            String password = scanner.nextLine();
            out.writeUTF("/auth " + username + " " + password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
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
