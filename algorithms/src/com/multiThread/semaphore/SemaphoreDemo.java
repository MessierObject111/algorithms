package com.multiThread.semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            Guest guest = new Guest();
            Thread run = new Thread(guest);
            run.start();
        }
    }
}

