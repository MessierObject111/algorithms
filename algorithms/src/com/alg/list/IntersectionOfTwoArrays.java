package com.alg.list;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> dup = new HashSet<>();
        int l1 = nums1.length;
        int l2 = nums2.length;
        for(int i = 0; i < l1; i++) {
            if(!set1.contains(nums1[i])){
                set1.add(nums1[i]);
            }
        }

        for(int i = 0; i < l2; i++) {
            if(set1.contains(nums2[i])){
                dup.add(nums2[i]);
            }
        }
        //int[] res = dup.toArray(new int[0]);
        int[] res = new int[dup.size()];
        //dup.toArray(res);
        Integer[] list = dup.toArray(new Integer[0]);
        for(int i = 0; i < dup.size(); i++) {
            res[i] = list[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        IntersectionOfTwoArrays sol = new IntersectionOfTwoArrays();
        int[] res = sol.intersection(nums1, nums2);
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
