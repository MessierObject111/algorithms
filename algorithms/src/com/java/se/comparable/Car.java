package com.java.se.comparable;

import java.util.Comparator;

public class Car {
    private String manufacturer;
    private int mileage;
    private String color;

    public Car(String manufacturer, int mileage, String color) {
        this.manufacturer = manufacturer;
        this.mileage = mileage;
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
