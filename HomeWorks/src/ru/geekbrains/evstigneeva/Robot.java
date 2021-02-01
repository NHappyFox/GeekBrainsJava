package ru.geekbrains.evstigneeva;

public class Robot implements Action {

    int maxJump;
    int maxRun;

    Robot(int maxJump, int maxRun) {
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    public void jump(int height) {

        if (height < maxJump) {
            System.out.println("Робот перепрыгнул стену высотой: " + height + " м");
        } else {
            System.out.println("Робот не предназначен для прыжков");
        }
    }

    public void run(int length) {

        if (length <= maxRun) {
            System.out.println("Робот предназначен для бега");
        } else {
            System.out.println("Робот не предназначен для бега");
        }
    }


    @Override
    public void action(Barrier barrier) {

        switch (barrier.getType()) {
            case WALL:
                jump(barrier.getSize());
                break;
            //        }
            case RUN_TRACK:
                run(barrier.getSize());
                break;
        }
    }
}
