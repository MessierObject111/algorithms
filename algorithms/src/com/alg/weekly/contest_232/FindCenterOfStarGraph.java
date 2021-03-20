package com.alg.weekly.contest_232;

import java.util.*;
import java.util.stream.Collectors;

// Problem 2
public class FindCenterOfStarGraph {
    // This solution, although logically correct, give me a StackOverflow error in test when center > 5000 and n = 1M
    // I am utterly surprised about it, and spent days researching why. It revealed the low-level HashMap impl in Java.
    public int findCenter(int[][] edges) {
        Map<Integer, Set<Integer>> existing = new HashMap<>();// key is node index; value is the set of connected nodes
        long start = System.currentTimeMillis();
        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int node_1 = edge[0];
            int node_2 = edge[1];
            // Check if Node 1 already exist in map; if yes, simply add Node 2 into the set of connected nodes
            if(existing.get(node_1) != null) {
                Set<Integer> linksTo = existing.get(node_1);
                linksTo.add(node_2);
            } else { // .. if not, create a new set that contains node 2 only, and put them into existing map
                HashSet<Integer> linksTo = new HashSet<>(node_2);
                linksTo.add(node_2);
                existing.put(node_1, linksTo);
            }

            if(existing.get(node_2) != null) {
                Set<Integer> linksTo = existing.get(node_2);
                linksTo.add(node_1);
            } else {
                HashSet<Integer> linksTo = new HashSet<>(node_1);
                linksTo.add(node_1);
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

    // This is the solution that accepted by leetcode without reporting StackOverflow/Out of memory space.
    // The solution above using Set<Integer> somehow negatively impacted the performance in bottom level java
    //implementation nature when integers were used as key in hashmap.
    // UPDATE: It has nothing to do with using Integers. It was my code mistakenly called new HashSet<>(center) that
    // caused the initial capacity of HashSet to be accidentally related with center value. We can use Integer.
    public int findCenterByStr(int[][] edges) {
        Map<String, Set<String>> existing = new HashMap<>();// key is node index; value is the set of connected nodes
        long start = System.currentTimeMillis();
        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            String node_1 = String.valueOf(edge[0]);
            String node_2 = String.valueOf(edge[1]);
            // Check if Node 1 already exist in map; if yes, simply add Node 2 into the set of connected nodes
            if(existing.get(node_1) != null) {
                Set<String> linksTo = existing.get(node_1);
                linksTo.add(String.valueOf(node_2));
            } else { // .. if not, create a new set that contains node 2 only, and put them into existing map
                HashSet<String> linksTo = new HashSet<>();
                linksTo.add(node_2);
                existing.put(node_1, linksTo);
            }

            if(existing.get(node_2) != null) {
                Set<String> linksTo = existing.get(node_2);
                linksTo.add(node_1);
            } else {
                HashSet<String> linksTo = new HashSet<>();
                linksTo.add(node_1);
                existing.put(node_2, linksTo);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Time cost for iterating array: " + (end - start));
        Set<Map.Entry<String, Set<String>>> entries = existing.entrySet();
        int center;
        List<Map.Entry<String, Set<String>>> list =
                entries.stream().
                        filter(e -> e.getValue().size() > 1)
                        .collect(Collectors.toList());

        if(list.isEmpty()) return 0;
        center = Integer.valueOf(list.get(0).getKey());
        return center;
    }

    public static void main(String[] args) {

        FindCenterOfStarGraph s = new FindCenterOfStarGraph();
        // Test case 1
//        int[][] edges = {{1,2},{2,3}};
//        System.out.println(s.findCenter(edges));

        // Test case 2
        int n = 1000000;//1 million
        int center = 5000;
        int[][] edges_2 = new int[n][2];
        //Populating a 2D edges array with n x 2 size, which describes a graph with center at @center
        for(int i = 0; i < n; i++) {
            int[] temp = new int[2];
            temp[0] = center;
            temp[1] = i;
            edges_2[i] = temp;
        }
        System.out.println(s.findCenterByStr(edges_2));

        // Test case by String array method below
//        int n = 1000000;
//        int center = 5000;
//        String[][] stringEdges = new String[n][2];
//        for(int i = 0; i < n; i++) {
//            String[] temp = new String[2];
//            temp[0] = "" + center;
//            temp[1] = "" + i;
//            stringEdges[i] = temp;
//        }
//        System.out.println(s.findCenterStrInput(stringEdges));
    }


    public int findCenterStrInput(String[][] edges) {
        Map<String, Set<String>> existing = new HashMap<>();// key is node index; value is the set of connected nodes
        long start = System.currentTimeMillis();
        for(int i = 0; i < edges.length; i++) {
            String[] edge = edges[i];
            String node_1 = edge[0];
            String node_2 = edge[1];
            // Check if Node 1 already exist in map; if yes, simply add Node 2 into the set of connected nodes
            if(existing.get(node_1) != null) {
                Set<String> linksTo = existing.get(node_1);
                linksTo.add(node_2);
            } else { // .. if not, create a new set that contains node 2 only, and put them into existing map
                HashSet<String> linksTo = new HashSet<>();
                linksTo.add(node_2);
                existing.put(node_1, linksTo);
            }

            if(existing.get(node_2) != null) {
                Set<String> linksTo = existing.get(node_2);
                linksTo.add(node_1);
            } else {
                HashSet<String> linksTo = new HashSet<>();
                linksTo.add(node_1);
                existing.put(node_2, linksTo);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Time cost for iterating array: " + (end - start));
        Set<Map.Entry<String, Set<String>>> entries = existing.entrySet();
        String center;
        List<Map.Entry<String, Set<String>>> list =
                entries.stream().
                        filter(e -> e.getValue().size() > 1)
                        .collect(Collectors.toList());

        if(list.isEmpty()) return 0;
        center = list.get(0).getKey();
        return Integer.valueOf(center);
    }
}
