package com.alg.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    /** initialize your data structure here. */
    public MedianFinder() {
        min = new PriorityQueue<Integer>();
        max = new PriorityQueue<Integer>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()){
            max.offer(min.poll());
        }

    }

    public double findMedian() {
        double median;
        if(min.size() == max.size()) {
            median = (min.peek() + max.peek()) / 2.0;
        } else {
            median = max.poll();
        }
        return median;
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(2);
        obj.addNum(8);
        double median = obj.findMedian();
        System.out.println(median);//5
        obj.addNum(7);
        median = obj.findMedian();
        System.out.println(median);//7
        obj.addNum(3);
        median = obj.findMedian();
        System.out.println(median);//5
        obj.addNum(9);
        obj.addNum(5);
        //2 3 5 8 7 9
        median = obj.findMedian();
        System.out.println(median);//6.5
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
