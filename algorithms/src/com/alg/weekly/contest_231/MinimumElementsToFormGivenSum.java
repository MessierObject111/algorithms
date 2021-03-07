package com.alg.weekly.contest_231;
//Problem 2
public class MinimumElementsToFormGivenSum {
    public int minElements(int[] nums, int limit, int goal) {
        double sum = 0.0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        double diff = Math.abs(goal - sum);
        double remainder = Math.abs(diff % limit) > 0 ? 1 : 0;
        double res = Math.abs(diff / limit) + remainder;
        return (int) res;
    }

    public static void main(String[] args) {
        MinimumElementsToFormGivenSum sol = new MinimumElementsToFormGivenSum();
        int[] nums_1 = {-1, 0, 1};
        int limit_1 = 3;
        int goal_1 = -4;
        System.out.println(sol.minElements(nums_1, limit_1, goal_1));

        int[] nums_2 = {-1, 0, 1, 1, 1};
        int limit_2 = 1;
        int goal_2 = 771843707;
        System.out.println(sol.minElements(nums_2, limit_2, goal_2));

//        int[] nums_2 = {-1, 0, 1, 1, 1};//Case where sum can be larger than 10^9
//        int limit_2 = 1;
//        int goal_2 = 771843707;
//        System.out.println(sol.minElements(nums_2, limit_2, goal_2));
    }
}
