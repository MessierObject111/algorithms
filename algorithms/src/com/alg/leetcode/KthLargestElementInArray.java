package com.alg.leetcode;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return 0;
        int top = k;
        while (top != 1) {
            searchAndDestroy(nums);
            top--;
        }
        return findlargest(nums);
    }

    private void searchAndDestroy (int[] nums) {
        Integer MAX = Integer.MIN_VALUE;
        int MAX_INDEX = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > MAX) {
                MAX = nums[i];
                MAX_INDEX = i;
            }
        }
        nums[MAX_INDEX] = Integer.MIN_VALUE;
    }
    private int findlargest(int[] nums) {
        Integer MAX = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > MAX) {
                MAX = nums[i];
            }
        }
        return MAX;
    }

    public static void main(String[] args) {
        KthLargestElementInArray solution = new KthLargestElementInArray();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(solution.findKthLargest(nums, 3));
    }
}
