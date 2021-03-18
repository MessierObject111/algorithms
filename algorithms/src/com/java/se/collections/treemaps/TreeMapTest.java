package com.java.se.collections.treemaps;

import java.util.HashMap;
import java.util.TreeMap;

public class TreeMapTest {
    private static HashMap<String, Integer> hashMap;
    private static TreeMap<String, Integer> treeMap;

    public static void main(String[] args) {
        hashMap = new HashMap<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);
        hashMap.put("Four", 4);
        hashMap.put("Five", 5);
        hashMap.put("Six", 6);
        hashMap.put("Seven", 7);

        treeMap = new TreeMap<>();
        treeMap.put("One", 1);
        treeMap.put("Two", 2);
        treeMap.put("Three", 3);
        treeMap.put("Four", 4);
        treeMap.put("Five", 5);
        treeMap.put("Six", 6);
        treeMap.put("Seven", 7);

        hashMap.forEach((k, v) -> {
            System.out.println(k + "-" + v);
        });

        treeMap.forEach((k, v) -> {
            System.out.println(k + "-" + v);
        });

    }
}
