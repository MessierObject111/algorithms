package com.companies.meta;

import com.java.se.inheritancePolymorphism.question9.C;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum {
    /**
     * O(N^2): DP memorization, time limit exceeded
     * What else can you do to a algo that needs to check every sub array combo? The minimum is O(N^2)! Yes it still
     * exceeded time limit...
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int sum = 0;
                if(i == 0) {
                    sum = dp[j-1] + nums[j];
                    dp[j] = sum;
                    //System.out.println("dp[" + j + "]: "+ sum);
                } else {
                    sum = dp[j] - dp[i] + nums[i];
                }
                if (sum % k == 0) return true;
            }
        }
        return false;
    }

    /**
     * Someone else's algorithm that passed leetcode, but didn't pass my test case:
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySumII(int[] nums, int k) {
        // maintain a hash map to store <sum % k, index>
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;
            // case 1
            if (sum == 0 && i > 0) {
                return true;
            }
            // case 2
            if (map.containsKey(sum) && i - map.get(sum) > 1) {
                return true;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubArraySum sol = new ContinuousSubArraySum();
//        int[] nums = {1, 2 , 12};
        int[] nums_1 = {3, 2, 7};
        System.out.println(sol.checkSubarraySumII(nums_1, 6));

        int[] nums_2 = {8, 3, 2, 2, 1, 4, 4};
//        System.out.println(sol.checkSubarraySum(nums_2, 6));
        System.out.println(sol.checkSubarraySumII(nums_2, 6));
    }
}
