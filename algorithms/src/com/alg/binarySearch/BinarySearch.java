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

    public int binarySearchLoop(int[] arr, int k) {
        int l = 0; int r = arr.length;
        while(l < r) {
            int m = l + (r-l)/2;
            if(arr[m] == k) {
                return m;
            } else if(arr[m] > k){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        for(int i = 0; i < 100; i++) {
            int j = i + 1;
//            System.out.println((i + j)/2);// i + j has a potential risk of int overflow,
//            System.out.println(i + (j - i)/2); // i+(j-i)/2 is safer, with no such risk
            arr[i] = j;
        }
        System.out.println("============================");
        BinarySearch sol = new BinarySearch();

        for(int k = 1; k <= 100; k++) {
            System.out.println("target:"+k +" index:" + sol.binarySearchLoop(arr, k));
        }
    }
}