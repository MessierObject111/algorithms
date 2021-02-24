package com.multiThread.semaphore;

import java.util.concurrent.Semaphore;

class Restaurant {
    // 信号量为共享资源的属性
    private static Semaphore semp = new Semaphore(10); // 只容纳10个人就餐

    public static void eat() {
        try {
            semp.acquire();
            System.out.println(Thread.currentThread().getName()
                    + " is eating in restaurant");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("1 thread release");
            semp.release(); // 释放一个许可
        }
    }
}

