package ru.job4j.function;

import java.util.Arrays;
import java.util.Comparator;

public class DeferredExecutionExample {

    public static void main(String[] args) {
        String[] names = {
                "Ivan"
        };
        Comparator<String> lengthComparator = (left, right) -> {
            System.out.println("execute comparator");
            return Integer.compare(left.length(), right.length());
        };
        System.out.println("Sort with array.length: " + names.length);
        Arrays.sort(names, lengthComparator);
        names = Arrays.copyOf(names, 2);
        names[1] = "Petr";
        System.out.println("Sort with array.length: " + names.length);
        Arrays.sort(names, lengthComparator);
    }

}
