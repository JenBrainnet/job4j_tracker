package ru.job4j.lambda;

import java.util.function.Consumer;

public class LambdaEx {

    public static void main(String[] args) {
        Consumer<String> consumer = handleException(str -> {
            int result = Integer.parseInt(str);
            System.out.println("Parsed number: " + result);
        });
        consumer.accept("123");
        consumer.accept("abc");

        ThrowingConsumer<String> throwingConsumer = str -> {
            if (str.equals("error")) {
                throw new Exception("Error occurred!");
            }
            System.out.println("Processing: " + str);
        };
        throwingExceptionWrapper(throwingConsumer).accept("test");
        throwingExceptionWrapper(throwingConsumer).accept("error");
    }

    public static <T> Consumer<T> handleException(Consumer<T> consumer) {
        return (T t) -> {
            try {
                consumer.accept(t);
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
        };
    }

    public static <T> Consumer<T> throwingExceptionWrapper(ThrowingConsumer<T> throwingConsumer) {
        return (T t) -> {
            try {
                throwingConsumer.accept(t);
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
        };
    }

}
