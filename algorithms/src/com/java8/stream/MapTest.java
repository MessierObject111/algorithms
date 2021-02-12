package com.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapTest {
    public static void main(String[] args) {


        (Arrays.asList(1, 2, 3)).stream().map(number -> {
            return 2 * number;
        }).collect(Collectors.toList())
                .stream().forEach(num -> System.out.println(num));

        // Pit falls: Operator '*' cannot be applied to 'int[]', 'int'
        //Because the misuse of Arrays.asList() here

//        int[] list = {1, 2, 3, 4, 5};
//        (Arrays.asList(list)).stream().map(number -> {
//            return 2 * number;
//        }).collect(Collectors.toList());

        List<String> names = Arrays.asList("Ronnie","Max","Eric");
        names.stream().map(s -> s.length()).collect(Collectors.toList())
                .stream().forEach(num -> System.out.println(num));

    }
}
