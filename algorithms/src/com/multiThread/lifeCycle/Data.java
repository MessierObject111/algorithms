package com.multiThread.lifeCycle;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Data {
    private String packet;

    // True if receiver should wait
    // False if sender should wait
    private boolean transfer = true;



    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }

        Lock lock = new ReentrantLock();

        lock.lock();
        Object o = new Object();
        try {
            o.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        transfer = true;

        String returnPacket = packet;
        notifyAll();
        return returnPacket;
    }

    public synchronized void send(String packet) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }
        transfer = false;

        this.packet = packet;
        notifyAll();
    }
}