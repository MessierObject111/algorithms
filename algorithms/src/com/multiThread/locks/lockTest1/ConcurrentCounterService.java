package com.multiThread.locks.lockTest1;

import com.java.se.inheritancePolymorphism.question9.C;

import java.time.Duration;
import java.time.Instant;
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

    //Second solutionL lighter weight object monitor
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

    //Third solution is ReentrantLock
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


//Test 1 =========================================
        ExecutorService workerPool
                = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(5);
        Instant start = Instant.now();

        for (int i = 0; i < 5; i++) {
            workerPool.submit(() -> {
                // ...
                System.out.println(Thread.currentThread() + " started counting...");
                for(int j = 0; j < 100; j++) {
                    int newVal = counterService.getCount_1() + 1;
                    counterService.setCount_1(newVal);
                }
                latch.countDown();
            });
        }
        // wait for the latch to be decremented by the 5 remaining threads
        latch.await();

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();

        System.out.println("Final count_1: " + counterService.getCount_1() + " timeElapsed:" + timeElapsed);


//Test 2=========================================
        CountDownLatch latch_2 = new CountDownLatch(5);
        Instant start_2 = Instant.now();

        for (int i = 0; i < 5; i++) {
            workerPool.submit(() -> {
                // ...
                System.out.println(Thread.currentThread() + " started counting...");
                for(int j = 0; j < 100; j++) {
                    int newVal = counterService.getCount_2() + 1;
                    counterService.setCount_2(newVal);
                }
                latch_2.countDown();
            });
        }
        // wait for the latch to be decremented by the 5 remaining threads
        latch_2.await();

        Instant finish_2 = Instant.now();
        long timeElapsed_2 = Duration.between(start_2, finish_2).toMillis();

        System.out.println("Final count_2: " + counterService.getCount_2() + " timeElapsed:" + timeElapsed_2);


//Test 3=========================================
        CountDownLatch latch_3 = new CountDownLatch(5);
        Instant start_3 = Instant.now();

        for (int i = 0; i < 5; i++) {
            workerPool.submit(() -> {
                // ...
                System.out.println(Thread.currentThread() + " started counting...");
                for(int j = 0; j < 100; j++) {
                    int newVal = counterService.getCount_1() + 1;
                    counterService.setCount_1(newVal);
                }
                latch_3.countDown();
            });
        }
        // wait for the latch to be decremented by the 5 remaining threads
        latch_3.await();

        Instant finish_3 = Instant.now();
        long timeElapsed_3 = Duration.between(start_3, finish_3).toMillis();

        System.out.println("Final count_3: " + counterService.getCount_1() + " timeElapsed:" + timeElapsed_3);
        System.exit(0);
    }
}
