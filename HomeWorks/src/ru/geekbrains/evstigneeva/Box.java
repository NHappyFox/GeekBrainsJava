package ru.geekbrains.evstigneeva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {

    public List<T> getList() {
        return list;
    }

    private List<T> list;

    public Box(T... obj) {
        list = Arrays.asList(obj);
    }

    public Box() {
        list = new ArrayList<T>();
    }

    public void add(T obj) {
        list.add(obj);
    }

    public void moveAt(Box<T> box) {

        box.getList().addAll(list);
        list.clear();
    }

    public void info() {
        if (list.isEmpty()) {
            System.out.println("Коробка пуста");
        } else {

            System.out.println("В коробке находятся " + orange.getName() + " в количестве: " + list.size());
        }
    }

    public float getWeight() {
        if (list.isEmpty()) {
            return 0;
        } else {
            return list.size() * list.get(0).getWeight();
        }
    }

    public boolean compare(Box<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();
    }

}
