package com.alg.leetcode;

/**
 * Given an array of integers nums and an integer k, return the total number
 * of continuous subarrays whose sum equals to k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class SubarraySumEqualsK {
    /**
     * Use brute force to iterate each possible combo and their sum to
     * find out the # of total sub arrays.
     * Time Limit Exceeded when submitted in leetcode.
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumBruteForce(int[] nums, int k) {
        int total = 0;
        for(int i = 0; i<= nums.length-1; i++) {
            for(int j = i; j<= nums.length-1; j++) {
                int sum = 0;
                for(int p = i; p <= j; p++) {
                    sum += nums[p];
                }
                if(sum == k) {
                    total++;
                }
            }
        }
        return total;
    }

    public int subarraySumCumulative(int[] nums, int k) {
        int total = 0;
        int[] cumulativeMap = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++)
            cumulativeMap[i] = cumulativeMap[i - 1] + nums[i - 1];
        for(int start = 0; start< nums.length; start++) {
            for(int end = start+1; end <= nums.length; end++) {
                if(cumulativeMap[end] - cumulativeMap[start] == k) {
                    total++;
                }
            }
        }
        return total;
    }

    public static void main (String[] args) {
        int[] nums_0 = {1, 2, 3, 4}; // 0, 1, 3, 6, 10
        int[] nums_1 = {-1, 2, -3, 4};
        int[] nums_2 = {23, 22, 13, 47};
        int[] nums_3 = {117, 43, -83, 342, 232, 94, 35, 23, 364, 339};
        SubarraySumEqualsK sol = new SubarraySumEqualsK();
//        System.out.println(sol.subarraySumBruteForce(nums_0, 3));//2
//        System.out.println(sol.subarraySumBruteForce(nums_0, 7));//1
//        System.out.println(sol.subarraySumBruteForce(nums_0, 8));//0
//
//        System.out.println(sol.subarraySumBruteForce(nums_1, 1));//2
//        System.out.println(sol.subarraySumBruteForce(nums_1, 2));//2 (2; -1+2-3+4)
//        System.out.println(sol.subarraySumBruteForce(nums_1, -2));//1

        System.out.println(sol.subarraySumCumulative(nums_0, 3));//2
        System.out.println(sol.subarraySumCumulative(nums_0, 7));//1
        System.out.println(sol.subarraySumCumulative(nums_0, 8));//0

        System.out.println(sol.subarraySumCumulative(nums_1, 1));//2
        System.out.println(sol.subarraySumCumulative(nums_1, 2));//2 (2; -1+2-3+4)
        System.out.println(sol.subarraySumCumulative(nums_1, -2));//1
    }
}
