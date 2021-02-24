package com.multiThread.semaphore;

class Guest implements Runnable {

    @Override
    public void run() {
        Restaurant.eat();
    }
}
