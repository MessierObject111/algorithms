package com.companies.meta;

import java.util.*;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> maxQueue = new PriorityQueue<>((a, b)->squareDistance(a)-squareDistance(b));
        //Same as new PriorityQueue<>(Comparator.comparingInt(this::squareDistance));
        for(int i = 0; i < points.length; i++) {
            maxQueue.add(points[i]);
        }
        for(int i = 0; i < k; i++){
            int[] p = maxQueue.poll();
            res[i] = p;
        }
        return res;
    }

    private int squareDistance(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }

    public static void main(String[] args) {
        int[][] points = {{7, 3}, {5, -6}, {-3, -4}, {-1, 3}};
        int k = 2;
        KClosestPointsToOrigin sol = new KClosestPointsToOrigin();
        int[][] res = sol.kClosest(points, k);
        for(int i = 0; i < k; i++) {
            System.out.println("[" + res[i][0] + ", "+ res[i][1]+"]");
        }
    }
}
