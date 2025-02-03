package ru.job4j.lambda;

@FunctionalInterface
public interface ThrowingConsumer<T> {

    void accept(T t) throws Exception;

}
