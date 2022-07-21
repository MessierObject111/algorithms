package com.companies.meta;

public class ContinuousSubArraySum {
    //Brute force: time limit exceeded
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int sum = sum(nums, i, j);
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
}
