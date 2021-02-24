package com.multiThread.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ReleaseBeforeAcquireTest {
    Semaphore semaphore;
    AtomicInteger counter;

    public ReleaseBeforeAcquireTest(int capacity) {
        semaphore = new Semaphore(capacity);
        counter = new AtomicInteger();
    }

    public void acquireAction () throws InterruptedException {
        semaphore.acquire();
        Thread.sleep(1000);
        int count = counter.addAndGet(1);
        System.out.println("count: " + count + " permits after:" + semaphore.availablePermits());
    }

    public void releaseAction () throws InterruptedException {
        semaphore.release();
        int count = counter.decrementAndGet();
        System.out.println("count: " + count + " permits after:" + semaphore.availablePermits());
    }

    public static void main(String[] args) {
        ReleaseBeforeAcquireTest test = new ReleaseBeforeAcquireTest(2);

        List<Runnable> releaseActions = new ArrayList<>();
        releaseActions.add(new ReleaseTask(test));
        releaseActions.add(new ReleaseTask(test));
        releaseActions.add(new ReleaseTask(test));
        releaseActions.add(new ReleaseTask(test));
        releaseActions.add(new ReleaseTask(test));

        List<Runnable> acquireActions = new ArrayList<>();
        acquireActions.add(new AcquireTask(test));
        acquireActions.add(new AcquireTask(test));
        acquireActions.add(new AcquireTask(test));
        acquireActions.add(new AcquireTask(test));
        acquireActions.add(new AcquireTask(test));

        for(int i = 0; i<releaseActions.size(); i++) {
            Thread t = new Thread(releaseActions.get(i));
            t.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = 0; i<acquireActions.size(); i++) {
            Thread t = new Thread(acquireActions.get(i));
            t.start();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}
class AcquireTask implements Runnable{
    private ReleaseBeforeAcquireTest test;
    public AcquireTask (ReleaseBeforeAcquireTest t){
        this.test = t;
    }
    @Override
    public void run() {
        try {
            test.acquireAction();
            System.out.println("Acquire action executed. " +"time:" + (System.currentTimeMillis()/1000) % 60 + "." + (System.currentTimeMillis()%1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ReleaseTask implements Runnable{
    private ReleaseBeforeAcquireTest test;
    public ReleaseTask (ReleaseBeforeAcquireTest t){
        this.test = t;
    }
    @Override
    public void run() {
        try {
            test.releaseAction();
            System.out.println("Release action executed. " +"time:" + (System.currentTimeMillis()/1000) % 60 + "." + (System.currentTimeMillis()%1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}