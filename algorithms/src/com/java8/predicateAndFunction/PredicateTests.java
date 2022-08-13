package com.java8.predicateAndFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTests {
    public static void main(String[] args) {
        Predicate<Integer> greater_than_10 = x -> (x > 10);
        Predicate<Integer> smaller_than_10 = x -> (x < 10);
        // calling test method of the predicate
        System.out.println("result of smaller_than_10.test(7)");
        System.out.println(smaller_than_10.test(7));
        System.out.println("result of smaller_than_10.test(11)");
        System.out.println(smaller_than_10.test(11));
        System.out.println("result of greater_than_10.test(7)");
        System.out.println(greater_than_10.test(7));
        System.out.println("result of greater_than_10.test(11)");
        System.out.println(greater_than_10.test(11));
        System.out.println("greater_than_10.negate().test(11)");
        System.out.println(greater_than_10.negate().test(11));

        List<Integer> numList = new ArrayList<>();
        numList.add(5);
        numList.add(10);
        numList.add(15);
        numList.add(20);
        numList.add(25);
        numList.add(30);
        System.out.println("Printing list items that is greater than 10:");
        numList.stream().filter(greater_than_10).forEach(i -> System.out.println(i));

        Predicate<String> pred  = Predicate.isEqual("Educative");
        System.out.println("result of pred.test(\"educative \")");
        System.out.println(pred.test("educative "));
        System.out.println("result of pred.test(\"Educative\")");
        System.out.println(pred.test("Educative"));
    }
}
