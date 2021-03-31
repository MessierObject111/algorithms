package com.multiThread.sumTest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ForkJoinDemo {
    public static void main(String[] args) throws InterruptedException {
//         long[] resultA = {0};
//        final long[] resultB = {0};
//
//        Tasks tasks = new Tasks();
//        Runnable runnableA = new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    resultA[0] = tasks.calculateFactorial(7);
//                    System.out.println(resultA[0]);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        Runnable runnableB = new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    resultB[0] = tasks.fibonacci(7);
//                    System.out.println(resultB[0]);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        Thread t1 = new Thread(runnableA);
//        Thread t2 = new Thread(runnableB);
//
//        t1.start();
//        t2.start();
//
//        // TODO: How to ask one thread here to wait for another to finish and calculate their sum?
//        // Answer: Actually the question itself is not quite well asked. It should be: When to ask main thread to wait
//        // for both t1 and t2 to finish and then use their results to add the sum?
//        t1.join();
//        t2.join();
//        // Main thread will not execute bellow line until t1 and t2 finishes and join to main thread
//        long sum = resultA[0] + resultB[0];
//        System.out.println(sum);
    }

}
