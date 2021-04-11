package com.alg.dp;

public class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                int longest = searchForIncrease(i, j, matrix);
                max = max > longest ? max : longest;
            }
        }
        return max;
    }

    private int searchForIncrease(int i, int j, int[][] matrix){
        int up = 0;
        int left = 0;
        int down = 0;
        int right = 0;
        if(i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            up = 1 + searchForIncrease(i - 1, j, matrix);
        }
        if(j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            left = 1 + searchForIncrease(i, j - 1, matrix);
        }
        if(i < matrix.length -1 && matrix[i + 1][j] > matrix[i][j]) {
            down = 1 + searchForIncrease(i + 1, j, matrix);
        }
        if(j < matrix[0].length -1 && matrix[i][j + 1] > matrix[i][j]) {
            right = 1 + searchForIncrease(i, j + 1, matrix);
        }
        if(up != 0 || left != 0 || down != 0 || right != 0) {
            return getMax(up, left, down, right);
        }
        return 1;
    }

    private int getMax(int a, int b, int c, int d) {
        int max = Integer.MIN_VALUE;
        if(a > max) max = a;
        if(b > max) max = b;
        if(c > max) max = c;
        if(d > max) max = d;
        return max;
    }
}
