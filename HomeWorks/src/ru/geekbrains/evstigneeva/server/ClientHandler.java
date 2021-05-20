package ru.geekbrains.evstigneeva.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class ClientHandler implements Runnable {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream())
        ) {
            while (true) {
                String command = in.readUTF();
                if ("exit".equals(command)) {
                    out.writeUTF("DONE");
                    disconnected();
                    System.out.printf("Client %s disconnected correctly\n", socket.getInetAddress());
                    break;
                }
                System.out.println(command);
                out.writeUTF(command);
            }
        } catch (SocketException socketException) {
            System.out.printf("Client %s disconnected\n", socket.getInetAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void disconnected() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
