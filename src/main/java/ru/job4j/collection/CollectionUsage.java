package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionUsage {

    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        collection.add("three");
        Collection<String> list = new ArrayList<>();
        list.add("two");
        for (String string : collection) {
            System.out.println(string);
        }
        collection.retainAll(list);
        System.out.println("Вывод содержимого коллекции после вызова retainAll()");
        for (String string : collection) {
            System.out.println(string);
        }
        System.out.println("Размер коллекции равен: " + collection.size());
        System.out.println("Коллекция содержит элемент two: " + collection.contains("two"));
        System.out.println("Содержимое в виде массива: " + Arrays.toString(collection.toArray()));
        collection.clear();
        System.out.println("Коллекция после очистки пуста: " + collection.isEmpty());
    }

}
