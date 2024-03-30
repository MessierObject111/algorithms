package com.alg.list.backtrack;

import java.util.ArrayList;
import java.util.List;

public class NumberCombinations {
    public static List<List<Integer>> generateCombinations(List<Integer> numbers) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), numbers, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, List<Integer> numbers, int start) {
        result.add(new ArrayList<>(tempList));
        for(int i = start; i < numbers.size(); i++) {
            tempList.add(numbers.get(i));
            backtrack(result, tempList, numbers, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * Backtrack function with logs
     * @param result
     * @param tempList
     * @param numbers
     * @param start
     * @param level
     */
    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, List<Integer> numbers, int start, int level) {
        result.add(new ArrayList<>(tempList));
        String space = "";
        String delimiter = "    ";
        for(int i = 0; i<level; i++){
            space = space + delimiter;
        }
        System.out.println(space + "Current tempList: " + tempList);
        for (int i = start; i < numbers.size(); i++) {
            tempList.add(numbers.get(i));
            System.out.println(space + "Added element: " + numbers.get(i));
            backtrack(result, tempList, numbers, i + 1, ++level);
            System.out.println(space + "Removed element: " + tempList.get(tempList.size() - 1));
            tempList.remove(tempList.size() - 1);
        }
        System.out.println(space + "=========================== ");
    }


    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        List<List<Integer>> result = generateCombinations(numbers);

        // Print the result
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
