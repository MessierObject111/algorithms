package com.multiThread.executor;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class MyRunnable implements Runnable {
    String taskName;
    public MyRunnable (String taskName){
        this.taskName = taskName;
    }
    @Override
    public void run() {
        Random random = new Random();
        int time = random.nextInt(5000);
        System.out.println("This is task " + taskName + " running...");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + taskName + " finished running after "+ time);
    }
}
public class ExecutorServiceTest {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 100; i++) {
            MyRunnable task = new MyRunnable("#" + i);
            threadPool.submit(task);
        }
        threadPool.shutdown();
    }
}
