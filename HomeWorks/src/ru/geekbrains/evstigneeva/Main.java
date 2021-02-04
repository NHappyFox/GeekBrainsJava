package ru.geekbrains.evstigneeva;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String[] strings = new String[]{"New York", "Illinois", "California", "Texas", "Indiana", "California", "Texas",
                "Texas", "Ohio", "Michigan", "Maryland", "Florida", "Arizona"};

        HashMap<String, Integer> stringIntegerHashMap = countWords(strings);

        for (Map.Entry<String, Integer> o : stringIntegerHashMap.entrySet()) {
            if (o.getValue() == 1) {
                System.out.println(o.getKey());
            }

        }
        System.out.println();
        System.out.println("Проверка второго задания:");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("гаврилов", "896485645841");
        phoneBook.add("гаврилов", "8964856985841");
        phoneBook.add("Семёнов", "8964254536841");
        phoneBook.get("гаврилов");
        phoneBook.info();


    }


    public static HashMap<String, Integer> countWords(String[] strings) {

        HashMap<String, Integer> hm = new HashMap<>();
        for (String string : strings) {
            int repeatCount = 1;
            if (hm.containsKey(string)) {
                repeatCount = hm.get(string) + 1;
            }
            hm.put(string, repeatCount);
        }

        return hm;

    }
}
