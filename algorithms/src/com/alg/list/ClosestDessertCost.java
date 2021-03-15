package com.alg.list;


import java.util.*;
import java.util.stream.Collectors;

public class ClosestDessertCost {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int n = baseCosts.length;
        List<Integer> TCList = new ArrayList<>();
        for(int i = 0; i < toppingCosts.length; i++) {
            TCList.add(toppingCosts[i]);
            TCList.add(toppingCosts[i]);
        }

        TCList = TCList.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }).collect(Collectors.toList());

        int closestCost = 0;
        for(int i = 0; i < n; i++) {
            int base = baseCosts[i];
            int closest = getClosest(toppingCosts, base, target);
            if (Math.abs(closest - target) < Math.abs(closestCost - target)) {
                closestCost = closest;
            }
        }
        return closestCost;
    }

    private int getClosest (int[] toppings, int base, int target) {
        int m = toppings.length;
        for(int i = 0; i < m; i++) {
            if(Math.abs(base + toppings[i] - target) < Math.abs(base - target)) {
                base = base + toppings[i];
            }
        }
        return base;
    }

    public static void main(String[] args) {
        ClosestDessertCost sol = new ClosestDessertCost();
        int[] baseCosts_1 = {1,7};
        int[] toppingCosts_1 = {3,4};
        int target_1 = 10;
        int res_1 = sol.closestCost(baseCosts_1, toppingCosts_1, target_1);
        System.out.println(res_1);
    }
}
