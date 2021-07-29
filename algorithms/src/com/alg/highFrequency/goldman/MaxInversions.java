package com.alg.highFrequency.goldman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
https://www.geeksforgeeks.org/count-inversions-of-size-three-in-a-give-array/
Inversion is a strictly decreasing subsequence of length 3. More formally, given an array, p, an inversion in the array
is any time some p[i] > p[j] > p[k] and i < j < k. Given an array of length n, find the number of inversions.

Example)
n = 5, arr = [5, 3, 4, 2, 1]
Array inversions are [5, 3, 2], [5,3,1], [5,4,2], [5,4,1], [5,2,1], [3,2,1], [4,2,1]

n = 4, arr = [4,2,2,1]
The only inversion is [4,2,1] and we do not count the duplicate inversion.

Is there any solution that can do it within n^2? I can only think of n^3.
 */
public class MaxInversions {
    //Brute force: O(N^3)
    public long maxInversions (List<Integer> arr){
        long count = 0;
        for(int i = 0; i < arr.size() - 2; i++){
            for(int j = i + 1; j < arr.size() - 1; j++) {
                if(arr.get(i) > arr.get(j)) {
                    for(int k = j + 1; k < arr.size(); k++) {
                        // If p[i] > p[j]...and p[j] > p[k]...
                        if(arr.get(j) > arr.get(k)) {
                            //then count++
                            System.out.println("[" + arr.get(i) + "," + arr.get(j) +"," + arr.get(k) + "]");
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    //A better solution: O(N^2)

    /**
     * We can reduce the complexity if we consider every element arr[i] as middle element of inversion, find all the
     * numbers greater than a[i] whose index is less than i, find all the numbers which are smaller than a[i] and index
     * is more than i. We multiply the number of elements greater than a[i] to the number of elements smaller than a[i]
     * and add it to the result.
     * Below is the implementation of the idea.
     * @param arr
     * @return
     */
    public long maxInversionsII (List<Integer> arr){
        long count = 0;
        for(int i = 1; i < arr.size() - 1; i++) {
            int leftCount = 0, rightCount = 0;
            for(int l = 0; l < i; l++) {
                if(arr.get(l) > arr.get(i)) leftCount++;
            }
            for(int r = i + 1; r < arr.size(); r++) {
                if(arr.get(r) < arr.get(i)) rightCount++;
            }
            count = count + leftCount * rightCount;
        }
        return count;
    }
    public static void main(String[] args) {

        Integer[] arr = {5, 3, 4, 2, 1};
        List<Integer> list = Arrays.asList(arr);

        MaxInversions sol = new MaxInversions();
        System.out.println(sol.maxInversionsII(list));
    }
}
