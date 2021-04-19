package com.multiThread.lifeCycle;

public class YieldTest extends Thread
{
    public void run()
    {
        for (int i=0; i<3 ; i++){
            System.out.println(Thread.currentThread().getName() + " in control");
        }
    }
    public static void main(String[]args)
    {
        YieldTest t1 = new YieldTest();
        YieldTest t2 = new YieldTest();

        do1(t1);

        do2(t1);

        // this will call run() method
        t1.start();
        t2.start();


        for (int i=0; i<3; i++)
        {
            System.out.println(Thread.currentThread().getName() + " in control");
        }

    }

    public synchronized static void do1 (Thread t) {
        try {
            t.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void do2 (Thread t) {
        t.notify();
    }
}
