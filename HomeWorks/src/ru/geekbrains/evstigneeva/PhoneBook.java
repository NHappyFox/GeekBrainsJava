package ru.geekbrains.evstigneeva;


import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    HashMap<String, ArrayList<String>> phoneBoook = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        ArrayList<String> phoneList = phoneBoook.get(lastName);
        if (phoneList == null) {
            phoneList = new ArrayList<>();
        }
        phoneList.add(phoneNumber);
        phoneBoook.put(lastName, phoneList);
    }

    public ArrayList<String> get(String lastName) {

        return phoneBoook.get(lastName);
    }

    public void info() {
        System.out.println("Номера телефонов под запрашиваемой фамилией" + phoneBoook.get("гаврилов"));
    }
}

