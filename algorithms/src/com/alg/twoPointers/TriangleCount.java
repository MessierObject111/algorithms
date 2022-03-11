package com.alg.twoPointers;

import java.util.Arrays;

/**
 * Given an array of integers, how many three numbers can be found in the array, so that we can build an triangle whose
 * three edges length is the three numbers that we find?
 *
 * Example 1:
 *
 * Input: [3, 4, 6, 7]
 * Output: 3
 * Explanation:
 * They are (3, 4, 6),
 *          (3, 6, 7),
 *          (4, 6, 7)
 * Example 2:
 *
 * Input: [4, 4, 4, 4]
 * Output: 4
 * Explanation:
 * Any three numbers can form a triangle.
 * So the answer is C(3, 4) = 4
 *
 */
public class TriangleCount {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        // write your code here
        Arrays.sort(S);
        int sum = 0;
        for(int i = 0; i < S.length - 2; i++) {
            for(int j = i+1; j < S.length - 1; j++) {
                for(int k = j+1; k < S.length; k++) {
                    if(S[i] + S[j] > S[k] &&
                            S[i] + S[k] > S[j] &&
                            S[j] + S[k] > S[i]) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TriangleCount instance = new TriangleCount();
        int[] numbers = {3, 4, 6, 7};
        System.out.print(instance.triangleCount(numbers));

    }
}
