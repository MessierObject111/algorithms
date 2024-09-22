package com.java.se.comparable;

import java.util.Comparator;

public class Car {
    private String manufacturer;
    private int mileage;
    private String color;
    private double price;

    public Car(String manufacturer, int mileage, String color, double price) {
        this.manufacturer = manufacturer;
        this.mileage = mileage;
        this.color = color;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
