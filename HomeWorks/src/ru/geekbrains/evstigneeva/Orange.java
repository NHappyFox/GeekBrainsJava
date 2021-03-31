package ru.geekbrains.evstigneeva;

public class Orange extends Fruit {

    private float weight = 1.5f;
    public String name = " Orange ";

    Orange(float weight) {
        super(weight);
    }

    public Orange() {
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
