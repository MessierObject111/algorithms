package com.multiThread;

import java.util.Date;

public class CreateTaskDemo {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        SampleTask sampleTask = new SampleTask();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    sampleTask.runSomething();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(runnable).start();
        }


        Thread thread1 = new Thread () {
            public void run () {
                // ... your code here
                try {
                    calculateSomething("A");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread2 = new Thread () {
            public void run () {
                // ... your code here
                try {
                    calculateSomething("B");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread1.start();
        thread2.start();

        long endTime = System.currentTimeMillis();
        System.out.println("Execution time:" + (endTime - startTime));
    }

    private static void calculateSomething (String str) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Task "+ str +" completed.");
    }
}
