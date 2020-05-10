package com.alg.binarySearch;

/**
 * Suppose a sorted array in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 *
 * Example 1:
 *
 * Input：[4, 5, 6, 7, 0, 1, 2]
 * Output：0
 * Explanation：
 * The minimum value in an array is 0.
 * Example 2:
 *
 * Input：[2,1]
 * Output：1
 * Explanation：
 * The minimum value in an array is 1.
 *
 */
public class FindMinimumInRotatedSortedArray {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        if (nums[0] < nums[nums.length - 1]) return nums[0];

        int left = 0, right = nums.length - 1;
        int mid = left + (right - left) / 2;

        while(nums[mid] < nums[mid + 1]) {
            if(nums[left] < nums[mid]) {
                left = mid;
            }
            if(nums[mid] < nums[right]) {
                right = mid;
            }
            mid = left + (right - left) /2;
        }

        return nums[mid + 1];
    }

    public static void main(String[] args) {
        int[] array_1 = {4, 5, 6, 7, 0, 1, 2};
        int[] array_2 = {2, 1};
        int[] array_3 = {1, 2 ,3};
        int[] array_4 = {4,5,6,7,8,9,1,2,3};
        FindMinimumInRotatedSortedArray instance = new FindMinimumInRotatedSortedArray();
        int min = instance.findMin(array_4);
        System.out.println(min);
    }
}
