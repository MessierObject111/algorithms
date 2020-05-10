package com.alg.pointers;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must
 * be less than index2. Please note that your returned answers (both index1 and index2) are zero-based.
 *
 * You may assume that each input would have exactly one solution
 *
 * Example1:
 * numbers=[2, 7, 11, 15], target=9
 * return [0, 1]
 * Example2:
 * numbers=[15, 2, 7, 11], target=9
 * return [1, 2]
 *
 * Challenge
 * Either of the following solutions are acceptable:
 *
 * O(n) Space, O(nlogn) Time
 * O(n) Space, O(n) Time
 *
 */
public class TwoSum {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] results = new int[2];
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    results[0] = i;
                    results[1] = j;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] numbers = {15, 2, 7, 11};
        int target = 9;
    }
}
