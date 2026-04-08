package ru.job4j.tracker.singleton.eager;

import ru.job4j.tracker.Item;

public enum TrackerEnum {

    INSTANCE;

    public Item add(Item item) {
        return item;
    }

    public static void main(String[] args) {
        TrackerEnum tracker = TrackerEnum.INSTANCE;
    }

}
