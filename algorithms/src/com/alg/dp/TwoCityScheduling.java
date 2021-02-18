package com.alg.dp;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        int size = costs.length;
        int aSum = 0, bSum = 0;
        PriorityQueue<int[]> pairs = new PriorityQueue<>(size, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] - o1[1]) - (o2[0] - o2[1]);
            }
        });
        for(int i = 0; i < size; i++) {
//            int aCost = costs[i][0];
//            int bCost = costs[i][1];
            pairs.offer(costs[i]);
        }
        int i = 0, j = 1 + size/2;
        while(i < size/2) {
            int[] pair = pairs.poll();
            aSum = aSum + pair[0];
            i++;
        }
        while(j <= size) {
            int[] pair = pairs.poll();
            bSum = bSum + pair[1];
            j++;
        }
        return aSum + bSum;
    }

    public static void main(String[] args) {
        int[][] costs = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        TwoCityScheduling solution = new TwoCityScheduling();
        System.out.println(solution.twoCitySchedCost(costs));
    }
}
