package ru.geekbrains.evstigneeva;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MyWindow1 extends JFrame {
    public MyWindow1() {
        setBounds(500, 500, 300, 300);
        setTitle("Demo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JTextField field = new JTextField();
        add(field);
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Your message: " + field.getText());
            }
        });

        JPanel pan = new JPanel();
        add(pan);
        pan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("MousePos: " + e.getX() + " " + e.getY());
            }
        });


        JButton button = new JButton("Button for press");
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button pressed...");
            }
        });


        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // одну из строк X или Y можно закомментировать
//        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS)); // одну из строк X или Y можно закомментировать
//        setLayout(new FlowLayout()); // располагает элементы в одну строку, когда ширины строки становится
//        недостаточно, переносит новые элементы на следующую. Не противоречит
//        GridLayout - элементы управления выравниваются по таблице заданного размера.
        setLayout(new GridLayout(5, 0));

        JButton[] jbs = new JButton[10];
        for (int i = 0; i < jbs.length; i++) {
            jbs[i] = new JButton("№" + i);
//            jbs[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            add(jbs[i]);
        }
        setVisible(true);
    }

}
