package com.java8.stream.sortArray;

import java.util.Arrays;
import java.util.Comparator;

public class StreamSortTest {
    public static void main(String[] args) {

        int[] input = {55720,349290,688809,868579};
        int[][] intervals = {{1,10},{2,7},{3,19},{8,12},{10,20},{11,30}, {14, 25}, {30, 35}};
        String[] names = {"Adam", "Bella", "Charlie", "Denice", "Eric", "Fiona", "Greg", "Hellen", "Ian"};

        int maxInt = Arrays.stream(input).map(i->i).max().getAsInt();
        long maxLong = Arrays.stream(input).asLongStream().max().getAsLong();

        Comparator<String> sortByCustomLogic = (a, b)-> {
            return (a + b).compareTo(b + a);
        };
        int[] sorted = Arrays.stream(input)
                .mapToObj(Integer::toString)
                .sorted(sortByCustomLogic)
                .mapToInt(i-> Integer.parseInt(i))
                .toArray();

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // This cannot be used for primitive types
//        Arrays.sort(input, Comparator.comparingInt(a -> {
//            return 0;
//        }));
        Arrays.sort(names, Comparator.comparingInt(a -> Integer.parseInt(a)));

        System.out.println(maxLong);
    }
}
