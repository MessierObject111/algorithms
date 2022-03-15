package com.alg.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap map = new LinkedHashMap();
        map.put("One", 1);
        map.put("Three", 3);
        map.put("Two", 2);

        map.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        map1.put('a', 1);
        map2.put('a', 1);
        System.out.println("map1 equals map2? "+ map1.equals(map2));//true
    }
}
