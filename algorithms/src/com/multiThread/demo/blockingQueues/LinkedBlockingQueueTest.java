package com.multiThread.demo.blockingQueues;

import java.util.Spliterators;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueTest {
    public static LinkedBlockingQueue blockingQueue = new LinkedBlockingQueue(4);

    public static void main(String[] args) {
        System.out.println(blockingQueue.offer("A"));
        System.out.println(blockingQueue.offer("B"));
        System.out.println(blockingQueue.offer("C"));
        System.out.println(blockingQueue.offer("D"));
        System.out.println(blockingQueue.offer("E"));

        while (!blockingQueue.isEmpty()) {
            System.out.println(blockingQueue.poll());
        }
    }
}
