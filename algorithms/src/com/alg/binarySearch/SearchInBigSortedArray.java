package com.alg.binarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * 447. Search in a Big Sorted Array
 * Given a big sorted array with non-negative integers sorted by non-decreasing order. The array is so big so that you can not get the length of the whole array directly, and you can only access the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++).
 *
 * Find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of the target number.
 *
 * Return -1, if the number doesn't exist in the array.
 *
 * If you accessed an inaccessible index (outside of the array), ArrayReader.get will return 2,147,483,647.
 *
 * Example 1:
 *
 * Input: [1, 3, 6, 9, 21, ...], target = 3
 * Output: 1
 * Example 2:
 *
 * Input: [1, 3, 6, 9, 21, ...], target = 4
 * Output: -1
 * Challenge
 * O(logn) time, n is the first index of the given target number.
 */
public class SearchInBigSortedArray {
    /**
     * Definition of ArrayReader:
     *
     * public class ArrayReader {
     * public int get(int index) {
     *          // return the number on given index,
     *          // return 2147483647 if the index is invalid.
     *     }
     * };
     */
    class ArrayReader {
        int[] list;
        public ArrayReader (int[] array) {
            Arrays.sort(array);
            this.list  = array;
        }
        public int get (int k) {
            int size = list.length;
            if (k >= size) {
                return Integer.MAX_VALUE;
            }
            return list[k];
        }
    }
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int left = 0, right = 1;
        int mid;
        while (reader.get(right) < target) {
            right = right * 2;
        }
        while (left < right) {
            mid = (left + right) / 2;
            if(reader.get(mid) >= target) { // Here the >= will make sure the first element from left will be returned
                right = mid;
            }
            if(reader.get(mid) < target) {
                left = mid + 1;
            }
        }
        if(reader.get(left) == target) {
            return left;
        }
        return -1;
    }

    /**
     * Stepping: Use dynamic steps that can increase/decrease exponentially to find target.
     * Starting from 0, step 1 to right, determine if reader.get(1) is smaller than target
     * @param reader
     * @param target
     * @return
     */
    public int searchBigSortedArray2(ArrayReader reader, int target) {
        int firstElement = reader.get(0);
        if (firstElement == target)
            return 0;
        else if (firstElement > target)
            return -1;

        int idx = 0, jump = 1;
        // 双while循环：外层循环实际上确定idx在内层循环前的位置，相当于二分法的left index；
        // 内层while循环会在idx的基础上寻找下一步的步长jump， 实质上确认right index。
        // 内层循环如果得到了超过target或者array size的结果，会左移一位，相当于除以2，以指数降低步长jump(8->4->2..)直到步长小到idx+jump
        // 再次小于或等于target，然后重置idx(left)的值 （idx += jump;），继续下一次向右jump探索
        while (jump != 0) {
            while (jump != 0 && reader.get(idx + jump) >= target) {   // 越界时返回INT_MAX, 必然不小于target
                jump >>= 1;
            }
            idx += jump;
            jump <<= 1;     // 当jump为0时, 左移一位不影响它的值, 不影响循环结束
        }

        if (reader.get(idx + 1) == target)
            return idx + 1;
        else
            return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[100];
        for(int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        int[] array_1 = {1,3,6,9,21};
        int[] array_2 = {1,2,3,4,5,6};
        int[] array_3 = {1,1,1,1,2,2,3,3,4,4,4,4,5,5,5,5,5,5,5,6,6,6,6,6,6,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,10,10,10,
                10,10,11,11,11,11,12,12,12,13,13,13,13,13,14,14,14,14,14,15,15,15,15,15,15,15,16,16,16,16,16,16,16,16,
                16,17,17,17,17,17,17,17,18,18,19,19,19,19,20,20,20,20,20,20,20,20,20};
        int target = 4;//MODIFY
        SearchInBigSortedArray instance = new SearchInBigSortedArray();
        SearchInBigSortedArray.ArrayReader reader = instance.new ArrayReader(array_3);//MODIFY
        int index = instance.searchBigSortedArray(reader, target);
        System.out.println(index + ": "+ target);
        for(int i = 0; i <= 100; i++) {
            int idx = instance.searchBigSortedArray(reader, i);
            System.out.println(idx + ": "+ i);
        }

    }
}
