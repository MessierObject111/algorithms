package com.companies.amazon.oa;

/**
 * https://leetcode.com/discuss/interview-question/1655441/amazon-oa
 * Given an array containing only 0 and 1 as its elements. We have to sort the array in such a manner that all the ones
 * are grouped together and all the zeros are grouped together. The group of ones can be either at the start of the
 * array or at the end of the array. The constraint while sorting is that every one/zero can be swapped only with its
 * adjacent zero/one. Find the minimum number of moves to sort the array as per the description.
 * Example:
 * input array ={0,1,0,1}
 * Final array = {0,0,1,1}
 * Minimum moves = 1 (1 at index 1 is swapped with 0 at index 2)
 *
 * input array = { 1101}
 * Final array - {1110}
 * Minimum moves = 1 {1 at index 2 is swapped with index 3}
 */
public class MinSwapsToGroupNumbers {
    public int minSwaps(int[] arr) {
        int min_0 = swapsWithDirection(arr, true);
        int min_1 = swapsWithDirection(arr, false);
        return Math.min(min_0, min_1);
    }

    private int swapsWithDirection(int[] arr, boolean zeroFirst) {
        if(arr.length <= 1) return 0;
        int counter = 0;
        int l = 0; int r = arr.length - 1;
        if(zeroFirst) {
            while(l < r) {
                while(arr[l] == 0 && l < r) l++;
                while(arr[r] == 1 && l < r) r--;
                if(arr[l] == 1 && arr[r] == 0) {
                    arr[l] = 0;
                    arr[r] = 1;
                    l++;
                    r--;
                    counter++;
                }
            }
        } else {
            while(l < r) {
                while(arr[l] == 1 && l < r) l++;
                while(arr[r] == 0 && l < r) r--;
                if(arr[l] == 0 && arr[r] == 1) {
                    arr[l] = 1;
                    arr[r] = 0;
                    l++;
                    r--;
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] arr_1 = {0,0,1,1};//0
        int[] arr_2 = {1,0,1,1,0,1,0};//2
        int[] arr_3 = {1,0,1,1};//1
        int[][] arrs = {arr_1, arr_2, arr_3};
        MinSwapsToGroupNumbers sol = new MinSwapsToGroupNumbers();
        for(int[] arr : arrs) {
            System.out.println(sol.minSwaps(arr));
        }
        
    }
}
