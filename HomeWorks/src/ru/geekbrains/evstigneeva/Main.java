package ru.geekbrains.evstigneeva;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Chat chat = new Chat();

        Integer[] list = {10, 2, 23, 44};
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        int search = search(22, list);
        System.out.println(search);
        System.out.println();
        String result = reverse("Всё реально");
        System.out.println(result);
        System.out.println();
        System.out.println(maximum(list));


    }

    public static int search(Integer number, Integer[] list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == number) {
                return i;
            }
        }

        return -1;
    }

    public static String reverse(String one) {

        StringBuilder stringBuilder = new StringBuilder(one);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static Integer maximum(Integer[] list) {


        return null;

    }
}
