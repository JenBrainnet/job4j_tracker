package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class FunctionInterfaceUsage {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "New String For Interface";
        Consumer<String> consumer = (string) -> System.out.println(string);
        consumer.accept(supplier.get());
        BiConsumer<String, String> biConsumer =
                (first, second) -> System.out.println(first + second);
        biConsumer.accept(supplier.get(), " and Second String");
        System.out.println();

        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> setSupplier = () -> new HashSet<>(list);
        BiConsumer<Integer, String> integerStringBiConsumer =
                (first, second) -> System.out.println(first + second);
        Set<String> strings = setSupplier.get();
        int i = 1;
        for (String string : strings) {
            integerStringBiConsumer.accept(i++, " is " + string);
        }
        System.out.println();

        Predicate<String> predicate = (string) -> string.isEmpty();
        System.out.println("Строка пустая: " + predicate.test(""));
        System.out.println("Строка пустая: " + predicate.test("test"));
        BiPredicate<String, Integer> biPredicate =
                (string, number) -> string.contains(number.toString());
        System.out.println("Строка содержит подстроку: " + biPredicate.test("Name123", 123));
        System.out.println("Строка содержит подстроку: " + biPredicate.test("Name", 123));
        System.out.println();

        Function<String, Character> function = string -> string.charAt(2);
        System.out.println("Третий символ в строке: " + function.apply("first"));
        System.out.println("Третий символ в строке: " + function.apply("second"));
        BiFunction<String, Integer, String> biFunction =
                (string, number) -> string.concat(" ").concat(number.toString());
        System.out.println("Результат работы функции: " + biFunction.apply("Name", 123));
        System.out.println("Результат работы функции: " + biFunction.apply("String number", 12345));
        System.out.println();

        UnaryOperator<StringBuilder> unaryOperator = b -> b.reverse();
        System.out.println(
                "Строка после реверса: " + unaryOperator.apply(new StringBuilder("String for test"))
        );
        System.out.println(
                "Строка после реверса: " + unaryOperator.apply(new StringBuilder("tset rof gnirtS"))
        );
        BinaryOperator<StringBuilder> binaryOperator =
                (first, second) -> first.append(" ").append(second);
        System.out.println(
                "Строка после объединения: " + binaryOperator.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );
    }

}
