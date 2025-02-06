package ru.job4j.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapLambdaUsage {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "name");
        map.put(2, "top");
        map.put(3, "user");
        map.put(4, "precision");
        map.put(5, "post");

        System.out.println("replaceAll(BiFunction)");
        BiFunction<Integer, String, String> biFunction = (key, value) -> value + "_" + key;
        map.replaceAll(biFunction);
        map.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
        System.out.println();
        map.clear();

        System.out.println("computeIfPresent(Key, BiFunction)");
        map.put(1, "name");
        map.put(2, "top");
        String result = map.computeIfPresent(1, biFunction);
        System.out.println("Current value: " + result);
        map.forEach(
                (key, value) -> System.out.println("Key: " + key + ", value: " + value)
        );
        System.out.println();
        map.clear();

        System.out.println("computeIfAbsent(Key, Function");
        Map<String, Integer> strIntMap = new HashMap<>();
        Function<String, Integer> func = String::length;
        System.out.println(
                "Result: " + strIntMap.computeIfAbsent("Petr", func)
        );
        System.out.println(
                "Result: " + strIntMap.computeIfAbsent("Petr", key -> key.length() + 10)
        );
        strIntMap.forEach((key, value) ->
                System.out.println("Key: " + key + ", value:" + value));
        System.out.println();
        strIntMap.clear();

        System.out.println("merge(Key, Value, BiFunction)");
        Map<String, Integer> products = new HashMap<>();
        products.put("Shoes", 200);
        BiFunction<Integer, Integer, Integer> remappingFunction =
                (oldValue, newValue) -> oldValue - newValue;
        int newPrice = products.merge("Shoes", 50, remappingFunction);
        System.out.println(
                "New Shoes Price: " + newPrice
        );
        System.out.println(
                "Price of shirt: " + products.merge("Shirt", 100, remappingFunction)
        );
        products.forEach((key, value) ->
                System.out.println("Key: " + key + ", value:" + value));

    }

}
