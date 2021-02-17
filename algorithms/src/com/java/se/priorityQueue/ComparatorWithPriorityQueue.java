package com.java.se.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ComparatorWithPriorityQueue {
    public static void main(String[] args) {
        int[] array = {3, 5, 9, 2, 1, 7, 8, 0, 4, 6};
        //initialCapacity, and Comparator
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(array.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        for(int i = 0; i < array.length; i++) {
            minHeap.add(array[i]);
        }
        System.out.println("Peek:" + minHeap.peek() + " size:" + minHeap.size());
        minHeap.poll();
        System.out.println("Peek:" + minHeap.peek() + " size:" + minHeap.size());
        minHeap.remove();
        System.out.println("Peek:" + minHeap.peek() + " size:" + minHeap.size());
        minHeap.offer(2);
        System.out.println("Peek:" + minHeap.peek() + " size:" + minHeap.size());
        minHeap.add(1);
        System.out.println("Peek:" + minHeap.peek() + " size:" + minHeap.size());
    }

}
