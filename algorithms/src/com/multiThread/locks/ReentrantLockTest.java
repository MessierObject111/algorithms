package com.multiThread.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void taskWaitingLock () {
        System.out.println("Is lock locked?" + reentrantLock.isLocked());
        while(reentrantLock.isLocked()) {
            try {
                Thread.sleep(1000);
                System.out.println("Waiting for lock... ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Task executed! ");
    }

    public static void main(String[] args) {


        Runnable lockAndUnlockTask = () -> {
            for(int i = 0; i < 5; i++) {
                try {
                    reentrantLock.lock();
                    System.out.println(Thread.currentThread().getName() + " locks, hold count: "
                            + reentrantLock.getHoldCount() + " reentrantLock is locked:" + reentrantLock.isLocked());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for(int i = 0; i < 5; i++) {
                try {
                    reentrantLock.unlock();
                    System.out.println(Thread.currentThread().getName() + " unlocks, hold count: "
                            + reentrantLock.getHoldCount() + " reentrantLock is locked:" + reentrantLock.isLocked());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };

        Runnable lockWaiterTask = () -> {
            taskWaitingLock();
        };

        Runnable lockTask = ()->{
            for(int i = 0; i < 5; i++) {
                reentrantLock.lock();
                System.out.println(Thread.currentThread().getName() + " locks, hold count: " + reentrantLock.getHoldCount());
            }
        };

        Runnable unlockTask = () -> {
            for(int i = 0; i < 5; i++) {
                reentrantLock.unlock();
                System.out.println(Thread.currentThread().getName() + " unlocks, hold count: "+ reentrantLock.getHoldCount());
            }
        };

        Thread lockKeeper = new Thread(lockAndUnlockTask);
        Thread lockWaiter = new Thread(lockWaiterTask);
        lockKeeper.start();
        try {
            Thread.sleep(1000);
            lockWaiter.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            lockKeeper.join();
            lockWaiter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread B = new Thread(lockTask);
        Thread C = new Thread(unlockTask);

        try {
            B.start();
            Thread.sleep(3000);
            C.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IllegalMonitorStateException e) {
            e.printStackTrace();
            System.out.println("Ouch! IllegalMonitorStateException is thrown because different thread attempts to unlock");
        }

//        Thread sameThread =

    }
}
