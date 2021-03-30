package ru.geekbrains.evstigneeva;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] arr = {"asd", "ds", "ret", "123"};
        System.out.println("Original array: " + Arrays.toString(arr));
        swapIndexs(arr, 0, 3);
        System.out.println("Did swap a places: " + Arrays.toString(arr));

    }

    private static <T> void swapIndexs(T[] array, int index_1, int index_2) {
        T temp = array[index_1];
        array[index_1] = array[index_2];
        array[index_2] = temp;
    }

}
