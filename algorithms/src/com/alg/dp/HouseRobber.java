package com.alg.dp;

public class HouseRobber {
    // Answers from internet. I finally get it. I understand it now.
    //https://leetcode.com/problems/house-robber/discuss/1051790/brute-force-dp
    public int rob(int[] nums) {
        return robRecursion(nums,0);
    }

    private int robRecursion(int[] nums, int index){
        if (index >=nums.length) return 0;
        int included = nums[index] + robRecursion(nums,index+2); // Meaning robbing current house; mark money in this house in total sum in 'included' - then decide next when reaching index + 2, making sure no alarm triggered.
        int not_included =  robRecursion(nums,index+1);// Meaning not robbing current house; no alarm can be triggered,  next decision made on index + 1

        return Math.max(included, not_included);
    }

    /**
     * Split given problem of max profit for robbing N houses to 2 sub problems:
     * The max profit for robbing (N-2) houses + current house,  {nums[i] + dpResultCache[i-2]}
     * the max profit of robbing (N-1) houses, without robbing current house. {dpResultCache[i-1]}
     * Compare those 2 options, and see who has higher return in sum. Pick the higher one.
     * @param nums
     * @return
     */
    public int robDp(int[] nums) {
        int n = nums.length;
        // Edge cases:
        if (n == 0) return 0; // Edge cases:
        if (n == 1) return nums[0];// In only 1 remaining, return whatever the money current house has. We have measures to ensure we only arrive at houses we are allowed to rob.
        if (n == 2) return Math.max(nums[0], nums[1]);// If only 2 houses remaining, pick the one with more money.

        int[] dpResultCache = new int[n]; // Dynamic Programming Result Cache
        dpResultCache[0] = nums[0]; // Initial status for sub-problems: when there is only 1 house left to rob, rob the only one
        dpResultCache[1] = Math.max(nums[0], nums[1]); // Initial status for sub-problems: when there is only 2 houses left to rob, rob the one with more money
        for(int i = 2; i < n; i++) {
            //n>=3: starting from the 3rd house, calculate each sub-problem and store the results in dpResultCache:
            // for 3 houses, pick the higher sum from
            // (current house + the max sum two houses before current house) or
            // (not robbing current house, just use the max sum from previous house)
            dpResultCache[i] = Math.max(nums[i] + dpResultCache[i-2], dpResultCache[i-1]);
        }
        return dpResultCache[n-1];
    }

    public static void main(String[] args) {
        int[] nums = {12, 9, 9, 4, 1, 8};
        int[] nums_2 = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        HouseRobber robber = new HouseRobber();
        long start = System.currentTimeMillis();
        System.out.println(robber.rob(nums));
        System.out.println(robber.rob(nums_2));
        long end = System.currentTimeMillis();
        System.out.println("time elapsed: " + (end - start));
        start = System.currentTimeMillis();
        System.out.println(robber.robDp(nums));
        System.out.println(robber.robDp(nums_2));
        end = System.currentTimeMillis();
        System.out.println("time elapsed: " + (end - start));
    }
}
