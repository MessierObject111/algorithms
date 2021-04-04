package com.multiThread.demo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MakeThreadSafeSet {
    public static void main(String[] args) {
        Set set1 = Collections.synchronizedSet(new HashSet());


        Set set2 = Collections.newSetFromMap(new ConcurrentHashMap());


        ConcurrentHashMap map = new ConcurrentHashMap();
        Set set3 = ConcurrentHashMap.newKeySet();
    }
}
