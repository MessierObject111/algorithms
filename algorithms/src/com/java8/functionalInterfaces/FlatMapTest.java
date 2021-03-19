package com.java8.functionalInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapTest {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1, 2);
        List<Integer> l2 = Arrays.asList(3, 4);

        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(l1);
        listOfLists.add(l2);

        List<Integer> flattenedList;
        List<Integer> flattenedAndAddList;
        flattenedList = listOfLists.stream().flatMap(ns->
            ns.stream()
        ).collect(Collectors.toList());
        System.out.println(flattenedList);

//        flattenedAndAddList =
                listOfLists.stream().flatMap(n -> {
            return n.stream().map(m->m+1);
        }).forEach(System.out::println);
//                .collect(Collectors.toList());
//        System.out.println(flattenedAndAddList);
    }
}
