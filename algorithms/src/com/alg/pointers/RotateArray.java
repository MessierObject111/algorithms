package com.alg.pointers;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % nums.length;
        int[] temp = new int[k];
        // - -
        // 0 1 2 3 4

        // 3 4
        // 0 1 2 - -

        for(int i = k-1, j = n-1; i >= 0; i--, j--) {
            temp[i] = nums[j];
        }

        // 0 1 2  - -

        // - - 0 1 2
        for(int i = n - 1 - k; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        // 3 4
        // - - 0 1 2

        // - -
        // 3 4 0 1 2
        for(int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}
