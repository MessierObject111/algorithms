package com.alg.dfs;

/**
 * 695. Max Area of Island
 * Medium
 *
 * 5544
 *
 * 143
 *
 * Add to List
 *
 * Share
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
 * (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class MaxAreaOfIsland {
    /**
     * This is very similar to leetcode 733. Flood Fill
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    int count = searchAndCount(grid, r, c, 0);
                    max = max > count ? max : count;
                }
            }
        }
        return max;
    }

    private int searchAndCount(int[][] grid, int r, int c, int count) {
        if(grid[r][c] == 1) {
            count++;
            grid[r][c] = -1;
            if(r > 0) {
                count = searchAndCount(grid, r - 1, c, count);
            }
            if(r < grid.length - 1) {
                count = searchAndCount(grid, r + 1, c, count);
            }
            if(c > 0) {
                count = searchAndCount(grid, r, c - 1, count);
            }
            if(c < grid[0].length - 1) {
                count = searchAndCount(grid, r, c + 1, count);
            }
            return count;
        }
        return count;
    }
}
