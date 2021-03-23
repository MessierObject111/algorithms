package com.alg.practice;

/*
https://leetcode.com/problems/minimum-window-substring/
String: addcbbaabb
Find the smallest substring containing all characters of String result dcba

76. Minimum Window Substring
Hard

5925

408

Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no
such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Example 2:

Input: s = "a", t = "a"
Output: "a"


Constraints:

1 <= s.length, t.length <= 105
s and t consist of English letters.


Follow up: Could you find an algorithm that runs in O(n) time?
 */

import java.util.*;

public class SmallestSubString {

    public String minWindow(String input, String pattern) {
        if(pattern.length() > input.length()) return "";
        // Build a dictionary that contains all the characters with count appears from pattern
        Map<String, Integer> dictionary = new HashMap<>();
//        Set<String>
        for(int i = 0; i< pattern.length(); i++) {
            String element = String.valueOf(pattern.charAt(i));
            compareAndAdd(dictionary, element);
        }

        // Iterate through the input string until all characters in dictionary are met
        int pointer = 0;
        while(!dictionary.isEmpty() && pointer < input.length()) {
            String s = String.valueOf(input.charAt(pointer));
            reduceOrRemove(dictionary, s);
            pointer++;
        }
        if(dictionary.isEmpty()) {
            int left = 0;
//            while ()
        }
        return "";
    }

    // Solution: Brute Force by enumerate every possible combinations
    public static String findSmallestSub (String input, String pattern) {
        Map<String, Integer> dictionary = new HashMap<>();
        int minWindowLength = Integer.MAX_VALUE;
        String sub = "";

        if(input.length() < pattern.length()) return "";

       for(int i = 0; i< pattern.length(); i++) {
           String element = String.valueOf(pattern.charAt(i));
           compareAndAdd(dictionary, element);
       }

       for (int j = 0; j <= input.length() - pattern.length(); j++) {
           String current = String.valueOf(input.charAt(j));
           if (dictionary.containsKey(current)) {
               HashMap<String, Integer> copyDictionary = (HashMap<String, Integer>) ((HashMap<String, Integer>) dictionary).clone();
               int windowLength = findAllCharsInPattern(input, j, copyDictionary);
               if(windowLength > 0 && windowLength < minWindowLength) {
                   minWindowLength = windowLength;
                   sub = input.substring(j, j + windowLength);
//                   System.out.println("Sub string updated: " + sub);
               }
           }
       }
        return sub;
    }

    private static void compareAndAdd (Map<String, Integer> dictionary, String key) {
        if(dictionary.containsKey(key)) {
            int count = dictionary.get(key);
            dictionary.put(key, ++count);
        } else {
            dictionary.put(key, 1);
        }
    }

    private static void reduceOrRemove (Map<String, Integer> dictionary, String key){
        if(dictionary.containsKey(key)) {
            int count = dictionary.get(key);
            if (count > 1) {
                dictionary.put(key, --count);
            } else {
                dictionary.remove(key);
            }
        }
    }

    private static int findAllCharsInPattern (String input, int index, Map<String, Integer> copyDictionary) {
        for (int i = index; i < input.length(); i++) {
            String s = String.valueOf(input.charAt(i));
            if(copyDictionary.containsKey(s)) {
//                System.out.println("dic removes " + s + " at index: " + i);
                reduceOrRemove(copyDictionary, s);
            }
            if(copyDictionary.isEmpty()) {
//                System.out.println("-- All met! Substring: " + input.substring(index, i + 1));
                return i + 1 - index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String input = "ADOBECODEBANC";
        String pattern = "ABC";
        String sub = findSmallestSub(input, pattern);
        System.out.println(sub);

        String input1 = "A";
        String pattern1 = "A";
        String sub1 = findSmallestSub(input1, pattern1);
        System.out.println(sub1);

        String input2 = "ABAC";
        String pattern2 = "AA";
        String sub2 = findSmallestSub(input2, pattern2);
        System.out.println(sub2);

//        String input3 = "";
//        String pattern3 = "ABC";
//        String sub3 = findSmallestSub(input3, pattern3);
//        System.out.println(sub3);
    }
}
