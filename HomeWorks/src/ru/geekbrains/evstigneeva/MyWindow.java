package ru.geekbrains.evstigneeva;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 500, 500);
        JButton[] jbs = new JButton[5];
        for (int i = 0; i < jbs.length; i++) {
            jbs[i] = new JButton("№" + i);
        }

        setLayout(new BorderLayout());  // выбор компоновщика элементов
        add(jbs[0], BorderLayout.WEST); // добавление кнопки на форму
        add(jbs[1], BorderLayout.CENTER); // добавление кнопки на форму
        add(jbs[2], BorderLayout.EAST); // добавление кнопки на форму
        add(jbs[3], BorderLayout.NORTH); // добавление кнопки на форму
        add(jbs[4], BorderLayout.SOUTH); // добавление кнопки на форму

        JButton button = new JButton("Button 1 (PAGE_START)");
        add(button, BorderLayout.PAGE_START);
        button = new JButton("Button 2 (CENTER)");
        button.setPreferredSize(new Dimension(200, 100));
        add(button, BorderLayout.CENTER);
        button = new JButton("Button 3 (LINE_START)");
        add(button, BorderLayout.LINE_START);
        button = new JButton("Long-Named Button 4 (PAGE_END)");
        add(button, BorderLayout.PAGE_END);
        button = new JButton("5 (LINE_END)");
        add(button, BorderLayout.LINE_END);


        setVisible(true);
    }
}

