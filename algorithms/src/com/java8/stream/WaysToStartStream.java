package com.java8.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WaysToStartStream {
    public static void main(String[] args) {
        long count1 = Stream.iterate(0, n->n+1).limit(1000)
                .filter(integer -> integer%2 == 0)
                .count();

        List<Integer> list1 = IntStream.range(0,1000)
                .filter(integer -> integer%2 == 0)
                .boxed()
                .collect(Collectors.toList());

        int[] list2 = IntStream.range(0,1000)
                .filter(integer -> integer%2 == 0)
                .toArray();
    }
}
