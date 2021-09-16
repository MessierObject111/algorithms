package com.alg.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Tag: #BFS #Recursion
/**
 * Given two integers n and k. Return all possible combinations of k numbers out of 1, 2, ... , n.
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 */
public class Combinations {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 1; i <= k; i++) {
            set.add(i);
        }
        return result;
    }
}
