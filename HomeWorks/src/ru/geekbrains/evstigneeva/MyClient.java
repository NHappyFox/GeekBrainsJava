package ru.geekbrains.evstigneeva;

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
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void openConnection() throws IOException, InterruptedException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
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

    public void closeConnection() {
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
