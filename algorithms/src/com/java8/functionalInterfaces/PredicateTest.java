package com.java8.functionalInterfaces;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        // Creating predicate
        Predicate<Integer> lesserthan = i -> (i < 18);

        // Calling Predicate method
        System.out.println(lesserthan.test(10));
        System.out.println(lesserthan.test(20));

        Predicate<Integer> greaterThan = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= 18;
            }
        };

        // Calling Predicate method
        System.out.println(greaterThan.test(10));
        System.out.println(greaterThan.test(20));
    }
}
