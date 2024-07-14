package ru.job4j.oop;

public class OuterClass {

    class NestedClass { }

    static class StaticNestedClass { }

    public static void main(String[] args) {
        OuterClass outerObject = new OuterClass();
        OuterClass.NestedClass innerObject = outerObject.new NestedClass();
        StaticNestedClass staticNestedClass = new StaticNestedClass();
    }

}
