package ru.geekbrains.evstigneeva;

public class Main {
    public static void main(String[] args) {
        int q = 1;
        byte w = 2;
        short r = 3;
        long e = 4;
        float t = 5;
        double y = 1.585;
        char u = 'E';
        boolean i = true;
        String str = "Готово";

        System.out.println("Инициализированные переменные всех пройденых типов данных");
        System.out.println(q);
        System.out.println(w);
        System.out.println(r);
        System.out.println(e);
        System.out.println(t);
        System.out.println(y);
        System.out.println(u);
        System.out.println(i);
        System.out.println(str);

        System.out.println();

        float o = threeSolution(3, 6, 7, 4);
        System.out.println("Ответ на 3ью задачу: " + o);

        boolean k = fourSolution(5, 5);
        System.out.println("Ответ на 4ую задачу: " + k);

        fiveSolution(-10);
        System.out.println("Ответ на 6ую задачу: " + sixSolution(-10));
        sevenSolution("Кристина");
        eightSolution(100);
    }

    static float threeSolution(float a, float b, float c, float d) {
        return (a * (b + (c / d)));
    }

    public static boolean fourSolution(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void fiveSolution(int z) {
        if (z >= 0) {
            System.out.println("Ответ на 5ую задачу: Положительное");
        } else {
            System.out.println("Ответ на 5ую задачу: Отрицательное");
        }
    }

    public static boolean sixSolution(int a) {
        return a < 0;
    }

    static void sevenSolution(String a) {
        System.out.println("Привет, " + a + "!");
    }

    public static void eightSolution(int year) {
        if (year % 400 == 0) {
            System.out.println("Ответ на 8 ую задачу: Високосный");
        } else if (year % 100 == 0) {
            System.out.println("Ответ на 8 ую задачу: Невисокосный");
        } else if (year % 4 == 0) {
            System.out.println("Ответ на 8 ую задачу: Високосный");
        } else {
            System.out.println("Ответ на 8 ую задачу: Невисокосный");
        }
    }
}
