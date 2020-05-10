package com.alg.binarySearch;

/**
 * Find the last position of a target number in a sorted array. Return -1 if target does not exist.
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,4,5,5], target = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,2,4,5,5], target = 6
 * Output: -1
 *
 */
public class LastPositionOfTarget {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int lastPosition(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length < 1) return -1;
        int left = 0, right = nums.length - 1;
        int mid;
        while (left + 1 < right) {
            mid = (left + right) / 2;
            if(nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
//            System.out.println(left + " : "+ right);
        }
        if(nums[right] == target) {
            return right;
        }
        if(nums[left] == target) {
            return left;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = new int[100];
        for(int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        int[] array_1 = {};
        int[] array_2 = {1,2,3,4,5,6};
        int[] array_3 = {1,1,1,1,2,2,3,3,4,4,4,4,5,5,5,5,5,5,5,6,6,6,6,6,6,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,10,10,10,
                10,10,11,11,11,11,12,12,12,13,13,13,13,13,14,14,14,14,14,15,15,15,15,15,15,15,16,16,16,16,16,16,16,16,
                16,17,17,17,17,17,17,17,18,18,19,19,19,19,20,20,20,20,20,20,20,20,20};

        LastPositionOfTarget instance = new LastPositionOfTarget();
        int index_1 = instance.lastPosition(array_1, 3);
        System.out.println(index_1);//Expect -1
        int index_2 = instance.lastPosition(array_2, 2);
        System.out.println(index_2);//Expect 1
        int index_3 = instance.lastPosition(array_3, 4);
        System.out.println(index_3);//Expect 11
        for(int i = 0; i <= 100; i++) {
            int idx = instance.lastPosition(array, i);
            System.out.println(idx + ": "+ i);
        }

    }
}
