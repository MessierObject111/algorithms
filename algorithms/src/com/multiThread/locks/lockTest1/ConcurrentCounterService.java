package com.multiThread.locks.lockTest1;

import com.java.se.inheritancePolymorphism.question9.C;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentCounterService {
    //First solution: Heavy weight lock: synchronized keyword
    private int count_1 = 0;

    public int getCount_1() {
        return count_1;
    }

    public synchronized void setCount_1(int time) {
        this.count_1 = time;
    };

    private int count_2;
    Object lock = new Object();

    public int getCount_2() {
        return this.count_2;

    }

    public void setCount_2(int time) {
        synchronized (lock) {
            this.count_2 = time;
        }
    }

    private int count_3;
    Lock reentrantLock = new ReentrantLock();

    public int getCount_3(){
//        reentrantLock.lock();
        int result = count_3;
//        reentrantLock.unlock();
        return result;
    }

    public void setCount_3(int time) {
        reentrantLock.lock();
        this.count_3 = time;
        reentrantLock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
//        Object mutex = new Object();
        ConcurrentCounterService counterService = new ConcurrentCounterService();
//        ThreadPoolExecutor threadPoolExecutor =
//                (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
//        CountDownLatch latch = new CountDownLatch(5);
//
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " started counting...");
                for(int i = 0; i < 100; i++) {
                    int newVal = counterService.getCount_1() + 1;
                    counterService.setCount_1(newVal);
//                    latch.countDown();
                }
//                    synchronized (mutex) {
//                        mutex.notifyAll();
//                    }

            }
        };
//        synchronized (latch) {
//            for(int i = 0; i < 5; i++) {
//                threadPoolExecutor.submit(task);
//            }
//            try {
//                latch.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//        //Thread.sleep(6000);
//        System.out.println("Final count_1: " + counterService.getCount_1());


        ExecutorService WORKER_THREAD_POOL
                = Executors.newFixedThreadPool(10);
        CountDownLatch latch2 = new CountDownLatch(2);
        for (int i = 0; i < 2; i++) {
            WORKER_THREAD_POOL.submit(() -> {
                // ...
                System.out.println(Thread.currentThread() + " started counting...");
                for(int j = 0; j < 100; j++) {
                    int newVal = counterService.getCount_1() + 1;
                    counterService.setCount_1(newVal);
                }
                latch2.countDown();
            });
        }

// wait for the latch to be decremented by the two remaining threads
        latch2.await();
        System.out.println("Final count_1: " + counterService.getCount_1());
        System.exit(0);
    }
}
