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
        HashMap<Character, Integer> mapA, mapB = new HashMap<>();
        for(int i = 0; i < lengthA; i++) {
            Character c = A.charAt(i);
            if (mapA.get(c) != null) {

            }
        }
        return false;
    }
}
