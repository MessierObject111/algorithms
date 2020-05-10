package com.alg.binarySearch;

/**
 *
 * 62. Search in Rotated Sorted Array
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

    public static void main(String[] args) {
        SearchInRotatedSortedArray instance = new SearchInRotatedSortedArray();
        int[] nums1 = {4, 5, 1, 2, 3};
        int[] nums2 = {1, 2, 3};
        System.out.println(instance.search(nums1, 4));
        System.out.println(instance.search(nums1, 5));
        System.out.println(instance.search(nums1, 1));
        System.out.println(instance.search(nums1, 2));
        System.out.println(instance.search(nums1, 3));

        System.out.println(instance.search(nums2, 1));
        System.out.println(instance.search(nums2, 2));
        System.out.println(instance.search(nums2, 3));
    }
}
