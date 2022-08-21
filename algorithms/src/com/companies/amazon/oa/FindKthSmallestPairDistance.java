package com.companies.amazon.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        int lowerBound = 0; int higherBound = arr[n - 1] - arr[0];
        int ans = -1;

        while(lowerBound <= higherBound){
            int m = lowerBound + (higherBound-lowerBound)/2;
            System.out.println("==============Binary Search Round=================");
            System.out.println("lowerBound: "+lowerBound+ " middle: "+ m + " higherBound:"+higherBound);
            int count = numOfPairDistGreaterThanM(arr, m);
            System.out.println("count: " +count);
            // Criteria for binary search: If count is greater than k, search left half;
            // else search right half, until lowerBound > higherBound
            if(count >= k) {
                ans = m;
                higherBound = m - 1;
            } else {
                lowerBound = m + 1;
            }
        }
        return ans;
    }


    public static int numOfPairDistGreaterThanM(int [] arr, int m){
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
        int[] inputArr = {1, 1, 3, 4};
        int k = 2;
        FindKthSmallestPairDistance sol = new FindKthSmallestPairDistance();
        System.out.println("Result (Brute): " + sol.smallestDistancePairBrute(inputArr, k));
        System.out.println("Result (Binary Search): " + sol.smallestDistancePair(inputArr, k));
    }
}
