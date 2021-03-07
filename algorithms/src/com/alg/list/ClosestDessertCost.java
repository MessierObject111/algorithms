package com.alg.list;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;

public class ClosestDessertCost {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int n = baseCosts.length;
        Arrays.sort(toppingCosts);
        reverse(toppingCosts);
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

    public void reverse(int[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        int tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }
}
