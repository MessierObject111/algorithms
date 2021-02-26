package com.alg.generic;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 *
 * Example 1:
 * 	Input:  "abcd", "bcad"
 * 	Output:  True
 *
 *
 * Example 2:
 * 	Input: "aac", "abc"
 * 	Output:  False
 */
public class StringPermutation {
    /**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        // write your code here
        int lengthA = A.length(), lengthB = B.length();
        if (lengthA != lengthB) {
            return false;
        }
        HashMap<Character, Integer> mapA = new HashMap<>(), mapB = new HashMap<>();
        for(int i = 0; i < lengthA; i++) {
            Character c = A.charAt(i);
            if (mapA.get(c) != null) {
                mapA.put(c, 1 + mapA.get(c));
            } else {
                mapA.put(c, 1);
            }
        }
        for(int j = 0; j < lengthB; j++) {
            Character c = B.charAt(j);
            if (mapB.get(c) != null) {
                mapB.put(c, 1 + mapB.get(c));
            } else {
                mapB.put(c, 1);
            }
        }
        boolean result = mapA.equals(mapB);
        return result;
    }

    public static void main(String[] args) {
        String A = "abcd", B ="bcad";
//        String A = "aac", B ="abc";
        StringPermutation sp = new StringPermutation();
        System.out.println(sp.Permutation(A, B));
    }
}
