package ru.geekbrains.evstigneeva;

public class Cat extends Animal {

    private static int totalCat = 0;

    public Cat() {
        super(200, 0, 2);
        totalCat = totalCat + 1;
    }

    @Override
    public int getTotalCount() {
        return totalCat;
    }
}
