package com.alg.java.se.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ComparatorSortTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Abc");
        list.add("BCD");

        Collections.sort(list);

        for(String item: list) {
            System.out.println(item);
        }
    }
}
