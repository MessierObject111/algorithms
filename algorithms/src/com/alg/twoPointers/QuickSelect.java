package com.alg.twoPointers;

/**
 * 461. Kth Smallest Numbers in Unsorted Array
 * Find the kth smallest number in an unsorted integer array.
 * Example 1:
 *
 * Input: [3, 4, 1, 2, 5], k = 3
 * Output: 3
 * Example 2:
 *
 * Input: [1, 1, 1], k = 2
 * Output: 1
 * Challenge
 * An O(nlogn) algorithm is acceptable, if you can do it in O(n), that would be great.
 */
public class QuickSelect {
    /**
     * Analysis: this algorithm actually utilize the same idea from quicksort: first pick a pivot, then partition;
     * the target is on the left side of the pivot or right side. If it is on left side, we don't need to care about
     * sorting the right side, we only need to continue on the left side, recurse & partition until we found the target,
     * vice versa. Each recurse will give us the pivot's relative ranking to the array.
     *
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        return quickSelect(k, nums, 0, nums.length - 1);
    }

    public int quickSelect(int k, int[] nums, int start, int end) {
        if(start == end) return nums[start];
        int i = start, j = end;
        int pivot = nums[(i + j) / 2];
        while (i <= j) {
            // We are finding kth smallest, so the left should be larger than right side
            while (i <= j && nums[i] < pivot) {
                i++;
            }
            while (i <= j && nums[j] > pivot) {
                j--;
            }
            if(i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        // j is actually pivot index or pivot index - 1 here
        if(start + k - 1 <= j) {
            return quickSelect(k, nums, start, j);
        }
        // i is actually pivot index or pivot index + 1 here
        if (start + k - 1 >= i) {
            return quickSelect(k - (i - start), nums, i, end);
        }
        return nums[j + 1];
    }


    public static void main(String[] args) {
        int k = 5;
        int[] nums = {4, 8, 3, 9, 5, 2, 7, 1, 6};
        QuickSelect instance = new QuickSelect();

        int kthNum = instance.kthSmallest(k, nums);
        System.out.print(kthNum);

//        instance.quickSort(nums, 0, nums.length - 1);
//        for(int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i] + " ");
//        }
    }
}
