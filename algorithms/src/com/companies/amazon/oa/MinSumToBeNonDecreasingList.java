package com.companies.amazon.oa;

public class MinSumToBeNonDecreasingList {
    public int makePowerNonDecreasing(int[] arr) {
        int i = 0;
        int sum = 0;
        while (i + 1 < arr.length) {
            if(arr[i + 1] < arr[i]) {
                int diff = arr[i] - arr[i + 1];
                for(int j = i + 1; j < arr.length; j++) {
                    arr[j] += diff;
                    sum += diff;
                }
            }
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        MinSumToBeNonDecreasingList sol = new MinSumToBeNonDecreasingList();
        int[] arr = {3, 4, 1, 6, 2};
        System.out.println(sol.makePowerNonDecreasing(arr));
    }
}
