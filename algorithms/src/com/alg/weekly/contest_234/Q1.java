package com.alg.weekly.contest_234;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Q1 {
    /**
     * BigInteger Not available during contest.
     * Line 4: error: cannot find symbol
     *         Set<BigInteger> intSet = new HashSet<>();
     *             ^
     *   symbol:   class BigInteger
     *   location: class Solution
     * Line 14: error: cannot find symbol
     *                 BigInteger num = new BigInteger(cur);
     *                 ^
     *   symbol:   class BigInteger
     *   location: class Solution
     * Line 14: error: cannot find symbol
     *                 BigInteger num = new BigInteger(cur);
     *                                      ^
     *   symbol:   class BigInteger
     *   location: class Solution
     * 3 errors
     * @param word
     * @return
     */
    public int numDifferentIntegers(String word) {
        if(word == null || word.length() == 0) return 0;
        Set<BigInteger> intSet = new HashSet<>();
        for(int i = 0; i < word.length(); i++) {
            if(Character.isAlphabetic(word.charAt(i))) continue;
            if(Character.isDigit(word.charAt(i))) {
                String cur = "";
                int j = i;
                while(j < word.length() && Character.isDigit(word.charAt(j))) {
                    cur = cur + String.valueOf(word.charAt(j));
                    j++;
                }
                BigInteger num = new BigInteger(cur);
                intSet.add(num);
                i = j;
            }
        }
        return intSet.size();
    }

    public int numDifferentIntegersII(String word) {
        if(word == null || word.length() == 0) return 0;
        Set<String> intSet = new HashSet<>();
        for(int i = 0; i < word.length(); i++) {
            if(Character.isAlphabetic(word.charAt(i))) continue;
            if(Character.isDigit(word.charAt(i))) {
                String cur = "";
                int j = i;
                while(j < word.length() && Character.isDigit(word.charAt(j))) {
                    cur = cur + String.valueOf(word.charAt(j));
                    j++;
                }
                String num = cur.replaceFirst("^0+(?!$)", "");
                intSet.add(num);
                i = j;
            }
        }
        return intSet.size();
    }

    public static void main(String[] args) {
        Q1 q = new Q1();
        String test_1 = "a123bc34d8ef34";
        String test_2 = "leet1234code234";
        String test_3 = "a1b01c001";
        System.out.println(q.numDifferentIntegers(test_1));
        System.out.println(q.numDifferentIntegers(test_2));
        System.out.println(q.numDifferentIntegers(test_3));
    }
}
