package ru.geekbrains.evstigneeva;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Chat extends JFrame {

    JPanel jPanelUp = new JPanel(new GridLayout());
    JPanel jPanelDown = new JPanel(new GridLayout());
    JButton jButton = new JButton("ОТПРАВИТЬ");
    JTextArea jText = new JTextArea();
    JScrollPane jScroll = new JScrollPane(jText);
    JTextField jTextField = new JTextField();

    Chat() {
        super("CHAT");
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 300));

        jText.setLineWrap(true);
        jText.setEditable(false);

        jButton.addActionListener(e -> {
            sendMessage();
        });
        jTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        jPanelUp.add(jScroll);
        jPanelDown.add(jTextField);
        jPanelDown.add(jButton);

        add(jPanelUp);
        add("South", jPanelDown);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void sendMessage() {
        String out = jTextField.getText();
        jText.append(out + "\n");
        jTextField.setText("");
        jTextField.grabFocus();
    }

}
