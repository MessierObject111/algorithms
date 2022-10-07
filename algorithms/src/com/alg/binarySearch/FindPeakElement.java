package com.alg.binarySearch;

/**
 * There is an integer array which has the following features:
 *
 * The numbers in adjacent positions are different.
 * A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
 * We define a position P is a peak if:
 *
 * A[P] > A[P-1] && A[P] > A[P+1]
 * Find a peak element in this array. Return the index of the peak.
 *
 * It's guaranteed the array has at least one peak.
 * The array may contain multiple peeks, find any of them.
 * The array has at least 3 numbers in it.
 *
 */
public class FindPeakElement {
    /**
     * Iterate through the array to find the downward points.
     * time complexity: O(n)
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeakA(int[] A) {
        // write your code here
        if(A.length == 1) {
            return A[0];
        }
        int i = 1;
        for(; i < A.length; i++) {
            int pointerA = A[i-1];
            int pointerB = A[i];
            if(pointerB < pointerA) {
                return i - 1;
            }
        }
        return A.length - 1;

    }

    /**
     *
     * @param A
     * @return
     */
    public int findPeakB(int[] A) {
        // write your code here
        if(A.length == 1) {
            return A[0];
        }
        int start = 1, end = A.length -2;
        // Note 1: start + 1 < end
        while (start + 1 < end) {
            // Note 2:
            int mid = start + (end - start)/2;
            // Note 3：=, <, > 分开讨论，mid 不+1也不-1
            // Well we have to check mid - 1 and mid + 1 to see if it is peak for this fucking problem
            if (A[mid - 1] < A[mid]) {
                start = mid;

            } else {
                end = mid;
            }

        }
        if(A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }

    public int findPeak(int[] A) {
        // write your code here
        int start = 1, end = A.length-2; // 1.答案在之间，2.不会出界
        while(start + 1 <  end) {
            int mid = (start + end) / 2;
            if(A[mid] < A[mid - 1]) {
                end = mid;
            } else if(A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }

    //2022-10-06 I totally forgot about details of this question lol

//    A peak element is an element that is strictly greater than its neighbors.
//
//    Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
//
//    You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
//
//    You must write an algorithm that runs in O(log n) time.
//
//
//
//    Example 1:
//
//    Input: nums = [1,2,3,1]
//    Output: 2
//    Explanation: 3 is a peak element and your function should return the index number 2.
//    Example 2:
//
//    Input: nums = [1,2,1,3,5,6,4]
//    Output: 5
//    Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
//
//
//    Constraints:
//
//            1 <= nums.length <= 1000
//            -231 <= nums[i] <= 231 - 1
//    nums[i] != nums[i + 1] for all valid i.
//
    //This question is not clear on what happens when the array size is less than 3, which doesn't qualify the definition of peak-
    //It will lack the two neigbhours needed to compare with.
    //[3,2,1]: the peak is index 0, value 3
    public int findPeakElementC(int[] nums) {
        if(nums.length ==1) return 0;
        if(nums.length ==2) return nums[0] > nums[1] ? 0 : 1;

        //1.Linear search:

        // for(int i = 0; i < nums.length; i++) {
        //     if(isPeak(nums, i)) return i;
        // }

        //2. Binary search; log(N)
        return search(nums, 0, nums.length - 1);

        // return 0;
    }

    private boolean isPeak(int[] nums, int i) {
        if(i == 0) return nums[0] > nums[1] ? true : false;
        if(i == nums.length-1) return nums[nums.length-2] < nums[nums.length-1] ? true : false;
        if(nums[i - 1] < nums[i] && nums[i] > nums[i+1]) return true;
        return false;
    }

    private int search(int[] nums, int i, int j) {
        if(i == j) {
            return i;
        }
        int m = i + (j - i)/2;
        if(nums[m] < nums[m+1]){
            return search(nums, m + 1, j);
        }
        return search(nums, i, m);
    }



    public static void main(String[] args) {
        FindPeakElement instance = new FindPeakElement();
        System.out.println(3/2);
        System.out.println(4/2);

        int[] array = {1,8,2,3,4,5,7,6};
        System.out.println(instance.findPeakB(array));
    }
}
