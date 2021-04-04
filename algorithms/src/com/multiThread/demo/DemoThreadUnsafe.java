package com.multiThread.demo;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class DemoThreadUnsafe {

    // We'll use this to randomly sleep our threads
    static Random random = new Random(System.currentTimeMillis());

    public static void main(String args[]) throws InterruptedException {

        // create object of unsafe counter
        ThreadUnsafeCounter badCounter = new ThreadUnsafeCounter();

        // setup thread1 to increment the badCounter 200 times
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    badCounter.increment();
                    DemoThreadUnsafe.sleepRandomlyForLessThan10Secs();
                }
            }
        });

        // setup thread2 to decrement the badCounter 200 times
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    badCounter.decrement();
                    DemoThreadUnsafe.sleepRandomlyForLessThan10Secs();
                }
            }
        });

//        for(int i = 0; i < 10; i++) {
//
//        }
        // run both threads
        thread1.start();
        thread2.start();

        // wait for t1 and t2 to complete.
        thread1.join();
        thread2.join();

        // print final value of counter
        badCounter.printFinalCounterValue();

        // If we call run() from thread, then it will be executed as a normal object without context switching to new thread
        thread1.run();
        thread2.run();

        thread1.join();
        thread2.join();

        Object obj = new Object();
        obj.wait();

        badCounter.printFinalCounterValue();

//        BlockingQueue bq = new ArrayBlockingQueue();

    }

    public static void sleepRandomlyForLessThan10Secs() {

        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException ie) {
            //
        }
    }
}

class ThreadUnsafeCounter {

    private int count = 0;

    public  void increment() {
        count++;
    }

    public  void decrement() {
        count--;
    }

    void printFinalCounterValue() {
        System.out.println("counter is: " + count);
    }
}



