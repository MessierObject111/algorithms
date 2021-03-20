package com.alg.other;

import java.util.*;
import java.util.stream.Collectors;

public class IntegerAsHashKeyPerformanceTest {
    public int findCenter(int[][] edges) {
        Map<Integer, Set<Integer>> existing = new HashMap<>();// key is node index; value is the set of connected nodes
        long start = System.currentTimeMillis();
        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int center = edge[0];
            int node_2 = edge[1];
            // Check if Node 1 already exist in map; if yes, simply add Node 2 into the set of connected nodes
            if(existing.get(center) != null) {
                Set<Integer> linksTo = existing.get(center);
                linksTo.add(node_2);
            } else { // .. if not, create a new set that contains node 2 only, and put them into existing map
                HashSet<Integer> linksTo = new HashSet<>(node_2);
                linksTo.add(node_2);
                existing.put(center, linksTo);
            }

            if(existing.get(node_2) != null) {
                Set<Integer> linksTo = existing.get(node_2);
                linksTo.add(center);
            } else {
                HashSet<Integer> linksTo = new HashSet<>();
                linksTo.add(center);
                existing.put(node_2, linksTo);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Time cost for iterating array: " + (end - start));
        Set<Map.Entry<Integer, Set<Integer>>> entries = existing.entrySet();
        int center;
        List<Map.Entry<Integer, Set<Integer>>> list =
                entries.stream().
                        filter(e -> e.getValue().size() > 1)
                        .collect(Collectors.toList());

        if(list.isEmpty()) return 0;
        center = list.get(0).getKey();
        return center;
    }

    public static void main(String[] args) {
        IntegerAsHashKeyPerformanceTest sol = new IntegerAsHashKeyPerformanceTest();
        Set<Integer> integerSet = new HashSet<>();
        Set<String> stringSet = new HashSet<>();
        int length = 1000000;

        long start = System.currentTimeMillis();
        for(int i = 0; i < length; i++){
            integerSet.add(i);
        }

        long end = System.currentTimeMillis();
        System.out.println("Integer set time spent: " + (end - start));

        start = System.currentTimeMillis();
        for(int i = 0; i < length; i++){
            stringSet.add(String.valueOf(i));
        }
        end = System.currentTimeMillis();
        System.out.println("String set time spent: " + (end - start));

        Map<Integer, Integer> integerMap = new HashMap<>();
        Map<String, Integer> stringMap = new HashMap<>();

        start = System.currentTimeMillis();
        for(int i = 0; i < length; i++){
            integerMap.put(i, i);
        }
        end = System.currentTimeMillis();
        System.out.println("Integer map time spent: " + (end - start));

        start = System.currentTimeMillis();
        for(int i = 0; i < length; i++){
            stringMap.put(String.valueOf(i), i);
        }
        end = System.currentTimeMillis();
        System.out.println("String map time spent: " + (end - start));

        //Adding Sets to HashMap
        Map<Integer, Set<Integer>> intKeySetValueMap = new HashMap<>();
        start = System.currentTimeMillis();
        for(int i = 0; i < length; i++){
            HashSet<Integer> newSet = new HashSet<>();
            newSet.add(i);
            intKeySetValueMap.put(i, newSet);

            Set<Integer> existingSet = intKeySetValueMap.get(0);
            existingSet.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Integer-Set<Integer> map time spent: " + (end - start));

        Map<String, Set<String>> strKeySetValueMap = new HashMap<>();

        int center = 1000;
        int[][] edges = new int[length][2];
        for(int i = 0; i < length; i++) {
            int[] temp = edges[i];
            temp[0] = center;
            temp[1] = i;
        }
        start = System.currentTimeMillis();
        System.out.println(sol.findCenter(edges));
        end = System.currentTimeMillis();
        System.out.println("Find center time spent: " + (end - start));
    }
}
