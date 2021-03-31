package com.multiThread.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockFairnessTest {

    public static void main(String[] args) {
        lockFairnessTest();
    }
    public static void lockFairnessTest() {
//        Lock lock = new ReentrantLock(true);
        Lock lock = new ReentrantLock(false);
        Runnable runnable = ()-> {
            lockSleepUnlock(lock, 1000);
        };

        Thread thread1 = new Thread (runnable, "Thread 1");
        Thread thread2 = new Thread (runnable, "Thread 2");
        Thread thread3 = new Thread (runnable, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
        // The thread scheduler is going to schedule them in random order, not necessarily code order
    }

    private static void lockSleepUnlock(Lock lock, long time) {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " holds the lock.");
            sleep(time);
        } finally {
            lock.unlock();
        }
    }

    private static void sleep(long timeMillis) {
        try {
            Thread.sleep(timeMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
