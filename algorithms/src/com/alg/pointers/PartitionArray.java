package com.alg.pointers;

/**
 * Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
 *
 * All elements < k are moved to the left
 * All elements >= k are moved to the right
 * Return the partitioning index, i.e the first index i nums[i] >= k.
 *
 * Example
 * Example 1:
 *
 * Input:
 * [],9
 * Output:
 * 0
 *
 * Example 2:
 *
 * Input:
 * [3,2,2,1],2
 * Output:1
 * Explanation:
 * the real array is[1,2,2,3].So return 1
 * Challenge
 * Can you partition the array in-place and in O(n)?
 *
 * Notice
 * You should do really partition in array nums instead of just counting the numbers of integers smaller than k.
 *
 * If all elements in nums are smaller than k, then return nums.length
 */
public class PartitionArray {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = nums.length - 1;
        while (start <= end ) {
            while (start <= end && nums[start] < k) {
                start++;
            }
            while (start <= end && nums[end] >= k) {
                end--;
            }
            if (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        PartitionArray instance = new PartitionArray();
        int[] array_1 = {7,7,9,8,6,6,8,7,9,8,6,6};
        int k_1 = 10;
        System.out.println(instance.partitionArray(array_1, k_1));
        int[] array_2 = {6,6,8,6,7,9,8,7,9,6,8,6,8,9,8,7,8,6,7,6,6,8,6,6};
        int k_2 = 5;
        System.out.println(instance.partitionArray(array_2, k_2));
    }
}
