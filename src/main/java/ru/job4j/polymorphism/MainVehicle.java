package ru.job4j.polymorphism;

public class MainVehicle {

    public static void main(String[] args) {
        SportCar sportCar = new SportCar();
        Vehicle vehicle = sportCar;
        Fuel fuel = sportCar;
        vehicle.changeGear();
        vehicle.accelerate();
        vehicle.steer();
        vehicle.brake();
        fuel.refill();
        vehicle.chargeBattery();
        Vehicle townCar = new TownCar();
        townCar.changeGear();
        townCar.refill();
        townCar.chargeBattery();
        Vehicle.getDragCoefficient();
    }

}
