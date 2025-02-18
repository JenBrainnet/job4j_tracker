package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OfUsage {

    public static void main(String[] args) {
        System.out.print("List.of() : ");
        List.of(5, 1, 2)
                .forEach(System.out::print);
        System.out.print("\nSet.of() : ");
        Set.of(5, 1, 2)
                .forEach(System.out::print);
        System.out.println("\nMap.of() : ");
        Map.of("first", 1, "second", 2)
                .forEach((key, value) -> System.out.println(key + " " + value));
    }

}
