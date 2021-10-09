package com.alg.dp;

import com.java.se.inheritancePolymorphism.question9.C;

import java.util.HashMap;

/**
 * We have an array of prices for different lengths of rod. How to
 * cut the rod for given length, so we can maximize the total value?
 * e.g.  1  2  3  4
 * $    [2, 3, 5, 6]
 * The best possible combo to max profit is cut it to two pieces
 * that has lengths 1 & 3, thus total = $1 + $5 = $7
 * 1: (1) = $2
 * 2: (1 + 1) $2 + $2 = $4; (2) = $3;
 * 3: (1 + 1 + 1) = $6; (1 + 2) = $5; (3) = $5
 *
 * To calculate the max profit for 4, or n, we first need to calculate
 * from length 1 : what is the max profit we can make for rod with
 * length 1, and 2, and 3 ... so on
 */
public class CuttingRod {

    public int cutRod (int[] pricesList, int length) {
        if(length <= 0) return 0;
        HashMap<Integer, Integer> dpCacheMap = new HashMap<>();
        dpCacheMap.put(1, pricesList[0]);
        for(int i = 1; i <= length; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                max = Math.max(max, pricesList[j] + dpCacheMap.get(i - j));
                dpCacheMap.put(i + 1, max);
            }
        }

        return dpCacheMap.get(length);
    }

    public static void main(String[] args) {
        int[] prices = {2, 3, 5, 6};
        CuttingRod sol = new CuttingRod();
        System.out.println(sol.cutRod(prices, prices.length));
    }
}
