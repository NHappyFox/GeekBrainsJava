package ru.geekbrains.evstigneeva;

public class Cat {
    private String name;
    private boolean fullness = false;
    private int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        if (appetite <= plate.getFood()) {
            fullness = true;
            plate.decreaseFood(appetite);
        }
    }

    public void fullnessInfo() {
        System.out.println("Name cat: " + name + ", fullness: " + fullness);
    }
}
