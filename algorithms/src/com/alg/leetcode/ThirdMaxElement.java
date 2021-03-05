package com.alg.leetcode;

import java.util.*;

public class ThirdMaxElement {

    public int thirdMax(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        Set<Integer> set = new TreeSet();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int MAX = Integer.MIN_VALUE;
        int index = 0;
        List<Integer> list = new ArrayList();
        for(Integer num : set) {

            if (num > MAX) {
                MAX = num;
            }
            if (index == set.size() - 3) {
                return num;
            }
            index++;
        }

        return MAX;
    }

    public static void main(String[] args) {
        ThirdMaxElement solution = new ThirdMaxElement();
        int[] nums = {2,5,2,3,1, 4,5};

        int result = solution.thirdMax(nums);
        System.out.println(result);
    }
}
