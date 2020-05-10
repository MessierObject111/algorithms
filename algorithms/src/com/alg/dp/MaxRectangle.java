package com.alg.dp;

public class MaxRectangle {
    /**
     * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
     *
     * Example:
     *
     * Input:
     * [
     *   ["1","0","1","0","0"],
     *   ["1","0","1","1","1"],
     *   ["1","1","1","1","1"],
     *   ["1","0","0","1","0"]
     * ]
     * Output: 6
     */
    public int maximalRectangle(char[][] matrix) {
        int max = Integer.MIN_VALUE;
        if(matrix[0].length < 1) {

        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    int currentMax = calculateMaxRect(matrix, i, j);
                    if (currentMax > max) {
                        max = currentMax;
                    }
                }
            }
        }
        return 0;
    }

    private int calculateMaxRect (char[][] matrix, int i, int j) {
        int maxVerticalRange = 0;
        for(int verticalIndex = i; verticalIndex < matrix.length ; verticalIndex++) {
            int maxHorizontalRange = 0;
            for (int horizontalIndex = j; horizontalIndex < matrix[verticalIndex].length; horizontalIndex++) {
                if (matrix[verticalIndex][horizontalIndex] == '0') {
                    maxHorizontalRange = horizontalIndex - 1;

                }
            }
        }
        return 0;
    }
}
