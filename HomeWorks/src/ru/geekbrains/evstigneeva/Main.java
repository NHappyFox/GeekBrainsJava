package ru.geekbrains.evstigneeva;

public class Main {
    public static void main(String[] args) {

//        Human human = new Human();
//        human.jump(1);
//        human.run(100);
//        System.out.println();
//
//        Cat cat = new Cat();
//        cat.jumpCat(2);
//        cat.runCat(300);
//        System.out.println();
//
//        Robot robot = new Robot();
//        robot.jumpRob(3);
//        robot.runRob(1000);
//        System.out.println();
//
//        Wall wall = new Wall();
//        wall.barrierWall(2);
//        System.out.println();
//
//        RunningTrack runningTrack = new RunningTrack();
//        runningTrack.trackRun(5000);
//        System.out.println();
        Barrier barrier[] = new Barrier[2];

        RunningTrack runningTrack = new RunningTrack(100);
        Wall wall = new Wall(3);
        barrier[0] = runningTrack;
        barrier[1] = wall;

        Human humans[] = new Human[2];
        humans[0] = new Human(4, 99);
        humans[1] = new Human(2, 101);

        for (int i = 0; i < humans.length; i++) {
            for (int j = 0; j < barrier.length; j++) {
                humans[i].action(barrier[j]);
            }
        }

        Cat cats[] = new Cat[3];
        cats[0] = new Cat(1, 200);
        cats[1] = new Cat(2, 99);
        cats[2] = new Cat(4, 200);

        for (int x = 0; x < cats.length; x++) {
            for (int e = 0; e < barrier.length; e++) {
                cats[x].action(barrier[e]);
            }
        }

        Robot robots[] = new Robot[3];
        robots[0] = new Robot(1, 200);
        robots[1] = new Robot(0, 0);
        robots[2] = new Robot(4, 99);

        for (int y = 0; y < robots.length; y++) {
            for (int u = 0; u < barrier.length; u++) {
                robots[y].action(barrier[u]);
            }
        }
    }


}
