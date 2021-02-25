package com.alg.string;

import java.util.HashSet;
import java.util.Set;

public class CommonSubString {
    public String twoStrings(String s1, String s2) {
        Set<String> dict = new HashSet<>();
        for(int i = 0; i < s1.length(); i++) {
            Character sub = s1.charAt(i);
            dict.add(String.valueOf(sub));
        }
        for(int i = 0; i < s2.length(); i++) {
            String sub = String.valueOf(s2.charAt(i));
            if(dict.contains(sub)) return "YES";
        }
        return "NO";

    }
}
