package com.multiThread.locks;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        Runnable reduceLatchTask = ()-> {
            try {
                for(int i = 0; i < 5; i++) {
                    countDownLatch.countDown();
                    System.out.println("Latch reduced: remaining: " + countDownLatch.getCount());
                    Thread.sleep(2000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable latchOpenTask = ()-> {
            try {
                countDownLatch.await();
                System.out.println("Opening Latch...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Latch opened! Tasks in here can continue");
        };

        Thread t1 = new Thread(reduceLatchTask);
        Thread t2 = new Thread(latchOpenTask);
        t1.start();
        t2.start();
    }
}
