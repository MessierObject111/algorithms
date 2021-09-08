package com.java.se.inheritancePolymorphism.question6;

public class Test1 {
    public static void main(String[] args) {
        Car car = new Car();

        car.setLicensePlate("123");
        car.licensePlate = "abc";

        System.out.println("Super class license plate: "
                + car.getLicensePlate());

        System.out.println("Car class license plate: "
                + car.licensePlate);
    }
}
