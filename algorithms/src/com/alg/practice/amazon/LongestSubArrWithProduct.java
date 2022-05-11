package com.alg.practice.amazon;

/**
 * A question about Amazon student badges but ultimately the problem was given an arr of -1 or 1, return the maximum subarray length with a product of 1.
 * The array is of size 2 and above and only contains -1 and 1
 * e.g arr = [-1,-1,1,1,-1], return 4, since index 0 to 3 have the max length with product equal to 1
 *
 * I tried to use a sliding window but only passed 4/13 cases. there was somthing i had to fix in the logic for the case arr = [ -1,-1,-1,-1,-1, 1]
 */
public class LongestSubArrWithProduct {
    public int longestSubArr(int[] input){
        int MAX = 0;
        for(int i = 0 ; i < input.length-1; i++){
            for(int j = i + 1; j < input.length; j++) {
                int r = checkProduct(input, i, j);
                if(r == 1 && MAX < (j - i + 1)) {
                    MAX = j - i + 1;
                    System.out.println("i:" + i + " j:"+j);
                }
            }
        }
        return MAX;
    }

    private int checkProduct (int[] a, int i, int j) {
        int p = 1;
        for(int k = i; k <= j; k++) {
            p = p * a[k];
        }
        return p;
    }

    public static void main(String[] args) {
        int[] arr = {-1,-1,-1,-1,-1, 1};
        int[] arr1 = {-1,-1,1,1,-1};
        LongestSubArrWithProduct sol = new LongestSubArrWithProduct();
        System.out.println(sol.longestSubArr(arr));
        System.out.println(sol.longestSubArr(arr1));
    }
}
