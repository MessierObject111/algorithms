package com.multiThread.locks;

import com.java.se.reflection.Person;
import com.java8.stream.ParallelStreamTest;

import java.util.Date;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphoreRestaurant = new Semaphore(5);

        Runnable customerTask = ()-> {
            try {
                semaphoreRestaurant.acquire();
                System.out.println(Thread.currentThread().getName() + " is using dinning space;");
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName() + " has finished dinning.");
                semaphoreRestaurant.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

        for(int i = 0; i < 20; i++) {
            Thread t = new Thread(customerTask);
            t.start();
        }

    }
}
