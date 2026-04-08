package ru.job4j.tracker.singleton.lazy;

import ru.job4j.tracker.Item;

public class TrackerDCL {

    private static volatile TrackerDCL instance;

    public TrackerDCL() {
    }

    public static synchronized TrackerDCL getInstance() {
        if (instance == null) {
            synchronized (TrackerDCL.class) {
                if (instance == null) {
                    instance = new TrackerDCL();
                }
            }
        }
        return instance;
    }

    public Item add(Item item) {
        return item;
    }

    public static void main(String[] args) {
        TrackerDCL tracker = TrackerDCL.getInstance();
    }

}
