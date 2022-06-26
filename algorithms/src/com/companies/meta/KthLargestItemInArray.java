package com.companies.meta;

import java.util.PriorityQueue;
import java.util.Queue;
//https://leetcode.com/problems/kth-largest-element-in-an-array/
//215. Kth Largest Element in an Array
//Medium
//
//10521
//
//551
//
//Add to List
//
//Share
//Given an integer array nums and an integer k, return the kth largest element in the array.
//
//Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//
//
//Example 1:
//
//Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
//Example 2:
//
//Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
public class KthLargestItemInArray {
    public int findKthLargest(int[] nums, int k) {
        int res;
        Queue<Integer> q = new PriorityQueue<>( (n1, n2)-> n2-n1);
        for(int i = 0; i < nums.length; i++) {
            q.offer(nums[i]);
        }
        int j = 0;
        while(j < k - 1) {
            q.poll();
            j++;
        }
        res = q.poll();
        return res;
    }
}
