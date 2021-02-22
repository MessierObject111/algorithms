package com.alg.list;

public class MinNumbersOpsNeededToMoveAllBalls {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int sum[] = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if(Integer.valueOf(boxes.substring(j, j+1)) == 1) {
                    sum[i] = sum[i] + Math.abs(j-i);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MinNumbersOpsNeededToMoveAllBalls s = new MinNumbersOpsNeededToMoveAllBalls();

        String input_1 = "110";
        int[] result_1 = s.minOperations(input_1);
        for(int i = 0; i<input_1.length(); i++){
            System.out.println(result_1[i]);
        }
    }
}
