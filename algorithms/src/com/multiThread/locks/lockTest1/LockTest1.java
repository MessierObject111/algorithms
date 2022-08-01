package com.multiThread.locks.lockTest1;

public class LockTest1 {

    public static void main(String[] args) {
        Object mutex = new Object();
        ConcurrentAlphabetPrinter printer_1 = new ConcurrentAlphabetPrinter(mutex, true);
        ConcurrentAlphabetPrinter printer_2 = new ConcurrentAlphabetPrinter(mutex, false);

        // Direct run() doesn't really create 2 new threads; it will lead main thread to execute the code in runnable.
//        printer_1.run();
//        printer_2.run();

        // To make 2 new threads to execute, use Thread
        Thread t1 = new Thread(printer_1);
        Thread t2 = new Thread(printer_2);

        t1.start();
        t2.start();

    }

}
