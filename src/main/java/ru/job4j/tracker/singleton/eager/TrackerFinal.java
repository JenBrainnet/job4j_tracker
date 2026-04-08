package ru.job4j.tracker.singleton.eager;

import ru.job4j.tracker.Item;

public class TrackerFinal {

    private static final TrackerFinal INSTANCE = new TrackerFinal();

    public TrackerFinal() {
    }

    public static TrackerFinal getInstance() {
        return INSTANCE;
    }

    public Item add(Item item) {
        return item;
    }

    public static void main(String[] args) {
        TrackerFinal tracker = TrackerFinal.getInstance();
    }

}
