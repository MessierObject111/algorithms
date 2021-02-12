package com.java8.functionalInterfaces;

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        // This function returns a random value.
        Supplier<Double> randomValue = () -> Math.random();

        // Print the random value using get()
        System.out.println(randomValue.get());
        System.out.println(randomValue.get());
        System.out.println(randomValue.get());
    }
}
