package ru.geekbrains.evstigneeva;

public class Animal {
    private static int totalAnimalCount = 0;
    private final int maxLengthRun;
    private final int maxLengthSwim;
    private final float maxLengthJump;

    public Animal(int maxLengthRun, int maxLengthSwim, float maxLengthJump) {
        this.maxLengthRun = (int) (maxLengthRun * Math.random());
        this.maxLengthSwim = (int) (maxLengthSwim * Math.random());
        this.maxLengthJump = (float) (maxLengthJump * Math.random());
        totalAnimalCount = totalAnimalCount + 1;
    }

    public void run(int length) {
        if (length <= maxLengthRun) {
            System.out.println("Животное пробежало " + length + " м");
        } else {
            System.out.println("Животное не побежало");
        }
    }

    public void swim(int lengthWatter) {
        if (lengthWatter <= maxLengthSwim) {
            System.out.println("Животное проплыло " + lengthWatter + " м");
        } else {
            System.out.println("Животное не стало плыть");
        }
    }

    public void jump(float lengthJump) {

        if (lengthJump <= maxLengthJump) {
            System.out.println("Животное прыгнуло " + lengthJump + " м");
        } else {
            System.out.println("Животное слишком толстенькое, чтобы прыгнуть");
        }
    }

    public int getTotalCount() {
        return totalAnimalCount;
    }
}

