package com.alg.weekly.contest_232;

import java.util.*;
import java.util.stream.Collectors;

// Problem 2
public class FindCenterOfStarGraph {
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

    public static void main(String[] args) {

        FindCenterOfStarGraph s = new FindCenterOfStarGraph();
//        int[][] edges = {{1,2},{2,3}};
//        System.out.println(s.findCenter(edges));

        int n = 999999;
        int center = 5000;
        int[][] edges_2 = new int[n][2];
        for(int i = 0; i < n; i++) {
            int[] temp = new int[2];
            temp[0] = center;
            temp[1] = i;
            edges_2[i] = temp;
        }
        System.out.println(s.findCenter(edges_2));
    }
}
