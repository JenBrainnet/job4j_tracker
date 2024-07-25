package ru.job4j.polymorphism;

import ru.job4j.oop.Car;

interface Parking<T> {

    void park(T car);

}

public class CarParking implements Parking<Car> {

    public void park(Car car) { }

}
