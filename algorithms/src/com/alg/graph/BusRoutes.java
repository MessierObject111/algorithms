package com.alg.graph;

import java.util.*;

/**
 * Example 1:
 *
 * Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * Output: 2
 * Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
 *
 * Example 2:
 *
 * Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * Output: -1
 */
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int[] sourceLocation = findSource(routes, source);
        Map<Set<Integer>, List<Integer>> routesMap = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            Set<Integer> key = new HashSet<>();
            List<Integer> val = new ArrayList<>();
            for(int j = 0; j < routes[i].length; j++) {
                key.add(routes[i][j]);
                val.add(routes[i][j]);
            }
            routesMap.put(key, val);
        }
//        List<Set<Integer>> path = findConnectionRoutes(routesMap, source, target);
        return -1;
    }

    private int[] findSource(int[][] routes, int source) {

        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j < routes[i].length; j++) {
                if(routes[i][j] == source) {
                    int[] res = {i, j};
                    return res;
                }
            }
        }
        return new int[]{-1, -1};
    }

    private List<Set<Integer>> findConnectionRoutes(Map<Set<Integer>, List<Integer>> routesMap,
                                                    Set<Integer> startSet,
                                                    Set<Integer> targetSet,
                                                    Set<Set<Integer>> visitedSet) {
        List<Set<Integer>> res = new ArrayList<>();

        return res;
    }
}
