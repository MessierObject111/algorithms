package com.alg.list;

import com.java.se.inheritancePolymorphism.question9.B;

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
    Are we in leftmost col & down most row?
    if Yes, return col;
    if No, do below logic
        Are we in leftmost col?
        if Yes: return col
        if No: Compare & Update left value, then go left & down (step)

        Are we in down most row?
        if Yes: Compare & Update left value, then go left
        if No: Compare & Update left value, then go down
 if 0
     Are we in leftmost col & down most row?
     if Yes, return result;
     if No, do below logic
         Are we in leftmost col?
         if Yes: go down (step)
         if No: go left & down (step)

         Are we in down most row?
         if Yes: go left
         if No: go left & down (step)

 **/
public class LeftMostColWithOne {
    private int result = Integer.MAX_VALUE;
    private int rowSize;
    private int colSize;
    private boolean existAtLeastOne = false;

    private void step(BinaryMatrix binaryMatrix, int row, int col, int result) {
        int currentVal = binaryMatrix.get(row, col);
        System.out.println("col:" + col + " row:" + row + " val:" + currentVal);
        if(currentVal == 1) {
            if(col == 0 && row == rowSize - 1) {
                this.result = col < this.result ? col : this.result;
                return;
            }
            if(col == 0) {
                this.result = col < this.result ? col : this.result;
                return;
            }
            if(row == rowSize - 1) {
                this.result = col < this.result ? col : this.result;
                //Step left
                step(binaryMatrix, row, col - 1, this.result);
            }
            else{
                this.result = col < this.result ? col : this.result;
                //Step left
                step(binaryMatrix, row, col - 1, this.result);
            }
            existAtLeastOne = true;
        }
        if(currentVal == 0) {
            if(col == 0 && row == rowSize - 1) {
                return;
            }
            if(col == 0) {
                //Step down
                step(binaryMatrix, row + 1, col, this.result);
            }
            if(row == rowSize - 1) {
                //Step left
                step(binaryMatrix, row, col - 1, this.result);
            }
            else{
                //Step down
                step(binaryMatrix, row + 1, col, this.result);
            }
        }
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        this.rowSize = dimensions.get(0);
        this.colSize = dimensions.get(1);
        int row = 0;
        int col = colSize - 1;
        step(binaryMatrix, row, col, this.result);

        if(existAtLeastOne) return this.result;
        return -1;
    }

    class BinaryMatrix {
        private final int[][] matrix;

        public BinaryMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public List<Integer> dimensions() {
            List<Integer> dimen = new ArrayList<>();
            dimen.add(matrix.length);
            dimen.add(matrix[0].length);
            return dimen;
        }

        public int get(int row, int col) {
            return matrix[row][col];
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {{0, 0}, {0, 1}};
        int[][] matrix = {{1,1,1,1,1},{0,0,0,1,1},{0,0,1,1,1},{0,0,0,0,1},{0,0,0,0,0}};
        LeftMostColWithOne sol = new LeftMostColWithOne();
        BinaryMatrix binaryMatrix = sol.new BinaryMatrix(matrix);
        int result = sol.leftMostColumnWithOne(binaryMatrix);
        System.out.println(result);
    }
}
