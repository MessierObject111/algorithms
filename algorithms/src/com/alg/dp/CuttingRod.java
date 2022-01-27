package com.alg.dp;

import com.java.se.inheritancePolymorphism.question9.C;

import java.util.HashMap;

/**
 * 2021-10-19: I got this classic DP problem from Nikki last Tuesday,
 * I knew this problem before but never had to try it. Although I
 * know the basic ideas of finding out the terminal case (max profit
 * for rod with length 1, and then 2, 3,...) and using additional
 * data structure to store intermediate results (length - max profit
 * for given length), I couldn't code it out. How to structure the
 * actual code to make it iterate through all possible combinations
 * remains a headache. I feel close to the answer but had to read
 * answers online to be able to solve it - meaning I won't be
 * remembering it in a few days...
 *
 * I have to say, the double 'for' loops and the way to iterate all
 * combinations are quite unique, it is not easy for me to think that
 * way.
 *
 * We have an array of prices for different lengths of rod. How to
 * cut the rod for given length, so we can maximize the total value?
 * e.g.  1  2  3  4
 * $    [2, 3, 5, 6]
 * The best possible combo to max profit is cut it to two pieces
 * that has lengths 1 & 3, thus total = $1 + $5 = $7
 * 1: (1) = $2
 * 2: (1 + 1) $2 + $2 = $4; (2) = $3;
 * 3: (1 + 1 + 1) = $6; (1 + 2) = $5; (3) = $5
 * 4: (1 + 1 + 1 + 1) = $8; (1 + 2 + 1) = $7; (2 + 2) = $6; (4) = $6
 *
 * To calculate the max profit for 4, or n, we first need to calculate
 * from length 1 : what is the max profit we can make for rod with
 * length 1, and 2, and 3 ... so on
 */
public class CuttingRod {

    /**
     * Instead of calling function recursively to dive into every iteration,
     * we use two 'for()' loops to reach every combinations for this case.
     * @param pricesList The array that contains all the prices for given
     *                   rod length. The price at index 0 is corresponding
     *                   to the price for rod with length 1, and so on
     * @param length It is the same as pricesList.length, but we put it here
     *              just for convenience
     * @return
     */
    public int cutRod (int[] pricesList, int length) {
        if(length <= 0) return 0;
        HashMap<Integer, Integer> dpCacheMap = new HashMap<>();
        dpCacheMap.put(1, pricesList[0]);
        /**
         * Here is the double 'for' loops to iterate all possible combos:
         * Outer loop defines the length of rod, and the inner loop iterates
         * between 0 to the length of rod. This way, we thoroughly calculate
         * what is the max possible profit can be allocated for each rod
         * length, i, step by step, +1 length each time.
         *
         * The goal of each outer for loop is to calculate and determine what
         * is the max possible profit at i length. It should start with small
         * edge case 1, then 2, 3 and so on. Each result calculated will be
         * used in next larger iteration for i + 1 length.
         *
         * The goal of inner loop is to iterate all the possible combinations
         * of max values. For example, when I and calculating rod with length
         * of n, then I should already know all the max profits that can be
         * possibly obtained from rod with length of 1 to (n - 1). With that
         * knowledge at hand, we can easily calculate all the combinations:
         *
         * Max profit for rod with length n:
         * Let's say the max values from 1 to n-1 are stored in map, dpCache;
         * Find the MAX value from below combinations:
         * dpCache.get(0) + price of rod with length (n-0)
         * dpCache.get(1) + price of rod with length (n-1);
         * dpCache.get(2) + price of rod with length (n-2);
         * dpCache.get(3) + price of rod with length (n-3);
         * ...
         * dpCache.get(n-1) + price of rod with length (n-(n-1))
         *
         * Then store the max value from above to dpCache map:
         * doCache.put(n, MAX);
         *
         * And continue to next rod length n + 1 until we reached target length.
         */
        for(int i = 1; i <= length; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                max = Math.max(max, pricesList[j] + dpCacheMap.get(i - j));
                dpCacheMap.put(i + 1, max);
            }
        }

        return dpCacheMap.get(length);
    }

    private int calculateMax(int[] priceArray) {
        int length = priceArray.length;
        int[] dpCache = new int[length + 1];
        dpCache[0] = 0;
        for(int i = 1; i < length; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                max = Math.max(dpCache[j], priceArray[i - j - 1]);
                dpCache[i] = max;
            }
        }
        return dpCache[length - 1];
    }

    public static void main(String[] args) {
        int[] prices = {2, 3, 5, 6};
        CuttingRod sol = new CuttingRod();
        System.out.println(sol.cutRod(prices, prices.length));
        System.out.println(sol.calculateMax(prices));
    }
}
