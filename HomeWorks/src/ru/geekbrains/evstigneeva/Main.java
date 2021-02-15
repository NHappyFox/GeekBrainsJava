package ru.geekbrains.evstigneeva;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        printSingleThreadArrayCalculationTime();
        printTwoThreadArrayCalculationTime();

    }

    public static void printSingleThreadArrayCalculationTime() {

        final int size = 10000000;
        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        long timeBegin = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long timeOver = System.currentTimeMillis();

        System.out.println((timeOver - timeBegin));
    }

    public static void printTwoThreadArrayCalculationTime() {
        final int size = 10000000;
        final int half = size / 2;

        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        float[] arrHalf1 = new float[half];
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < arrHalf1.length; i++) {
                arrHalf1[i] = (float) (arrHalf1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        float[] arrHalf2 = new float[half];
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < arrHalf2.length; i++) {
                arrHalf2[i] = (float) (arrHalf2[i] * Math.sin(0.2f + ((i + half) / 5)) * Math.cos(0.2f + ((i + half) / 5)) * Math.cos(0.4f + ((i + half) / 2)));
            }
        });

        long timeBegin = System.currentTimeMillis();

        System.arraycopy(arr, 0, arrHalf1, 0, half);
        System.arraycopy(arr, 0, arrHalf2, 0, half);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ignored) {
        }

        System.arraycopy(arrHalf1, 0, arr, 0, half);
        System.arraycopy(arrHalf2, 0, arr, half, half);

        long timeOver = System.currentTimeMillis();

        System.out.println((timeOver - timeBegin));

    }

}
