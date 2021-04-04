package com.multiThread.demo;

public class ThreadLocalTest {
    public static void main(String[] args) {
        final ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {return 10;}
        };
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int x = local.get();
                System.out.println("x in t1: " + x);
                x++;
                local.set(x);
                System.out.println("x in t1: " + local.get());
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int x = local.get();
                System.out.println("x in t2: " + x);
                x = x + 10;
                local.set(x);
                System.out.println("x in t2: " + local.get());
            }
        });
        t1.start();
        try {
            Thread.sleep(100);
        } catch (Exception e) {}
        t2.start();
    }

}
