package com.alg.twoPointers;

//https://leetcode.com/problems/maximum-average-subarray-i/description/

public class MaxAverageSubarray {
    //Sliding window is perfect here
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double max = -Double.MAX_VALUE;
        for(int i = 0; i < k; i++) {
            sum+=nums[i];
        }

        double average = sum/(double)k;
        //System.out.println("avg:"+ average + " sum:" + sum);
        if(average > max) max = average;
        for(int i = 1; i < nums.length - k + 1; i++){
            sum = sum - nums[i-1];
            sum = sum + nums[i+k-1];
            average = sum/(double)k;
            //System.out.println(i + " - " + (i + k - 1) + " avg:"+ average + " sum:" + sum);
            if(average > max) max = average;
        }
        return max;
    }
}
