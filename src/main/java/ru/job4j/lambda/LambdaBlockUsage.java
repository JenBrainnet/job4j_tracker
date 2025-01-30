package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaBlockUsage {

    public static void main(String[] args) {
        List<String> numbers = Arrays.asList(
                "11. Task",
                "2. Task",
                "1. Task"
        );
        Comparator<String> debugComparator = (left, right) -> {
            int first = Integer.valueOf(left.substring(0, left.indexOf(".")));
            int second = Integer.valueOf(right.substring(0, right.indexOf(".")));
            System.out.println("compare - " + first + " : " + second);
            return Integer.compare(first, second);
        };
        numbers.sort(debugComparator);
        System.out.println(numbers);
    }

}
