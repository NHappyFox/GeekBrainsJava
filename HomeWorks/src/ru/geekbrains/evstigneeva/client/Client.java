package ru.geekbrains.evstigneeva.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class Client extends JFrame {
    private final Socket socket;
    private final DataOutputStream out;
    private final DataInputStream in;

    public Client() throws IOException {
        //
        socket = new Socket("localhost", 6789);
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());

        // create form
        setSize(300, 300);
        JPanel panel = new JPanel(new GridLayout(2, 1));

        JButton btnSend = new JButton("SEND");
        JTextField textField = new JTextField();

        btnSend.addActionListener(a -> {
            String message = textField.getText();
            sendMessage(message);
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                sendMessage("exit");
            }
        });

        panel.add(textField);
        panel.add(btnSend);

        add(panel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * message sending
     *
     * @param message String
     */
    private void sendMessage(String message) {
        try {
            out.writeUTF(message);
            String command = in.readUTF();
            if ("done".equalsIgnoreCase(command)) {
                System.out.println();
            }
        } catch (EOFException eofException) {
            System.err.println("Reading command error from " + socket.getInetAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Client();
    }
}
