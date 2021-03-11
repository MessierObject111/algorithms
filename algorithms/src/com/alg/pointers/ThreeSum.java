package com.alg.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        HashSet<List<Integer>> existingCombo = new HashSet<>();
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length - 2; i++) {
            for(int j = i + 1; j < numbers.length - 1; j++) {
                for(int k = j + 1; k < numbers.length; k++) {
                    if(numbers[i] + numbers[j] + numbers[k]== 0) {
                        ArrayList<Integer> combo = new ArrayList<>();
                        combo.add(numbers[i]);
                        combo.add(numbers[j]);
                        combo.add(numbers[k]);
                        if(!existingCombo.contains(combo)) {
                            existingCombo.add(combo);
                            results.add(combo);
                        }
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        ThreeSum instance = new ThreeSum();
        int[] numbers = {1,0,-1,-1,-1,-1,0,1,1,1};
        List<List<Integer>> results = instance.threeSum(numbers);
        for(List<Integer> row: results) {
            for(Integer num : row) {
                System.out.print(num);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
