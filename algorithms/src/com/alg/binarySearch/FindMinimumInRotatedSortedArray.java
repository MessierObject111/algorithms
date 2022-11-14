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

    //2022-11-13: For some reason, I never checked this in to leetcode
    //[3,4,5,1,2]
    public int findMinII(int[] nums) {
        int length = nums.length;
        if(nums[0] < nums[length - 1] || length <= 1) return nums[0];
        int l = 1, r = length - 1;
        //edge case: [2,1]
        while(l < r) {
            int m = l + (r - l)/2;
            if(nums[m-1] > nums[m]) {
                return nums[m];
            }
            //Note here that, there is an case that leftmost element happen to be the minimum element [.., 0(l), 1(m), 2(r)]
            //and the current segment of array is no longer rotated, so we need to check for nums[l] < nums[r]
            //Else, it will wrongfully fell outside of this condition and search on right half instead (wrong)
            if(nums[l] > nums[m] || nums[l] < nums[r]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }

    public int findMinRecursive(int[] nums) {
        int length = nums.length;
        if(nums[0] < nums[length - 1] || length <= 1) return nums[0];
        int index = binarySearch(nums, 1, nums.length - 1);
        return nums[index];
    }

    private int binarySearch(int[] nums, int l, int r) {
        if(l == r) {
            //System.out.println("l - 1: " + nums[l - 1] + " l: "+ nums[l]);
            return nums[l - 1] > nums[l] ? l : -1;
        }
        int i = (l + r)/2;
        //System.out.println("l:" + l + " i:" + i + " r:" + r);
        if(nums[i - 1] > nums[i]) {
            return i;
        }
        //The condition to go left or right here is difficult to catch a few edge case:
        //Aside from min value should be smaller than its left element, it sometimes fall
        //the left-most element of given segment. When it does, the nums[i] < nums[l]
        //condition won't work as intended, thus needs || nums[l] < nums[r] to check this.
        if(nums[i] < nums[l] || nums[l] < nums[r]) {
            return binarySearch(nums, l, i - 1);
        }
        return binarySearch(nums, i + 1, r);
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
