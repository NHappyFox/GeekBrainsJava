package ru.geekbrains.evstigneeva;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class TicTacToeGUI extends JFrame {

    private JButton[][] map;
    private final Font font = new Font("Arial", Font.PLAIN, 50);
    private final Random rand = new Random();

    public TicTacToeGUI() {
        setBounds(300, 500, 640, 480);
        setTitle("Крестики-нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GridLayout gridLayout = new GridLayout(3, 3);
        setLayout(gridLayout);

        initMap();

        setVisible(true);
    }

    private void initMap() {
        map = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = createButton();
                add(map[i][j]);
            }
        }
    }

    private JButton createButton() {
        JButton button = new JButton();
        button.setFont(font);
        button.addActionListener(e -> {
            humanTurn(button);
            if (checkWin("X")) {
                System.out.println("Вы победили!!");
                gameOver();
                return;
            }
            if (isMapFull()) {
                System.out.println("Ничья!");
                gameOver();
                return;
            }
            aiTurn();
            if (checkWin("O")) {
                System.out.println("Победил компьютер =(");
                gameOver();
            }

        });
        return button;
    }

    private void humanTurn(JButton button) {
        button.setEnabled(false);
        button.setText("X");
    }

    private void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(3);
            y = rand.nextInt(3);
        } while (!map[y][x].isEnabled());
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x].setText("O");
        map[y][x].setEnabled(false);
    }

    private boolean isMapFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j].isEnabled()) return false;
            }
        }
        return true;
    }

    private boolean checkWin(String symb) {
        if (checkWinRight(symb)) {
            return true;
        }
        if (checkWinLeft(symb)) {
            return true;
        }
        if (checkWinRow(symb)) {
            return true;
        }
        return checkWinColumn(symb);
    }

    private boolean checkWinRight(String symb) {
        for (int i = 0; i < 3; i++) {
            if (!map[i][i].getText().equals(symb)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkWinLeft(String symb) {
        for (int i = 0; i < 3; i++) {
            if (!map[i][2 - i].getText().equals(symb)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkWinRow(String symb) {
        for (int i = 0; i < 3; i++) {
            int kolSymb = 0;
            for (int j = 0; j < 3; j++) {
                if (!map[i][j].getText().equals(symb)) {
                    break;
                }
                if (map[i][j].getText().equals(symb)) {
                    kolSymb = kolSymb + 1;
                    if (kolSymb == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkWinColumn(String symb) {
        for (int i = 0; i < 3; i++) {
            int kolSymb = 0;
            for (int j = 0; j < 3; j++) {
                if (!map[j][i].getText().equals(symb)) {
                    break;
                }
                if (map[j][i].getText().equals(symb)) {
                    kolSymb = kolSymb + 1;
                    if (kolSymb == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void gameOver() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j].setEnabled(false);
            }
        }

        System.out.println("Игра окончена");
    }
}
