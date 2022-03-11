package com.alg.twoPointers;

public class MoveZeroes {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        for(int i = 0; i <= nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == 0 && nums[j] != 0) {
                    swap(nums, i, j);
                }
            }
        }
    }

    private void swap(int[]nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        MoveZeroes ins = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        ins.moveZeroes(nums);
        for(int num : nums) {
            System.out.println(num);
        }
    }
}
