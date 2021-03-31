package ru.geekbrains.evstigneeva;

public class Apple extends Fruit {

    private float weight = 1.0f;
    public String name = " Apple ";

    Apple(float weight) {
        super(weight);
    }

    public Apple() {
        super();
    }

    @Override
    public float getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
