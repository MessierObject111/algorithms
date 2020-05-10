package com.alg.binarySearch;

/**
 * Find K Closest Elements
 * Given target, a non-negative integer k and an integer array A sorted in ascending order, find the k closest numbers
 * to target in A, sorted in ascending order by the difference between the number and target.
 * Otherwise, sorted in ascending order by number if the difference is same.
 *
 * 1.The value k is a non-negative integer and will always be smaller than the length of the sorted array.
 * 2.Length of the given array is positive and will not exceed 10^4
 * 3.Absolute value of elements in the array will not exceed 10^4
 * ​​
 * Example 1:
 *
 * Input: A = [1, 2, 3], target = 2, k = 3
 * Output: [2, 1, 3]
 * Example 2:
 *
 * Input: A = [1, 4, 6, 8], target = 3, k = 3
 * Output: [4, 1, 6]
 * Challenge
 * O(logn + k) time
 *
 * https://www.lintcode.com/problem/find-k-closest-elements/description
 */
public class FindKClosestElements {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        int[] result = new int[k];

        if (A == null || A.length == 0) {
            return A;
        }
        if (k > A.length) {
            return A;
        }
        int index = findFirstIndex(A, target);
        int start = index - 1;
        int end = index;
        for (int i = 0; i < k; i++) {
            if (start < 0) {
                result[i] = A[end++];
            } else if (end >= A.length) {
                result[i] = A[start--];
            } else {
                if (target - A[start] <= A[end] - target) {
                    result[i] = A[start--];
                } else {
                    result[i] = A[end++];
                }
            }
        }

        return result;
    }

    /**
     * Find the closest number's index to K in array.
     * CAUTION: target could be outside of array's range.
     * @param A
     * @param target
     * @return
     */
    public int findFirstIndex (int[] A, int target) {
        int start = 0, end = A.length - 1;

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if(A[mid] < target){
                start = mid;
            } else {
                end = mid;
            }
        }
        if (target - start < end - target) {
            return start;
        }
        return end;
//        return findFirstIndex()
    }

    public static void main(String[] args) {
        FindKClosestElements instance = new FindKClosestElements();
        int[] array = {1, 3, 4, 6, 8, 9};
        int target = 0;
        int k = 3;
        int[] results = instance.kClosestNumbers(array, target, k);
        for(int num : results) {
            System.out.println(num);
        }

    }
}
