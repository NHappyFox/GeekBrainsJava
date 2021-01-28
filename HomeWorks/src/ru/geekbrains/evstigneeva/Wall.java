package ru.geekbrains.evstigneeva;

public class Wall implements Barrier {

    private final int size;

    public Wall(int height) {
        this.size = height;
    }

    public int getSize() {
        return size;
    }

    public BarrierType getType() {
        return BarrierType.WALL;
    }

    public void barrierWall(int heightBarrier) {
        System.out.println("Впереди препятствие в виде стены высотой " + heightBarrier + " м");
    }


}
