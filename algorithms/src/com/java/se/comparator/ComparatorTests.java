package com.java.se.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTests {
    public static void main(String[] args) {
        Integer[] array = {3, 5, 9, 2, 1, 7, 8, 0, 4, 6};
        int[][] intervals = {{0,30},{5,10},{15,20}};
        //1. Comparator with Arrays.sort()
        //Same as Arrays.sort(array, (a, b)-> b - a);
        Arrays.sort(array, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // Order by increasing order of the first element
                return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < array.length; i++){
            if(i != array.length - 1) System.out.print(array[i] + " - ");
            else System.out.print(array[i]);
        }
        System.out.println();
        for(int i = 0; i < intervals.length; i++){
            System.out.println(intervals[i][0] + " - " + intervals[i][1]);
        }
    }
}
