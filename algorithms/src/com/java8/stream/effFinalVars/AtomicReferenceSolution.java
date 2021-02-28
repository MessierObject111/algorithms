package com.java8.stream.effFinalVars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 */
public class AtomicReferenceSolution {
    public String streamTest () {
        AtomicReference<String> res = new AtomicReference<>();
        String nonEffFinalStr = "";
        Set<String> entries = new HashSet<>();
        entries.add("A");
        entries.add("B");
        entries.add("C");
        entries.add("D");
        entries.add("E");
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Arrays.stream(ints).forEach(sub -> {
            if(sub == 7) {
                res.set("YES");
//                nonEffFinalStr = "YES";
            }
        });
        //Char array not allowed for stream autoboxing: will show compile error
//        Arrays.stream(s.toCharArray())


        if(res.get() != null) return res.get();
        return "NO";
    }

    public static void main(String[] args) {
        AtomicReferenceSolution sol = new AtomicReferenceSolution();
        System.out.println(sol.streamTest());
    }
}
