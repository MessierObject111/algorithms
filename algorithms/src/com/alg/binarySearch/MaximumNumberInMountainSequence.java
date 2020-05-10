package com.alg.binarySearch;

/**
 * 585. Maximum Number in Mountain Sequence
 * Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.
 * Example 1:
 *
 * Input: nums = [1, 2, 4, 8, 6, 3]
 * Output: 8
 * Example 2:
 *
 * Input: nums = [10, 9, 8, 7],
 * Output: 10
 * https://www.lintcode.com/problem/maximum-number-in-mountain-sequence/description
 */
public class MaximumNumberInMountainSequence {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        if(nums.length <= 1) return nums[0];
        int start = 0, end = nums.length - 1;
        while (start < end - 1) {
            int mid = (start + end)/2;
            if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] > nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
    }

    public static void main(String[] args) {
        MaximumNumberInMountainSequence instance = new MaximumNumberInMountainSequence();
        int[] nums1 = {1, 2, 4, 8, 6, 3};
        int[] nums2 = {10, 9, 8, 7};
        System.out.println(instance.mountainSequence(nums2));
    }
}
