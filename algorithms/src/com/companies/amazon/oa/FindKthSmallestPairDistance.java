package com.companies.amazon.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The distance of a pair of integers a and b is defined as the absolute difference between a and b.
 *
 * Given an integer array nums and an integer k, return the kth smallest distance among all the pairs
 * nums[i] and nums[j] where 0 <= i < j < nums.length.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,1], k = 1
 * Output: 0
 * Explanation: Here are all the pairs:
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 * Example 2:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 0
 * Example 3:
 *
 * Input: nums = [1,6,1], k = 3
 * Output: 5
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 2 <= n <= 104
 * 0 <= nums[i] <= 106
 * 1 <= k <= n * (n - 1) / 2
 */
public class FindKthSmallestPairDistance {
    /**
     * Solution 1: Brute force - find all possible combinations and sort
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePairBrute(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                res.add(diff);
                //System.out.println(diff + " added;");
            }
        }
        //, (a, b) -> { return b-a;}
        //Collections.sort(res, (a, b) -> { return b-a;});
        for(Integer i : res) {
            System.out.print(i + " - ");
        }
        System.out.println();
        return res.get(k );
    }

    /**
     * Solution 2: Binary search
     * @param arr
     * @param k
     * @return
     */
    public int smallestDistancePair(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int lowerDistBound = 0; //The lowest possible distance for all pairs;
        int higherDistBound = arr[n - 1] - arr[0]; //The highest possible distance for all pairs;
        int ans = -1;

        //Binary search template
        while(lowerDistBound <= higherDistBound){
            int m = lowerDistBound + (higherDistBound-lowerDistBound)/2;

            System.out.println("==============Binary Search Round=================");
            System.out.println("lowerDistBound: "+lowerDistBound+ " middle: "+ m + " higherDistBound:"+higherDistBound);

            int count = numOfPairsWithDistanceGreaterThanM(arr, m);

            System.out.println("count of pairs with distance greater than "+ m +": " + count + " count >= "+ k + " ? " + (count >= k));
            // Criteria for binary search: If count is greater than k, search left half;
            // else search right half, until lowerDistBound > higherDistBound

            if(count >= k) {
                ans = m;
                higherDistBound = m - 1;
            } else {
                lowerDistBound = m + 1;
            }
        }
        return ans;
    }

    /**
     * Count the number of pairs in arr with distance more than m
     * @param arr
     * @param m
     * @return
     */
    public static int numOfPairsWithDistanceGreaterThanM(int [] arr, int m){
        int left = 0;
        int right = 1;
        int count = 0;
        while(right < arr.length){
            int diff = arr[right] - arr[left];
            System.out.println("  *** right: " + right + " diff: " + diff);
            while(left < right && diff > m){
                left++;
                diff = arr[right] - arr[left];
                System.out.println("    *** left: " + left + " diff: " + diff);
            }
            count+= (right-left);
            System.out.println("  count: " + count);
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] inputArr = {1, 4, 3, 1};
        int k = 3;
        /**
         * Explanation of this algorithm with brute force:
         * This example will give \
         * you a original array - sort it, {1,1,3,4}; takes O(N * log(N)) time
         * Then we can have all possible pairs, and put them in an array with length = N*(N-1)/2
         * {
         * {1, 1}, {1, 3}, {1, 4},
         *         {1, 3}, {1, 4},
         *                 {3, 4}
         * }
         * If we use brute force, we need to calculate their distances:
         * {0, 2, 3, 2, 3, 1}
         * After sorting, it became
         * {0, 1, 2, 2, 3, 3}
         * And now we can just grab whichever kth element as we please.
         *
         *
         *
         * Explanation of this algorithm with binary search:
         * The sorted array {1,1,3,4} has least value on left, 1; and largest valu on the right, 4;
         * thus, we know for sure that the largest distance we can have here is higherBound = 4-1 = 3.
         * Meanwhile, we know the smallest distance we can have cannot be smaller than 0.
         * So, we can do binary search by setting the middle point of the all possible distances:
         * mid point = (higherBound - lowerBound)/2
         * and search for all pairs
         *
         */
        FindKthSmallestPairDistance sol = new FindKthSmallestPairDistance();
//        System.out.println("Result (Brute): " + sol.smallestDistancePairBrute(inputArr, k));
//        System.out.println("Result (Binary Search): " + sol.smallestDistancePair(inputArr, k));


        int[] inputArr2 = {1, 4, 3, 7, 9, 0, 2, 6, 8, 5};
        int k2 = 7;

        System.out.println("Result (Binary Search): " + sol.smallestDistancePair(inputArr2, k2));
    }
}
