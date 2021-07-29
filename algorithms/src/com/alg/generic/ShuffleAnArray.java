package com.alg.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleAnArray {
    private int[] arr;
    //微软和苹果似乎很爱出这道题呢
    public ShuffleAnArray(int[] nums) {
        this.arr = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.arr;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffled = new int[arr.length];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Random random = new Random();
        for(int i = 0; i < arr.length; i++) {
            int nextIndex = random.nextInt(list.size());
            int nextInt = list.get(nextIndex);
            shuffled[i] = nextInt;
            list.remove(nextIndex);
        }

        return shuffled;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ShuffleAnArray sol = new ShuffleAnArray(nums);
        int[] shuffled = sol.shuffle();
        for(int i = 0; i < shuffled.length; i++) {
            System.out.println(shuffled[i]);
        }
    }
}
