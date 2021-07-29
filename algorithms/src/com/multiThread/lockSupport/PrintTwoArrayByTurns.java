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
    }

}
