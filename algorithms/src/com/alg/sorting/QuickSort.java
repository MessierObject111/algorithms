package com.alg.sorting;

public class QuickSort {
    public void quickSort (int[] nums, int start, int end) {
        if(start == end) return ;
        int i = start, j = end;
        int pivot = (i + j) / 2;
        while (i <= j) {
            while (i <= j && nums[i] < nums[pivot]) {
                i++;
            }
            while (i <= j && nums[j] > nums[pivot]) {
                j--;
            }
            if(i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        if(start < pivot) {
            quickSort(nums, start, pivot);
        }
        if(pivot < end) {
            quickSort(nums, pivot + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 8, 3, 9, 5, 2, 7, 1, 6};
        QuickSort instance = new QuickSort();
        instance.quickSort(nums, 0, nums.length - 1);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
