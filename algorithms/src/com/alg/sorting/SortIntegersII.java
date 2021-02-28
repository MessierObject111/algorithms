package com.alg.sorting;

/**
 * Given an integer array, sort it in ascending order in place. Use quick sort, merge sort, heap sort or any O(nlogn) algorithm.
 *
 * Example
 * Example1:
 *
 * Input: [3, 2, 1, 4, 5],
 * Output: [1, 2, 3, 4, 5].
 * Example2:
 *
 * Input: [2, 3, 1],
 * Output: [1, 2, 3].
 */
public class SortIntegersII {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        quickSort(A, 0, A.length - 1);
    }

    public void quickSort (int[] nums, int start, int end) {
        if(start >= end) return ;
        int left = start, right = end;
        int pivot = nums[(left + right) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if(left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }

    public static void main(String[] args) {
        int[] nums = {19,-10,-2,40,3,36,57,25,66,51,5,40,-8,43,9,-5,0,4,55,28,63,67,-2,35,57,0,0,30,17,55,22,34,-4,42,
                57,52,4,65,6,-2,8,12,31,43,26,34,31,19,-3,36,34,11,58,23,13,7,17,10,33,-5,10,53,14,56,18,8,-6,-2,37,7};
        int[] expected = {-10,-8,-6,-5,-5,-4,-3,-2,-2,-2,-2,0,0,0,3,4,4,5,6,7,7,8,8,9,10,10,11,12,13,14,17,17,18,19,19,
                22,23,25,26,28,30,31,31,33,34,34,34,35,36,36,37,40,40,42,43,43,51,52,53,55,55,56,57,57,57,58,63,65,66,67};
        boolean abnormally = false;
        SortIntegersII ins = new SortIntegersII();
        ins.sortIntegers2(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == expected[i]) {
                System.out.println(nums[i] + " - "+ expected[i]);
            } else {
                System.out.println(nums[i] + " - "+ expected[i]);
                abnormally = true;
                break;
            }
        }
        if(abnormally) {
            System.out.println("***Array not sorted***");
        }else{
            System.out.println("---Array successfully sorted---");
        }
    }
}
