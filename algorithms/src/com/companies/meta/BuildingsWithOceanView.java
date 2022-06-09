package com.companies.meta;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1762. Buildings With an Ocean View
 * Medium
 *
 * 820
 *
 * 109
 *
 * Add to List
 *
 * Share
 * There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.
 *
 * The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.
 *
 * Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: heights = [4,2,3,1]
 * Output: [0,2,3]
 * Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.
 * Example 2:
 *
 * Input: heights = [4,3,2,1]
 * Output: [0,1,2,3]
 * Explanation: All the buildings have an ocean view.
 * Example 3:
 *
 * Input: heights = [1,3,2,4]
 * Output: [3]
 * Explanation: Only building 3 has an ocean view.
 *
 *
 * Constraints:
 *
 * 1 <= heights.length <= 105
 * 1 <= heights[i] <= 109
 */
public class BuildingsWithOceanView {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int size = 0;
        int curMax = 0;
        for(int i = heights.length-1; i >= 0; i--) {
            int height = heights[i];
            if(height > curMax) {
                curMax = height;
                stack.add(i);
                size++;
            }
        }
        int[] res = new int[size];
        int i = 0;
        while(!stack.isEmpty()) {
            res[i] = stack.pop();
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        BuildingsWithOceanView sol = new BuildingsWithOceanView();
        int[] buildings = {4,2,3,1}; //Expect 0, 2, 3
        int[] res = sol.findBuildings(buildings);
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
