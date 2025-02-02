package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class RefMethod {

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Ivan",
                "Petr Arsentev"
        );
        Consumer<String> consumer = string -> System.out.println(string);
        Consumer<String> refConsumer = System.out::println;
        names.forEach(refConsumer);
        Comparator<Integer> intComparator = (left, right) -> Integer.compare(left, right);
        Comparator<Integer> refIntComparator = Integer::compare;
        Consumer<String> out = RefMethod::cutOut;
        names.forEach(out);
    }

    public static void cutOut(String value) {
        if (value.length() > 10) {
            System.out.println(value.substring(0, 10) + "..");
        } else {
            System.out.println(value);
        }
    }

}
