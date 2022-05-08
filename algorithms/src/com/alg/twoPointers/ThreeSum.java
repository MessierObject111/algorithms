package com.alg.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        HashSet<List<Integer>> existingCombo = new HashSet<>();
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length - 2; i++) {
            for(int j = i + 1; j < numbers.length - 1; j++) {
                for(int k = j + 1; k < numbers.length; k++) {
                    if(numbers[i] + numbers[j] + numbers[k]== 0) {
                        ArrayList<Integer> combo = new ArrayList<>();
                        combo.add(numbers[i]);
                        combo.add(numbers[j]);
                        combo.add(numbers[k]);
                        if(!existingCombo.contains(combo)) {
                            existingCombo.add(combo);
                            results.add(combo);
                        }
                    }
                }
            }
        }
        return results;
    }

    //2022-05-04
    public List<List<Integer>> threeSum2(int[] nums) {
        //if we iterate all the combinations, performance will be O(N^3)
        //Reduce this problem by sorting it first, and then apply TwoSumII()
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            //value of nums[i] here will be used for the target sum for the iteration;
            //To avoid getting multiple duplicated result lines for the same sum, we need to skip dup nums[i] values
            if(i == 0 || (i > 0 && nums[i - 1] != nums[i])) {
                int low = i + 1, high =  nums.length - 1, target = -nums[i];
                while(low < high) {
                    if(nums[low] + nums[high] == target) {
                        List<Integer> combo = new ArrayList<Integer>();
                        combo.add(nums[i]);
                        combo.add(nums[low]);
                        combo.add(nums[high]);
                        result.add(combo);
                        //When dup values found for nums[low] or nums[high], skip them too
                        while (low < high && nums[low] == nums[low+1]) low++;
                        while (low < high && nums[high] == nums[high-1]) high--;
                        low++; high--;
                    } else if(nums[low] + nums[high] > target) {
                        high--;
                    } else if(nums[low] + nums[high] < target){
                        low++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum instance = new ThreeSum();
        int[] numbers = {1,0,-1,-1,-1,-1,0,1,1,1};
        List<List<Integer>> results = instance.threeSum(numbers);
        for(List<Integer> row: results) {
            for(Integer num : row) {
                System.out.print(num);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
