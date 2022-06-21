package com.companies.meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        List<Point> list = new ArrayList<Point>();
        for(int i = 0; i < points.length; i++) {
            int[] point = points[i];
            Point p = new Point(point);
            list.add(p);
        }
        Collections.sort(list);
        List<Point> top = new ArrayList<Point>();
        for(int i = k; i > 0; i--) {
            top.add(list.get(i-1));
        }
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {
            int[] p = top.get(i).coordinates;
            res[i][0] = p[0];
            res[i][1] = p[1];
        }
        return res;
    }

    class Point implements Comparable{
        public int[] coordinates;

        public Point (int[] coordinates) {
            this.coordinates = coordinates;
        }

        public int getDistance() {
            return coordinates[0]*coordinates[0] + coordinates[1]*coordinates[1];
        }

        @Override
        public int compareTo(Object o) {
            Point p = (Point) o;
            return getDistance() - p.getDistance();
        }
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
