package com.companies.meta;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int i = 0, j = 0, k = 0;
        boolean direction = true; //true to move upper-right, false to move lower-left
        while(k < m * n) {
            //Change moving direction and move pointer
            if(direction) {
                //move upper-right
                while(i >= 0 && j < n){
                    res[k] = mat[i][j];
                    System.out.println("i:" + i+  " j:" +j+ " element: "+ res[k]);
                    i--;
                    j++;
                    k++;
                }
            } else {
                //move lower-left
                while(i < m && j >= 0){
                    res[k] = mat[i][j];
                    System.out.println("i:" + i+  " j:" +j+ " element: "+ res[k]);
                    i++;
                    j--;
                    k++;
                }
            }
            System.out.println("End point at: i: " + i + " j: " + j);
            //Jump to another start point at end of each iteration
            if(direction) {
                if(i < 0 && j < n) {
                    i++;
                } else {
                    i = i + 2;
                    j--;
                }
            } else {
                if(j < 0 && i < m) {
                    j++;
                } else {
                    j = j + 2;
                    i--;
                }
            }
            System.out.println("new start point: i: "+ i + " j: "+ j);
            direction = !direction;
            System.out.println("Switch direction: " + (direction ? "upper-right" : "lower-left"));

        }
        return res;
    }

    public static void main(String[] args) {
        DiagonalTraverse sol = new DiagonalTraverse();
        int[][] array = {{1, 2, 3},{4, 5, 6}, {7, 8, 9}};
        int[] res = sol.findDiagonalOrder(array);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
