package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class MatchExample {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        boolean noneResult = strings
                .stream()
                .noneMatch("Шесть"::contains);
        System.out.println(noneResult);
        boolean anyResult = strings
                .stream()
                .anyMatch(element -> element.endsWith("ь"));
        System.out.println(anyResult);
        strings = Arrays.asList("Трижды", "Три", "Триста", "Три тысячи");
        boolean allResult = strings
                .stream()
                .allMatch(element -> element.startsWith("Три"));
        System.out.println(allResult);
    }

}
