package ru.geekbrains.evstigneeva;

public class Dog extends Animal {

    private static int totalDog = 0;

    public Dog() {
        super(500, 10, 0.5F);
        totalDog = totalDog + 1;
    }

    @Override
    public int getTotalCount() {
        return totalDog;
    }
}
