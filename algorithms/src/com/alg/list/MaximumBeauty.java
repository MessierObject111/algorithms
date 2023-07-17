package com.alg.list;

import java.util.Arrays;

//6929. Maximum Beauty of an Array After Applying Operation
public class MaximumBeauty {
    //My attempt to solve it: complex in code, and didn't pass some cases such as int[] nums = {32, 16, 98} and k = 1;
    // Leetcode answer expects 0 for this, but expects 1 when k = 0. (I don't understand why)
    public int maximumBeauty0(int[] nums, int k) {
        //Sort it first since order doesn't matter; O(N*log(N))
        //Then iterate through the ordered list with 2k range scanning and find max value. O(N)
        //Corner cases: equal elements?
        Arrays.sort(nums);
        int maxBeauty = 0;
        for(int i = 0; i < nums.length; i++){
//            int leftBound = i - k < 0 ? 0 : i - k;
//            int rightBound = i + k > nums.length ? nums.length : i + k;
            for(int j = -k; j < k; j++) {
                int current = nums[i] + k;
                int lower = current - k;
                int upper = current + k;
                int count = findMax(nums, lower, upper);
                maxBeauty = maxBeauty < count ? count : maxBeauty;
            }
        }
        return maxBeauty == 1 ? 0 : maxBeauty;
    }

    private int findMax(int[] nums, int lower, int upper) {
        int l = 0;
        int r = nums.length - 1;
        while(nums[l] < lower) {
            l++;
        }
        while(nums[r] > upper) {
            r--;
        }
        int res = r - l + 1;
        return res ;
    }

    //This is answer from another leetcode user, who brilliantly solved the problem in 6 lines of code:
    // https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/solutions/3771308/java-c-python-sliding-window/

    //In each iteration, i may or may not increase; but j will definitely increase by 1, thus the window never DECREASES
    //As a result, once a valid window got increased to current size, it will keep judging the rest of the array with
    // this windows size; if there are beauty windows longer than this current one, i stays, while j++, increasing the
    // window again until it covers all the valid elements, reaching the bigger, or even max window size in process.
    // It won't stop until j reaches the end, and it will keep judging the rest of array with current window size. If
    // latter elements do not have beauty numbers, fine - We knew the max window/max beauty size already and kept using
    // this standard for the rest of checking process.
    public int maximumBeauty(int[] A, int k) {
        Arrays.sort(A);//Sorting part is the same;
        int i = 0, j, n = A.length; //declaring multiple variables; i is left index of sliding window, j is right index
        for (j = 0; j < n; ++j)
            if (A[j] - A[i] > k * 2)
                i++;
        return j - i;
    }

    public static void main(String[] args) {
        MaximumBeauty sol = new MaximumBeauty();
        int[] nums = {4,6,1,2}; //3
        int k = 2;
//        int[] nums = {1,1,1,1}; //4
//        int k = 10;
//        int[] nums = {12,-11}; //2
//        int k = 12;
//        int[] nums = {32, 16, 98}; //0
//        int k = 1;
        System.out.println(sol.maximumBeauty(nums, k));
    }
}
