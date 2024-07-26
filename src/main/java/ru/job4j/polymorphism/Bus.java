package ru.job4j.polymorphism;

public class Bus implements Transport {

    private static int pricePerLiter = 60;
    private int passengers;

    @Override
    public void move() {
        System.out.println("Автобус едет.");
    }

    @Override
    public void passengers(int count) {
        this.passengers = count;
    }

    @Override
    public int refuel(int fuel) {
        return fuel * pricePerLiter;
    }

}
