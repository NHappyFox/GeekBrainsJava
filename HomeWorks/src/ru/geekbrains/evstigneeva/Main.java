package ru.geekbrains.evstigneeva;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        Chat chat = new Chat();

        Integer[] list = {10, 2, 23, 44};
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        int search = search(22, list);

        List<String> arrayList = new ArrayList();
        arrayList.add("blink");
        arrayList.add("arm");
        arrayList.add("bad");
        arrayList.add("beer");
        arrayList.add("bliss");
        arrayList.add("block");
        arrayList.add("clear");
        arrayList.add("again");

        System.out.println(search);
        System.out.println();
        String result = reverse("Всё реально");
        System.out.println(result);
        System.out.println();
        System.out.println(maximum(list));
        System.out.println(average());
        System.out.println(searchWords(arrayList));

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

        Integer max = list[0];


        for (int i = 0; i < list.length; i++) {
            if (max < list[i]) {
                max = list[i];
            }
        }
        return max;
    }

    public static Double average() {

        List<Integer> testList = Arrays.asList(6, 7, 8, 9, 10);

        double intAverage = testList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        return intAverage;
    }

    public static List<String> searchWords(List<String> arrayList) {
        Predicate<String> lambda = (string) -> string.startsWith("a") && string.length() == 3;

        return arrayList
                .stream()
                .filter(lambda)
                .collect(Collectors.toList());
    }

}
