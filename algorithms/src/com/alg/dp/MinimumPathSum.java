package com.alg.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */
public class MinimumPathSum {
    Map<String, Integer> dpMap = new HashMap<>();
    public int minPathSum(int[][] grid) {
        int rowNum = grid.length;
        int colNum = grid[0].length;
        int minCount = calculatePaths(grid, rowNum -1, colNum-1);
        return  minCount;
    }

    private int calculatePaths(int[][] grid, int x, int y) {
        String key = 10*x + "-" + 1*y;
        if (dpMap.containsKey(key)) return dpMap.get(key);
        if(x == 0 && y == 0) {
            dpMap.put(key, grid[x][y]);
            return grid[x][y];
        }
        if(x > 0 && y > 0) {
            int countFromX = calculatePaths(grid, x-1, y);
            int countFromY = calculatePaths(grid, x, y-1);
            dpMap.put(key, Math.min(countFromX, countFromY)+ grid[x][y]);
            return Math.min(countFromX, countFromY) + grid[x][y];
        }
        if(x > 0 && y == 0) {
            if (dpMap.containsKey(key)) return dpMap.get(key);
            dpMap.put(key, calculatePaths(grid, x-1, y) + grid[x][y]);
            return calculatePaths(grid, x-1, y) + grid[x][y];
        }
        if(x == 0 && y > 0) {
            if (dpMap.containsKey(key)) return dpMap.get(key);
            dpMap.put(key, calculatePaths(grid, x, y-1) + grid[x][y]);
            return calculatePaths(grid, x, y-1) + grid[x][y];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] grid_1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 3}};
        int[][] grid_2 = {
                {1, 2 ,3},
                {4, 5, 6}};
        MinimumPathSum solution = new MinimumPathSum();
        System.out.println(solution.minPathSum(grid_1));
        System.out.println(solution.minPathSum(grid_2));

    }
}
