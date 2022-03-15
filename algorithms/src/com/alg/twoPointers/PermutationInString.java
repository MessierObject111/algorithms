package com.alg.twoPointers;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    /**
     * This initial attempt to solve it with sliding window is utilizing a standard HashMap for tracking if two strings
     * are permutable. However, the amount of code needed to maintain/add/reduce characters and keep their count in
     * track proved to be time consuming during an interview. Too many code need to be written, as below:
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int l = 0;
        int r = s1.length();
        int length = s1.length();
        if(s1.length() > s2.length()) return false;

        Map<Character, Integer> map = scanMap(s1, 0, length);
        Map<Character, Integer> initMap = scanMap(s2, 0, length);
        if(map.equals(initMap)) return true;
        while(r < s2.length()) {
            reduce(initMap, l, s2);
            increase(initMap, r, s2);
            if(map.equals(initMap)) return true;
            l++;
            r++;
        }
        return false;
    }

    private Map<Character, Integer> scanMap (String s, int index, int length) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = index; i < length; i++) {
            Character c = s.charAt(i);
            if(map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, ++count);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    private void reduce(Map<Character, Integer> map, int i, String s){
        int count = map.get(s.charAt(i));
        System.out.println("char " + s.charAt(i) + " at "+ i + " reduced.");
        if(count > 1) {
            map.put(s.charAt(i), --count);
        } else {
            map.remove(s.charAt(i));
        }
    }

    private void increase(Map<Character, Integer> map, int i, String s) {
        System.out.println("char " + s.charAt(i) + " at "+ i + " increased.");
        if(map.get(s.charAt(i)) != null) {
            int count = map.get(s.charAt(i));
            map.put(s.charAt(i), ++count);
        } else {
            map.put(s.charAt(i), 1);
        }
    }

    /**
     * Will attempt to use another data structure to track/maintain the count for each character, since we are only
     * using 26 lower case alphabets.
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion2(String s1, String s2) {
        return false;
    }

    public static void main(String[] args) {
        PermutationInString sol = new PermutationInString();

        String s1_1 = "ab";
        String s1_2 = "a";
        System.out.println(sol.checkInclusion(s1_1, s1_2));//false

        String s2_1 = "adc";
        String s2_2 = "dcda";
        System.out.println(sol.checkInclusion(s2_1, s2_2));//true


        String s3_1 = "ab";
        String s3_2 = "eidbaooo";
        System.out.println(sol.checkInclusion(s3_1, s3_2));//true

    }
}
