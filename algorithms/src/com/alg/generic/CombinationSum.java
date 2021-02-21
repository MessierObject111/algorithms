package com.alg.generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidtate numbers candidates and a target number target. Find all unique combinations in candidates
 * where the numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Example
 * Example 1:
 *
 * Input: candidates = [2, 3, 6, 7], target = 7
 * Output: [[7], [2, 2, 3]]
 * Example 2:
 *
 * Input: candidates = [1], target = 3
 * Output: [[1, 1, 1]]
 * Notice
 * All numbers (including target) will be positive integers.
 * Numbers in a combination a1, a2, … , ak must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak)
 * Different combinations can be in any order.
 * The solution set must not contain duplicate combinations.
 */
public class CombinationSum {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        int[] nums = removeDuplicates(candidates);

        dfs(nums, 0, new ArrayList<Integer>(), target, results);

        return results;
    }

    private int[] removeDuplicates(int[] candidates) {
        Arrays.sort(candidates);

        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] != candidates[index]) {
                candidates[++index] = candidates[i];
            }
        }

        int[] nums = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            nums[i] = candidates[i];
        }

        return nums;
    }

    private void dfs(int[] nums,
        int startIndex,
        List<Integer> combination,
        int remainTarget,
        List<List<Integer>> results) {
        if (remainTarget == 0) {
            results.add(new ArrayList<Integer>(combination));
            return;
        }
        for(int i = startIndex; i < nums.length; i++) {
            if(remainTarget < nums[i]) {
                break;
            }
            combination.add(nums[i]);
            dfs(nums, i, combination, remainTarget - nums[i], results);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum ins = new CombinationSum();
        int[] candidates = {1, 2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> results = ins.combinationSum(candidates, target);
        for(List<Integer> list : results) {
            for(Integer number : list) {
                System.out.print(number + ", ");
            }
            System.out.println();
        }

        Class myObjectClass = CombinationSum.class;

        Method[] methods = myObjectClass.getMethods();
        for(Method method : methods) {
            System.out.println(method);
        }
    }
}
