package com.alg.other;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n <= 1) return;
        for(int i = n - 1; i > 0; i--) {
            int right = nums[i];
            int left = nums[i - 1];
            if(left < right) {
                if(i < n - 1) {
                    // Find the smallest number x in the x > left && x < right range
                    int x = right;
                    int index = i;
                    for(int j = i + 1; j < n; j++) {
                        if(nums[j] > left && nums[j] < right) {
                            x = x < nums[j] ? x : nums[j];
//                            System.out.println(" x is:" + x);
                            index = j;
                        }
                    }
                    nums[index] = left;
                    nums[i - 1] = x;
                    Arrays.sort(nums, i, n);
                    return;
                } else { // when i == n - 1
                    nums[i] = left;
                    nums[i - 1] = right;
                    Arrays.sort(nums, i, n);
                    return;
                }

            }
        }
        //When not possible, sort the array and return.
        Arrays.sort(nums);
    }

    //132 -> 213
    // 124987653 -> 125346789
    // Damn it, the logic behind the scene isn't that straight forward as I thought.
    // First, from right to left,  I need to find the first number that is smaller than the number on its right side
    // Then I need to find the next smallest number between num[i-1] and num[i]; swap it with nums[i-1], then sort
    // everything right to [i-1] position.
    // Yeah, that's what the problem was asking: rearranges numbers into the lexicographically next greater permutation of numbers
    /*
    * Runtime: 1 ms, faster than 54.82% of Java online submissions for Next Permutation.
        Memory Usage: 39.2 MB, less than 56.30% of Java online submissions for Next Permutation.
        Next challenges:
        Permutations II
        Permutation Sequence
        Palindrome Permutation II
    * */

    public static void main(String[] args) {
        NextPermutation s = new NextPermutation();
        int[] nums_1 = {3,1,2}; // 3,2,1
        int[] nums_2 = {2,1,0,3}; // 2,1,3,0
        int[] nums_3 = {1,2,3};//1,3,2
        int[] nums_4 = {1,2,4,9,8,7,6,5,3};//1,2,5,3,4,6,7,8,9
        int[][] test_cases = {nums_1, nums_2, nums_3, nums_4};
        for(int i = 0; i < test_cases.length; i++) {
            s.nextPermutation(test_cases[i]);
            s.print(test_cases[i]);
        }
    }
    private void print(int[] array) {
        for(int i = 0; i< array.length;i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }
}
