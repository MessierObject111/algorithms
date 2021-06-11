package com.multiThread;

public class SampleTask {
    public void runSomething () throws InterruptedException{
        Thread.sleep(1000);
        System.out.println("Task executed.");
    }
}
