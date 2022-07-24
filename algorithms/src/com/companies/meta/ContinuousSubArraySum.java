package com.companies.meta;

import com.java.se.inheritancePolymorphism.question9.C;

public class ContinuousSubArraySum {
    //O(N^2): time limit exceeded
    //What else can you do to a algo that needs to check every sub array combo? The minimum is O(N^2)! Yes it still
    // exceeded time limit...
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

    private int sum(int[] nums, int i, int j) {
        int sum = 0;
        while(i <= j) {
            sum = sum + nums[i];
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2 , 12};
        ContinuousSubArraySum sol = new ContinuousSubArraySum();
        System.out.println(sol.checkSubarraySum(nums, 6));
    }
}
