package ru.geekbrains.evstigneeva;

public class Plate {
    private int food = 0;

    public Plate(int food) {
        if (food >= 0) {
            this.food = food;
        }
    }

    public void decreaseFood(int numbersFoodToEat) {
        if (numbersFoodToEat < food) {
            food -= numbersFoodToEat;
        } else {
            food = 0;
        }
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void addFood(int addFoods) {
        food = food + addFoods;
    }

    public int getFood() {
        return this.food;
    }


}
