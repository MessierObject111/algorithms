package com.alg.leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";

        String MAX_PREFIX = "";
        String first = strs[0];
        for(int i = 0; i < first.length(); i++) {
            char common = first.charAt(i);
            for(int strsIndex = 0; strsIndex < strs.length; strsIndex++) {
                if(strs[strsIndex].length() <= i) {
                    return MAX_PREFIX;
                }
                char current = strs[strsIndex].charAt(i);
                if(common != current) return MAX_PREFIX;
            }
            MAX_PREFIX = MAX_PREFIX + String.valueOf(common);
        }
        return MAX_PREFIX;
    }

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String[] strs_1 = {"flower","flow","flight"};
        String[] strs_2 = {"dog","racecar","car"};
        System.out.println(solution.longestCommonPrefix(strs_1));
        System.out.println(solution.longestCommonPrefix(strs_2));
    }
}
