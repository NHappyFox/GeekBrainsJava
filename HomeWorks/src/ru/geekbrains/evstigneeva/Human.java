package ru.geekbrains.evstigneeva;

public class Human implements Action {

    int maxJump;
    int maxRun;

    Human(int maxJump, int maxRun) {
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    public void jump(int height) {

        if (height < maxJump) {
            System.out.println("Человек перепрыгнул стену высотой: " + height + " м");
        } else {
            System.out.println("Человек не смог перепрыгнуть стену высотой: " + height + " м");
        }
    }

    public void run(int length) {

        if (length <= maxRun) {
            System.out.println("Человек смог пробежать длину дорожки: " + length + " м");
        } else {
            System.out.println("Человек не смог пробежать длину дорожки: " + length + " м");
        }
    }


    @Override
    public void action(Barrier barrier) {       //        if (barrier.getType() == BarrierType.WALL){
        //            jump(barrier.getSize());
        switch (barrier.getType()) {            //            return;
            case WALL:                          //        }
                jump(barrier.getSize());        //        if (barrier.getType() == BarrierType.RUN_TRACK){
                break;                          //            run(barrier.getSize());
            //        }
            case RUN_TRACK:
                run(barrier.getSize());
                break;
        }
    }


}
