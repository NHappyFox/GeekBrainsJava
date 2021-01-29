package ru.geekbrains.evstigneeva;

public class RunningTrack implements Barrier {

    private final int size;

    public RunningTrack(int length) {
        this.size = length;
    }

    public int getSize() {
        return size;
    }

    public BarrierType getType() {
        return BarrierType.RUN_TRACK;
    }

    public void trackRun(int length) {
        System.out.println("пробежал " + length + " м");
    }
}
