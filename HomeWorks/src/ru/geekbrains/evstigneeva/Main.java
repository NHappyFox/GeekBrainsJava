package ru.geekbrains.evstigneeva;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int vibor;
        do {
            ugadaika();
            do {
                System.out.println("«Повторить игру еще раз? 1 – да / 0 – нет»");
                vibor = scanner.nextInt();
            }
            while (vibor != 0 && vibor != 1);
        }
        while (vibor == 1);
    }

    static void ugadaika() {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int zagadannoeChislo = random.nextInt(10);
        int chisloUser;
        for (int chisloPopitok = 3; chisloPopitok > 0; chisloPopitok--) {
            System.out.println("Угадайте задуманное число от 0 до 9. У вас осталось попыток " + chisloPopitok);
            chisloUser = scan.nextInt();
            if (zagadannoeChislo == chisloUser) {
                System.out.println("Угадал");
                return;
            }
            if (zagadannoeChislo < chisloUser) {
                System.out.println("Ваше число больше загаданного");
            } else {
                System.out.println("Ваше число меньше загаданного");
            }
        }

    }
}
