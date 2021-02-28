package com.alg.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class FirstNonRepeatingChar {
    public String firstNonRepeat(String s) {
        if(s == null || s.length() <= 1) return s;
        Map<Character, Integer> dict = new LinkedHashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(dict.containsKey(s.charAt(i))) {
                int count = dict.get(s.charAt(i));
                dict.put(s.charAt(i), ++count);
            } else {
                dict.put(s.charAt(i), 1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = dict.entrySet();
        // Multiple mistakes/ compile errors:
        // 1: Tried to stream set of entry by (k, v)->{...} it should be (entry)->{...}
        // 2: Tried to return result directly in a lambda function. Should use filter instead
        AtomicReference<String> res = new AtomicReference<>();
        entries.forEach((entry)->{
            char c = entry.getKey();
            if(entry.getValue() == 1) {
                res.set(String.valueOf(c));
            };

        });
        if(res.get() != null) return res.get();
        return "";
    }

    public static void main(String[] args) {
        FirstNonRepeatingChar sol = new FirstNonRepeatingChar();
        String input_1 = "aabccd";
        System.out.println(sol.firstNonRepeat(input_1));
    }
}
