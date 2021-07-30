package com.multiThread.lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * Question: How to print elements from 2 diff arrays by turns with 2 threads?
 */
public class PrintTwoArrayByTurns {
    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        char[] arr1 = "12345".toCharArray();
        char[] arr2 = "abcde".toCharArray();


        t1 = new Thread (()->{

            for(char c : arr1) {
                System.out.println(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }

        }, "t1");

        t2 = new Thread (()->{

            for(char c : arr2) {
                LockSupport.park();
                System.out.println(c);
                LockSupport.unpark(t1);
            }

        }, "t2");


        t1.start();
        t2.start();

        //Below is a traditional way to solve this problem without using LockSupport:
        //The lock object:
        Object o = new Object();

        Thread r1 = new Thread (()->{
            synchronized (o) {
                for(char c: arr1) {
                    System.out.println(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
            }
        });


        Thread r2 = new Thread(()->{
            synchronized (o) {
                for(char c: arr2) {
                    System.out.println(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
            }
        });

        r1.start();
        r2.start();

        System.exit(0);
    }

}
