package ru.job4j.tracker.singleton.lazy;

import ru.job4j.tracker.Item;

public class TrackerHolder {

    public TrackerHolder() {
    }

    public static TrackerHolder getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerHolder INSTANCE = new TrackerHolder();
    }

    public static void main(String[] args) {
        TrackerHolder tracker = TrackerHolder.getInstance();
    }

}
