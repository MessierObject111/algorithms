package com.alg.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MaxScoreByMultiplications {
    public int maximumScore(int[] nums, int[] multipliers) {
        int size_n = nums.length;
        int size_m = multipliers.length;
        int countStep = size_m;
        // n >= m
        int sum = 0;
        // First, we need to order them and count how many negative values from each array
//        Comparator<Integer> AbsComparator = new Comparator<Integer>(){
//
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        };
//        Arrays.sort(nums, AbsComparator);
//        List<Integer> sortedNums = Arrays.stream(nums).boxed()
//                .sorted((a,b) -> {
//                    return Math.abs(a) - Math.abs(b);
//                })
//                .collect(Collectors.toList());
        Arrays.sort(nums);
        Arrays.sort(multipliers);

        int n1 = 0, n2 = 0; // Number of negatives
        int p1 = 0, p2 = 0; // Number of positives
        // Populate 2 lists for negative values, 2 lists for positive values
        LinkedList<Integer> num_n = new LinkedList<>();
        LinkedList<Integer> num_p = new LinkedList<>();
        LinkedList<Integer> mul_n = new LinkedList<>();
        LinkedList<Integer> mul_p = new LinkedList<>();

        for(int i = 0; i < size_n; i++) {
            if(nums[i] < 0) {
                num_n.add(nums[i]);
                n1++;
            } else {
                num_p.add(nums[i]);
                p1++;
            }
        }
        for(int i = 0; i< size_m; i++) {
            if(multipliers[i] < 0) {
                mul_n.add(multipliers[i]);
                n2++;
            } else {
                mul_p.add(multipliers[i]);
                p2++;
            }
        }
        //Keep track of remaining multipliers. If ran out, return sum.
        while(p2 + n2 > 0) { // Or use countStep
            //if both list contain p and n
            if(p1 > 0 && p2 > 0 && n1 > 0 && n2 > 0) {
                int negative1 = num_n.peekFirst();
                int negative2 = mul_n.peekFirst();
                int positive1 = num_p.peekLast();
                int positive2 = mul_p.peekLast();
                if(negative1 * negative2 >= positive1 * positive2) {
                    sum += negative1 * negative2;
                    num_n.pollFirst();
                    mul_n.pollFirst();
                    n1--;
                    n2--;
                } else {
                    sum += positive1 * positive2;
                    num_p.pollLast();
                    mul_p.pollLast();
                    p1--;
                    p2--;
                }
                continue;
            }
            if(n2 > 0 && n1 > 0 && (p1 == 0 || p2 == 0)) {
                if(n1 > 0) {
                    int negative1 = num_n.pollLast();
                    int negative2 = mul_n.pollLast();
                    sum += negative1 * negative2;
                    n1--;
                    n2--;
                    continue;
                } else if(p1 > 0) {
                    int positive1 = num_p.pollLast();
                    int negative2 = mul_n.pollLast();
                    sum += positive1 * negative2;
                    p1--;
                    n2--;
                }
            }
            if(n2 == 0 && p1 > 0) { // p2, and (n1 + p1) are guaranteed to be more than 0 here
                int positive1 = num_p.pollLast();
                int positive2 = mul_p.pollLast();
                //
                sum += positive1 * positive2;
                p1--;
                p2--;
                continue;
            }
            if(n2 == 0 && p1 == 0 && p2 + n2 > 0) { // n1, and (n1 + p1) are guaranteed to be more than 0 here
                int negative1 = num_n.pollFirst();// pick largest negative number (closer to zero)
                int positive2 = mul_p.pollLast();// Pick smallest positive number (closer to zero)
                sum += negative1 * positive2;
                n1--;
                p2--;
                continue;
            }
            System.out.println("---p1: " + p1 + " n1: " + n1 +"---" + "---p2: " + p2 + " n2: " + n2 +"---");
        }

        return sum;
    }

    public static void main(String[] args) {
        MaxScoreByMultiplications max = new MaxScoreByMultiplications();
//        int[] nums_1 = {1,2,3};
//        int[] mul_1 = {3,2,1};
//        System.out.println(max.maximumScore(nums_1, mul_1));


        int[] nums_2 = {-5,-3,-3,-2,7,1};
        int[] mul_2 = {-10,-5,3,4,6};
        System.out.println(max.maximumScore(nums_2, mul_2));

//
//        int number = 1234;
//        int digit = (int) (Math.log10(number) + 1);
    }
}
