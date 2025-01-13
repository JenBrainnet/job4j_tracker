package ru.job4j.collection;

import java.util.LinkedList;

public class UsageLinkedList {

    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add(0, "Petr");
        names.add(0, "Ivan");
        names.add(0, "Stepan");
        for (String name : names) {
            System.out.println(name);
        }
    }

}
