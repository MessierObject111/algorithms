package com.alg.map;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap map = new LinkedHashMap();
        map.put("One", 1);
        map.put("Three", 3);
        map.put("Two", 2);

        map.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }
}
