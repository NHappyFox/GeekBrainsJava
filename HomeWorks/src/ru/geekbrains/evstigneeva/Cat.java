package ru.geekbrains.evstigneeva;

public class Cat implements Action {
    int maxJump;
    int maxRun;

    Cat(int maxJump, int maxRun) {
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    public void jump(int height) {

        if (height < maxJump) {
            System.out.println("Кот перепрыгнул стену высотой: " + height + " м");
        } else {
            System.out.println("Котик не смог перепрыгнуть стену высотой: " + height + " м" + " ,потому что недавно потолстел и не смог рассчитать свои силы");
        }
    }

    public void run(int length) {

        if (length <= maxRun) {
            System.out.println("Кот смог пробежать длину дорожки: " + length + " м");
        } else {
            System.out.println("Котик не смог пробежать длину дорожки: " + length + " м" + ". Он слишком жирненький для такой дистанции");
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
