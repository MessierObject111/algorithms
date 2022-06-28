package com.companies.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/top-k-frequent-elements/submissions/
public class TopKFreqElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int val = map.get(nums[i]) + 1;
                map.put(nums[i], val);
            } else {
                map.put(nums[i], 1);
            }
        }
        Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((a, b) -> {
            int af = a.getValue();
            int bf = b.getValue();
            return bf - af;
        });
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println("key:"+ entry.getKey() + " val:" + entry.getValue());
            q.offer(entry);
        }
        int[] res = new int[k];
        for(int j = 0; j<k; j++) {
            res[j] = q.poll().getKey();
        }
        return res;
    }
}
