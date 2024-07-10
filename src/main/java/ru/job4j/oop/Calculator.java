package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + multiply(y) + divide(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int y = 10;
        Calculator.sum(y);
        sum(y);
        Calculator.minus(y);
        minus(y);
        calculator.multiply(y);
        calculator.divide(y);
        calculator.sumAllOperation(y);
    }

}
