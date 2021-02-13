package com.alg.dp;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
    Map<String, Integer> dpMap = new HashMap<>();

    public int uniquePaths(int m, int n) {
        if(m == 1 && n == 1) return 1;
        if(m > 1 && n > 1) {
            String key = 31 * m + "-" + 30 * n;
            if(dpMap.containsKey(key)){
                return dpMap.get(key);
            }
            int numOfPathsFromLeft = uniquePaths(m - 1, n);
            int numOfPathsFromUp = uniquePaths(m, n - 1);
            dpMap.put(key, numOfPathsFromLeft + numOfPathsFromUp);
            return numOfPathsFromLeft + numOfPathsFromUp;
        }
        if(m > 1 && n == 1){
            String key = 31 * m + "-" + 30 * n;
            if(dpMap.containsKey(key)){
                return dpMap.get(key);
            }
            return uniquePaths(m - 1, n);
        }
        if(m == 1 && n > 1){
            String key = 31 * m + "-" + 30 * n;
            if(dpMap.containsKey(key)){
                return dpMap.get(key);
            }
            return uniquePaths(m, n -1);
        }
        return 0;
    }

    public int uniquePathsWithoutDp(int m, int n) {
        if(m == 1 && n == 1) return 1;
        if(m > 1 && n > 1) {
            return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        }
        if(m > 1 && n == 1) return uniquePaths(m - 1, n);
        if(m == 1 && n > 1) return uniquePaths(m, n -1);
        return 0;
    }

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        System.out.println(solution.uniquePaths(51, 9));
    }
}
