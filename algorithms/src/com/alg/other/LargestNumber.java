package com.alg.other;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                String s1 = String.valueOf(i1);
                String s2 = String.valueOf(i2);
                BigInteger v1 = new BigInteger(s1 + s2);
                BigInteger v2 = new BigInteger(s2 + s1);
                return v2.compareTo(v1);
            }
        });
        for(int i = 0 ; i< nums.length;i++) {
                queue.add(nums[i]);
        }
        while(!queue.isEmpty()) {
                String temp = String.valueOf(queue.poll());
                sb.append(temp);
        }
        String res = sb.toString();
        while (res.charAt(0) == '0' && res.length() > 1) {
            res = res.substring(1, res.length());
        }
        return res;
    }

    public static void main(String[] args) {
        LargestNumber s = new LargestNumber();

        int[] input1 = {3,30,34,5,9};
        int[] input2 = {999999991,9};
        int[] input3 = {0,0};
        int[] input4 = {99, 9, 5, 98, 90};
        System.out.println(s.largestNumber(input1));
        System.out.println(s.largestNumber(input2));
        System.out.println(s.largestNumber(input3));
        System.out.println(s.largestNumber(input4));
    }
}
