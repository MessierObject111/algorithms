package com.alg.recursion;

import java.util.*;

public class CombinationSum {
    private Set<List<Integer>> results;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        results = new HashSet<List<Integer>>();
        for(int i = 0; i < candidates.length; i++) {
            List<Integer> subList = new ArrayList<Integer>();
            subList.add(candidates[i]);
            search(candidates, target - candidates[i], subList, i);
        }
        List<List<Integer>> mainList = new ArrayList<List<Integer>>();
        mainList.addAll(results);
        return mainList;
    }

    private void search(int[] candidates, int target, List<Integer> subList, int i) {
        if(target < 0) return;
        if(target == 0) {
            results.add(subList);
            return;
        }

        for(int j = i; j < candidates.length; j++) {
            List<Integer> newSubList = new ArrayList<Integer>(subList);
            newSubList.add(candidates[j]);
            search(candidates, target - candidates[j], newSubList, j);
        }
    }
}
