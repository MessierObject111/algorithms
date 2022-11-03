package com.alg.binarySearch;

import java.util.Arrays;

public class TwoSumSmallerThanK {
    //2002-11-03: A couple of pitfalls I fell:
    //1: I though a single interation, the first i + j pair would get me the max value;
    //It wasn't the case. Depending the location of i, the max combo sum could be diff.
    //2. I made many crude coding mistakes such as setting MAX in class level static, etc.
    //rather than local var; not -1 when iterating array.length
    //3. I forgot we don't need to return value for Arrays.sort()
    public int twoSumLessThanK(int[] nums, int k) {
        int MAX = -1;
        Arrays.sort(nums);
        printArray(nums);
        for(int i = nums.length-1; i > 0; i--) {
            if(nums[i] < k) {
                int j = findSecond(nums, i, k);
                if(j > -1) {
                    MAX = MAX > nums[i] + nums[j] ? MAX : nums[i] + nums[j];
                }
            }
        }
        return MAX;
    }

    private int findSecond(int[] nums, int i, int k) {
        for(int j = i-1; j >= 0; j--) {
            if(nums[i] + nums[j] < k) {
                return j;
            }
        }
        return -1;
    }

    private void printArray(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }
}
