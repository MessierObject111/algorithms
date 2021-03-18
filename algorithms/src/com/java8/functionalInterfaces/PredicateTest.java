package com.java8.functionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {
    /**
     * A Predicate interface represents a boolean-valued-function of an argument. This is mainly used to filter data
     * from a Java Stream. The filter method of a stream accepts a predicate to filter the data and return a new stream
     *
     * satisfying the predicate. A predicate has a test() method which accepts an argument and returns a boolean value.
     * @param args
     */
    public static void main(String[] args) {
        // Creating predicate with lambda
        Predicate<Integer> lesserthan = i -> (i < 18);

        // Calling Predicate method
        System.out.println(lesserthan.test(10));
        System.out.println(lesserthan.test(20));

        // Creating predicate with anonymous inner class
        Predicate<Integer> greaterThan = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= 18;
            }
        };

        // Calling Predicate method
        System.out.println(greaterThan.test(10));
        System.out.println(greaterThan.test(20));

        // Test case: filter strings
        List<String> names = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
        Predicate<String> nameStartsWithS = str -> str.startsWith("S");
        names.stream().filter(nameStartsWithS).forEach(System.out::println);

        // Test case: filter integers
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> collect = list.stream().filter(x -> x > 5).collect(Collectors.toList());

        System.out.println(collect); // [6, 7, 8, 9, 10]
    }
}
