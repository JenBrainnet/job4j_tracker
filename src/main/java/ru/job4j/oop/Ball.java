package ru.job4j.oop;

public class Ball {

    public void tryRun(boolean condition) {
        String message = condition
                ? "The Ball was eaten."
                : "The Ball ran away.";
        System.out.println(message);
    }

}
