package com.alg.twoPointers;

import java.util.ArrayList;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 *
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 * Example
 * Example 1:
 *
 * add(1); add(3); add(5);
 * find(4) // return true
 * find(7) // return false
 */
public class TwoSumIIIDataStructureDesign {
    private static ArrayList<Integer> numbers;
    /**
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        // write your code here
        numbers.add(number);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for(int i = 0; i < numbers.size() - 1; i++) {
            for(int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) + numbers.get(j) == value) {
                    return true;
                }
            }
        }
        return false;
    }
    public TwoSumIIIDataStructureDesign () {
        numbers = new ArrayList<>();
    }

    public static void main(String[] args) {
        TwoSumIIIDataStructureDesign ins = new TwoSumIIIDataStructureDesign();
        ins.add(1);
        ins.add(3);
        ins.add(5);

        System.out.println(ins.find(4));
        System.out.println(ins.find(7));
    }
}
