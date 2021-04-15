package ru.geekbrains.evstigneeva;

public class Apple extends Fruit {

    public Apple(float weight) {
        super(weight);
    }

    public Apple() {
        super("Apple",1.0f);
    }

    @Override
    public float getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
