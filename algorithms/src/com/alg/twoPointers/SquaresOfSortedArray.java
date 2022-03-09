package com.alg.twoPointers;

public class SquaresOfSortedArray {
    /**
     * At first, I planed to Find the pivot where I can start two pointers from the middle, and then go left & right
     * accordingly, until both reaches end; this proved to be a problematic approach, since the starting state (locating
     * where left and right positions to begin with) is tricky, and leads to lengthy code, and a equally messy terminate
     * condition when we need to stop (Have to constantly checking left and right boundaries for each loop to avoid
     * index out of bound error). After reading solution, I found the approach that start from two ends from the array,
     * left and right, then move towards the center meeting point, is a much easier way to implement. We just need to
     * fill the result array from n-1 to 0, instead of 0 to n-1.
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        //
        int[] result = new int[nums.length];
        int left = 0;
        int right  = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(Math.abs(nums[left]) < Math.abs(nums[right])) {
                result[i] = nums[right]* nums[right];
                right--;
            } else {
                result[i] = nums[left]*nums[left];
                left++;
            }
        }

        //Go left and right by condition, until both reaches end;

        return result;
    }
}
