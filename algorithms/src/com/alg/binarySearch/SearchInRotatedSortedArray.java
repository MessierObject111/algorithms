package com.alg.binarySearch;

/**
 *
 * Leetcode 33, Lintcode 62. Search in Rotated Sorted Array
 *
 * Description
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * ***IMPORTANT***
 * That fucking pivot could have been 0. That means this list have not been moved at all. Like
 * num[] array = {1, 2, 3}; is a valid case. Tricky huh?
 *
 * You may assume no duplicate exists in the array.
 * Example
 * Example 1:
 *
 * Input: [4, 5, 1, 2, 3] and target=1,
 * Output: 2.
 * Example 2:
 *
 * Input: [4, 5, 1, 2, 3] and target=0,
 * Output: -1.
 * Challenge
 * O(logN) time
 *
 *
 *
 * Best way to analysis this problem is by drawing the scenarios on paper, analyze different rotation cases.
 */
public class SearchInRotatedSortedArray {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0, end = A.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = (start + end)/2;
            if(target == A[mid]) {
                return mid;
            }
            if(A[start] > A[mid]) {
                // Scenario 1: rotating point is left to middle
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                //Scenario 2: rotating point is right to middle
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        if(target == A[start]) return start;
        if(target == A[end]) return end;
        return -1;
    }

    //2022-10-09 Second attempt, failed multiple times. The method to find the pivot of rotating suffered multiple bugs;
    //Mistake 1: When doing search for rotating pivot, I assumed that, for a sub-array from l to r, I can know if pivot
    // is in left or right half of this sub-array by comparing the value of nums[l], nums[m] and nums[r]:
    /**
        if(l == r) return l;
        int m = l + (r - l) / 2;
        if(nums[m - 1] > nums[m]) return m;
        if(nums[l] > nums[m]) {
            return findPivot(nums, l, m - 1);
        }
        return findPivot(nums, m + 1, r);
    **/
    // This would fail when pivot happened to be sitting on l itself. e.g {4, 5, 6, 7, 1, 2, 3}; first pivot will land
    // on 7, and go to right half {... 1, 2, 3}; then it will fail at it because pivot is 1, but it goes for right half.
    //For this part, I still don't quite understand what is the standard template to use, and how I failed

    //Mistake 2: Didn't check corner cases like target missing from array entirely, and 1 element array handling.

    public int search2(int[] nums, int target) {
        int n = nums.length;
        if (n == 1) return nums[0] == target ? 0 : -1;//Corner case check when array length is only 1
        int pivot = findPivot(nums);
        System.out.println("pivot: " + pivot);
        if(pivot == 0) return search2(nums, 0, nums.length - 1, target);
        if(target >= nums[0]) return search2(nums, 0, pivot - 1, target);
        return search2(nums, pivot, nums.length - 1, target);
    }

    private int findPivot(int[] nums){
        if(nums[0] < nums[nums.length - 1]) return 0;
        return findPivot(nums, 0, nums.length - 1);
    }

    private int findPivot(int[] nums, int l, int r){
        //if(l == r) return l;
        int m = l + (r - l) / 2;
        System.out.println("l: " + l +" m: " +m +" r: " +r);
        //Logic flawed here
        if(nums[m] > nums[m + 1]) return m + 1;
        if(nums[l] > nums[m]) {
            System.out.println("Left");
            return findPivot(nums, l, m - 1);
        }
        System.out.println("Right");
        return findPivot(nums, m + 1, r);
    }

    private int search2(int[] nums, int l, int r, int target) {
        if(l == r) return nums[l] == target ? l: -1;
        int m = (l + r)/2;
        if(nums[m] < target) return search2(nums, m + 1, r, target);
        return search2(nums, l, m, target);
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray instance = new SearchInRotatedSortedArray();
        int[] nums1 = {4, 5, 1, 2, 3};
        int[] nums2 = {1, 2, 3};
        int[] nums3 = {4, 5, 6, 7, 1, 2, 3};//Pivot should be 4
        int[] nums4 = {5, 1, 3};//Pivot should be 1
        int[] nums5 = {1};

        System.out.println("Test 1");
        System.out.println(instance.search(nums1, 4));
        System.out.println(instance.search(nums1, 5));
        System.out.println(instance.search(nums1, 1));
        System.out.println(instance.search(nums1, 2));
        System.out.println(instance.search(nums1, 3));

        System.out.println("Test 2");
        System.out.println(instance.search(nums2, 1));
        System.out.println(instance.search(nums2, 2));
        System.out.println(instance.search(nums2, 3));

        System.out.println("Test 3");
        System.out.println(instance.search(nums3, 4));
        System.out.println(instance.search(nums3, 5));
        System.out.println(instance.search(nums3, 6));
        System.out.println(instance.search(nums3, 7));
        System.out.println(instance.search(nums3, 1));
        System.out.println(instance.search(nums3, 2));
        System.out.println(instance.search(nums3, 3));

        System.out.println("Test 4");
        System.out.println(instance.search(nums4, 5));
        System.out.println(instance.search(nums4, 1));
        System.out.println(instance.search(nums4, 3));

        System.out.println("Test 5");
        System.out.println(instance.search(nums5, 1));
    }
}
