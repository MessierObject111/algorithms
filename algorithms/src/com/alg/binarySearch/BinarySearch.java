package com.alg.binarySearch;

public class BinarySearch {

    public int search(int[] nums, int target) {
        if(target < nums[0] || target > nums[nums.length - 1]) return -1;
        return locate(nums, 0, nums.length - 1, target);
    }

    private int locate(int[] nums, int left, int right, int target) {
        if(left == right) return nums[left] == target ? left : -1;
        int mid = (left + right)/2;

        if(nums[mid] < target) return locate(nums, mid + 1, right, target);
        if(nums[mid] > target) return locate(nums, left, mid - 1, target);
        //if no conditions were met above, it must be because nums[mid] == target
        return mid;
    }

    public static void main(String[] args) {
        for(int i = 0; i<100; i++) {
            int j = i + 1;
            System.out.println((i + j)/2);
            System.out.println(i + (j - i)/2);
        }
    }
}