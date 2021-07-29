package com.alg.sorting;

public class MyQuickSort extends QuickSort{

    public void quickSort (int[] nums, int i, int j) {

    }

    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public static int[] subarraySumClosest(int[] nums) {
        // write your code here
        int minSum = Integer.MAX_VALUE - 1;
        int [] result = {0, 0};
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i ; j < nums.length; j++ ) {
                if(Math.abs(countSubArraySum(nums, i, j)) < minSum) {
                    minSum = Math.abs(countSubArraySum(nums, i, j));
                    result[0] = i;
                    result[1] = j;
                    System.out.println("sum:"+ minSum + " i:"+ i+ " - "+nums[i]+ " j:"+ j + " - "+nums[j]);
                }
            }
        }
        return result;
    }

    private static int countSubArraySum(int[] nums, int i, int j) {
//        if(i >= j) throw Exception ("Input index is wrong");
        int sum = 0;
        for(int x = i; x <= j; x++) {
            sum = sum + nums[x];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums1 = {-3,1,1,-3,5};
        int[] result1 = subarraySumClosest(nums1);
        for(int i = 0; i < 2; i++) {
            System.out.println(result1[i]); // 0, 2
        }
        System.out.println(countSubArraySum(nums1, 0, 1));
        int[] nums2 = {4,10,13,4,-1,0,3,3,5};
        int[] result2 = subarraySumClosest(nums2);
        for(int i = 0; i < 2; i++) {
            System.out.println(result2[i]); //5, 5
        }
    }

}
