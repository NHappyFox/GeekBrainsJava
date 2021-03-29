package ru.geekbrains.evstigneeva;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] arr = {"asd", "ds", "ret", "123"};
        System.out.println("Swap a places: " + Arrays.toString(arr));
        swapElements(arr, 0, 3);
        System.out.println(Arrays.toString(arr));

    }

    private static <T> void swapElements(T[] array, int index_1, int index_2) {
        T temp = array[index_1];
        array[index_1] = array[index_2];
        array[index_2] = temp;
    }

}
