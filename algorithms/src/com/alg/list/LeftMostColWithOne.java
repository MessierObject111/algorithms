package com.alg.list;

import java.util.ArrayList;
import java.util.List;
/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

/**

 0 0 1 1
 0 1 1 1
 0 0 0 1

 is also a valid matrix, given the conditions.
 This is a problem leaning toward solution idea challenge, rather than implementation challenges. Have to be smart about
 how to find such row
 Damn, turns out implementation is tricky to form as well

 Terminal condition: either we reached left most col with current value == 1 (return current col, which is 0); or
 we reached down most row with current value == 0 (return previous left most index on history)

 What is current value 1 or 0?
 if 1
    Are we in leftmost col?
    if Yes: return col
    if No: Compare & Update left value, then go left & down (step)

    Are we in down most row?
    if Yes: Compare & Update left value, then go left
    if No: Compare & Update left value, then go down
 if 0
    go left & down (step)
 Are we
 **/
public class LeftMostColWithOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rowSize = dimensions.get(0);
        int colSize = dimensions.get(1);
        int row = 0;
        int col = colSize - 1;
        int result = -1;

        while(row <= rowSize-1) {
            int current = binaryMatrix.get(row, col);
            if(current == 0) {
                if(row < rowSize) {
                    row++;
                }
                if(row == rowSize - 1) {

                }

            } else if(current == 1) {

                if(col > 0) {
                    result = col;
                    col--;
                }
                if(col == 0) {
                    return 0;
                }

            }
        }
        return result;
    }

    private class BinaryMatrix {
        private final int[][] matrix;

        public BinaryMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public List<Integer> dimensions() {
            List<Integer> dimen = new ArrayList<>();
            dimen.add(matrix.length, matrix[0].length);
            return dimen;
        }

        public int get(int row, int col) {
            return matrix[row][col];
        }
    }
}
