package com.java8.predicateAndFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionClassTests {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        numList.add(78);
        numList.add(10);
        Function<Integer, Integer> fun = i -> i / 2;
        //Using .map() here
        numList.stream().map(fun).forEach(System.out::println);
    }
}
