package ru.geekbrains.evstigneeva;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен, ожидаем подключения...");

            socket = serverSocket.accept();
            System.out.println("Клиент подключился");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread threadReader = new Thread(() -> {
                try {
                    while (true) {
                        String consoleMessage = scanner.nextLine();
                        out.writeUTF(consoleMessage);
                        if (consoleMessage.equalsIgnoreCase("/end")) {
                            break;
                        }
                    }
                } catch (Exception ignored) {
                }
            });
            threadReader.start();

            while (true) {
                String str = in.readUTF();
                if ("/end".equals(str)) {
                    break;
                }
                System.out.println("Клиент сказал: " + str);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
