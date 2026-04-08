package ru.job4j.tracker.singleton.lazy;

import ru.job4j.tracker.Item;

public class TrackerSynchronized {

    private static TrackerSynchronized instance;

    public TrackerSynchronized() {
    }

    public static synchronized TrackerSynchronized getInstance() {
        if (instance == null) {
            instance = new TrackerSynchronized();
        }
        return instance;
    }

    public Item add(Item item) {
        return item;
    }

    public static void main(String[] args) {
        TrackerSynchronized tracker = TrackerSynchronized.getInstance();
    }

}
