package com.companies.amazon.oa;
//https://leetcode.com/discuss/interview-question/1692832/amazon-online-first-round-sde

/**
 * Problem Statement:
 * Find a subarray of maximum length such that the product of all the elements in the subarray is 1.
 *
 * Sample input:
 * array size: n = 6
 * array = [1, -1, -1, -1, 1, 1]
 *
 * Sample output:
 * 4
 *
 * Explanation:
 * These are a few of the subarrays whose product is equal to 1:
 * Subarray with indices from (0,2), length of the subarray is 3
 * Subarray with indices from (1,2), length of the subarray is 2
 * Subarray with indices from (2,5), length of the subarray is 4
 * Subarray with indices from (4,5), length of the subarray is 2
 */
public class MaxSubArrayWithProductOne {
    //O<N^2) solution with array to track product by index:
    public int maxSubArrayLength(int[] arr){
        if(arr.length == 0) return 0;
        int maxLen = Integer.MIN_VALUE;
        int curLen = 0;

        int[] prods = new int[arr.length + 1];
        int product = 1;
        prods[0] = 1;
        for(int i = 1; i < arr.length; i++) {
            prods[i] = product * arr[i];
        }

        for(int i = 1; i < arr.length - 1; i++) {
            for(int j = i; j < arr.length; j++) {
                int curProd = prods[j] / prods[i - 1];
                curLen = j - i;
                if(curProd == 1 && curLen > maxLen) maxLen = curLen;
            }
        }
        return maxLen;
    }

    //O(N) solution (idea from leetcode):
    public int maxSubArrayLengthII(int[] arr){
        int totalProd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            totalProd = totalProd * arr[i];
        }
        if(totalProd == 1) return arr.length;

        int l = 0, r = arr.length - 1;
        while (arr[l] != -1) {
            l++;
        }
        while (arr[r] != -1) {
            r--;
        }
        int maxLen = arr.length - (Math.min(l, arr.length - r) + 1);
        return maxLen;
    }

    public static void main(String[] args) {
        MaxSubArrayWithProductOne sol = new MaxSubArrayWithProductOne();
        int[] arr1 = {1, 1, -1, 1, -1, -1, 1, 1, 1, 1};
        System.out.println(sol.maxSubArrayLengthII(arr1));

        int[] arr2 = {1, 1, -1, 1, -1, -1, 1, 1, 1, 1};
        System.out.println(sol.maxSubArrayLengthII(arr2));
    }
}
