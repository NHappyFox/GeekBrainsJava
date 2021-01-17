package ru.geekbrains.evstigneeva;

public class Animal {
    private static int totalAnimalCount = 0;
    private final int maxLengthRun;
    private final int maxLengthSwim;

    public Animal(int maxLengthRun, int maxLengthSwim) {
        this.maxLengthRun = maxLengthRun;
        this.maxLengthSwim = maxLengthSwim;
        totalAnimalCount = totalAnimalCount + 1;
    }

    public void run(int length) {
        if (length <= maxLengthRun) {
            System.out.println("Животно епробежало" + length);
        }
    }

    public void swim(int lengthWatter) {
        if (lengthWatter <= maxLengthSwim) {
            System.out.println("Животное проплыло " + lengthWatter);
        }
    }

    public int getTotalCount() {
        return totalAnimalCount;
    }
}

