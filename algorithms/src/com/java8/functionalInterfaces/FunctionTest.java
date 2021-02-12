package com.java8.functionalInterfaces;

import java.util.function.Function;

public class FunctionTest {
    // The Function interface has only one single method apply().
    // It can accept an object of any data type and returns a result of any datatype.
    public static void main(String[] args) {
        Function function = i -> { return "Location: " + i;};
        System.out.println(function.apply(" China"));

        String[] countries = {"India", "Australia", "England", "South Africa", "Sri Lanka", "New Zealand", "West Indies", "Scotland"};
        Function<String[], String> converter = (all) -> {  // lambda expression
            String names = "";
            for(String name : all) {
                names += name + "\n";
            }
            return names;
        };
        System.out.println(converter.apply(countries));
    }
}
