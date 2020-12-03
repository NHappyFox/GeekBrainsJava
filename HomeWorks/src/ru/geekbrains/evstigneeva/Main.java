package ru.geekbrains.evstigneeva;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scaNer = new Scanner(System.in);
        System.out.println("Введите длину массива");
        int g = scaNer.nextInt();
        int vvodimiiMassiv[] = new int[g];
        System.out.println("Введите целочисленный массив (через Enter), состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].");
        for (int i = 0; i < g; i++) {
            vvodimiiMassiv[i] = scaNer.nextInt();
        }

        System.out.print("Введёный массив: ");
        System.out.println();
        System.out.println(Arrays.toString(vvodimiiMassiv));
        for (int i = 0; i < g; i++) {
            if (vvodimiiMassiv[i] == 1) vvodimiiMassiv[i] = 0;
            else vvodimiiMassiv[i] = 1;
        }
        System.out.println("Ответ на первую задачу: ");
        System.out.println(Arrays.toString(vvodimiiMassiv));

        int[] arr = new int[8];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        System.out.println();
        System.out.println("Ответ на вторую задачу: ");
        System.out.println(Arrays.toString(arr));

        int[] akr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int x = 0; x < akr.length; x++) {
            if (akr[x] < 6) akr[x] = akr[x] * 2;
        }
        System.out.println();
        System.out.println("Ответ на третью задачу: ");
        System.out.println(Arrays.toString(akr));
        System.out.println();
        System.out.println("Ответ на четвёртую задачу: ");
        int length = 11;
        int[][] akr1 = new int[length][length];

        for (int d = 0; d < length; d++) {
            for (int u = 0; u < length; u++) {
                if (d == u) {
                    akr1[d][u] = 1;
                }
                if (u == length - 1 - d) {
                    akr1[d][u] = 1;
                }
                System.out.print(akr1[d][u] + " ");
            }
            System.out.println();
        }

        int[] arr2 = {1, -5, -3, 2, 11, 4, 20};
        int s = arr2[0];
        int m = arr2[0];
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] > s) s = arr2[i];
            if (arr2[i] < m) m = arr2[i];
        }
        System.out.println();
        System.out.println("Ответ на пятую задачу: ");
        System.out.println("min: " + m + " и max: " + s);
    }
}
