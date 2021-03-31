package com.alg.list;
/*
Easy
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the
 odd elements of A.

You may return any answer array that satisfies this condition.



Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.


Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000
Accepted
310,070
Submissions
413,438
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        if(A.length <= 1) return A;
        int size = A.length;
        int[] result = new int[size];
        int j = 0;
        for(int i = 0; i < size; i++){
            if(A[i] % 2 == 0) {
                result[j] = A[i];
                j++;
            }
        }

        for(int i = 0; i < size; i++){
            if(A[i] % 2 == 1) {
                result[j] = A[i];
                j++;
            }
        }
        return result;
    }
}
