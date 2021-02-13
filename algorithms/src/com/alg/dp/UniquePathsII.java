package com.alg.dp;

import java.util.HashMap;
import java.util.Map;

public class UniquePathsII {
    private Map<String, Integer> dpCache = new HashMap<>();

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length - 1;
        int col = obstacleGrid[0].length - 1;
        if(obstacleGrid[row][col] == 1 || obstacleGrid[0][0] == 1) return 0;
        return pathHelper(obstacleGrid, row, col);
    }
    private int pathHelper (int[][] grid, int x, int y) {
        String key = x*31 + " - " + y*30;
        if(x == 0 && y == 0) return 1;

        if(x > 0 && y > 0) {
            if(grid[x - 1][y] == 1 && grid[x][y - 1] != 1) {
                return pathHelper(grid, x, y - 1);
            }
            if(grid[x][y - 1] == 1 && grid[x - 1][y] != 1) {
                return pathHelper(grid, x - 1, y);
            }
            if(grid[x - 1][y] != 1 && grid[x][y - 1] != 1) {
                if(dpCache.get(key)!=null) {
                    return dpCache.get(key);
                }
                int uniquePath1 = pathHelper(grid, x - 1, y);
                int uniquePath2 = pathHelper(grid, x, y - 1);
                dpCache.put(key, uniquePath1 + uniquePath2);
                return uniquePath1 + uniquePath2;
            }
            return 0;

        } else if (x > 0 && grid[x - 1][y] != 1) {
            return pathHelper(grid, x - 1, y);
        } else if (y > 0 && grid[x][y - 1] != 1) {
            return pathHelper(grid, x, y - 1);
        }
        return 0;
    }

    public static void main(String[] args) {
        UniquePathsII solution = new UniquePathsII();
        long start = System.currentTimeMillis();
        int[][] grid_0 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(solution.uniquePathsWithObstacles(grid_0));

        int[][] grid_1 = {{0, 0, 1}};
        System.out.println(solution.uniquePathsWithObstacles(grid_1));

        int[][] grid_2 = {{0, 0, 0}};
        System.out.println(solution.uniquePathsWithObstacles(grid_2));

        int[][] grid_3 = {{0}, {0}, {0}};
        System.out.println(solution.uniquePathsWithObstacles(grid_3));

        int[][] grid_4 = {{0, 1}, {1, 0}};
        System.out.println(solution.uniquePathsWithObstacles(grid_4));

        int[][] grid_5 = {{0, 0}, {1, 1}, {0, 0}};
        System.out.println(solution.uniquePathsWithObstacles(grid_5));

        int[][] grid_6 = {{0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,1,1,0,0,1,0,1,1,0,1,0,0,1,0,0,0,1,0,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,0,1,0,0,0},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0,1,0,0,0,0,0,0,1,0,0,1,0,1},
                {0,0,0,1,0,0,0,0,0,0,0,1,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,1,0,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,1,0,0,1,0,0},
                {0,0,0,0,0,0,1,0,0,0,1,1,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0},
                {1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,1,0,0,0,1},
                {0,0,0,0,1,0,0,1,0,1,1,1,0,0,0,1,0,0,1,0,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
                {1,0,1,0,1,1,0,1,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,1,1,0,0,0,0,1,0,0,0,1,0},
                {0,0,0,0,0,0,1,0,0,1,1,0,0,1,0,0,0,0,1,0,0,1,1,0,0,0,0,0,1,0,0,1,0,0,0,1},
                {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,1,0,0,0},
                {1,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
                {0,1,0,0,1,0,0,0,0,0,1,0,1,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,0,0,0,0,1,0,0,1,1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
                {0,0,1,0,1,0,1,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0},
                {0,0,0,1,0,1,0,0,1,0,0,0,0,0,1,1,1,0,1,1,1,0,0,1,0,1,0,1,1,1,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,0,0,0,0,1,0,0,1,1,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
                {0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,1,0,0},
                {0,0,0,0,1,0,0,1,0,0,0,0,0,0,1,0,0,1,0,1,1,1,0,0,0,0,0,0,1,0,0,0,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0}};
        System.out.println(solution.uniquePathsWithObstacles(grid_6));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
