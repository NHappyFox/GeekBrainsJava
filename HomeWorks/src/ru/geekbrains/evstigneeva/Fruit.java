package ru.geekbrains.evstigneeva;

public class Fruit {

    public float weight;
    public String name = " Fruit ";

    Fruit(float weight) {
        this.weight = weight;
    }

    public Fruit() {

    }

    public float getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
