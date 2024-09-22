package com.java.se.comparable;

import java.util.Comparator;
public class CarComparatorByMileage implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.getMileage(), o2.getMileage());
    }
}
