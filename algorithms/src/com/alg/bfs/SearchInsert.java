package com.alg.bfs;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if(target < nums[0]) return 0;
        if(target > nums[nums.length - 1]) return nums.length;
        int result = helper(nums, target, 0, nums.length-1);
        return result;
    }

    private int helper(int[] nums, int target, int s, int e) {
        int mid = s + (e - s)/2;
//        System.out.println("start:" + s + " mid:"+ mid+ " end:" + e);
        if(s > e) {
            return s;
        }

        // This is unlike binary search with certainty that we simply return -1 when
        // target is not among the values; Here we need to find where it is supposed
        // to be inserted, which is a pain. We cannot simply go helper(..., s, mid-1)
        // When we find nums[mid] > target), why?
        if(nums[mid] == target) {
//            System.out.println("mid:"+mid);
            return mid;
        }
        if(nums[mid] > target) {
//            System.out.println("left to: "+ (mid-1));
            return helper(nums, target, s, mid - 1);
        }
//        System.out.println("to right: "+ (mid+1));
         return helper(nums, target, mid + 1, e);
    }

    public int searchInsertIterate(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
//            System.out.println("left:" + left + " mid:"+ pivot+ " right:" + right);
            if (nums[pivot] == target) return pivot;
            if (nums[pivot] > target) right = pivot - 1;
            if (nums[pivot] < target) left = pivot + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsert sol = new SearchInsert();

        int[] nums = {0, 2};
        int target1 = -1;
        int target2 = 1;
        int target3 = 3;

        System.out.println(sol.searchInsert(nums, target1));
        System.out.println(sol.searchInsert(nums, target2));
        System.out.println(sol.searchInsert(nums, target3));

//        int[] nums = {1,3,5,6};
//        int target = 2;
//        System.out.println(sol.searchInsert(nums, target));
    }
}
