package com.multiThread.locks.lockTest1;

public class ConcurrentAlphabetPrinter implements Runnable {
    // This object is used as mutex, a shared monitor object, between diff threads;
    // Only one thread can have the object's monitor at one time. With synchronized block placed on mutex, the thread who
    // enters the code block will acquire the mutex's monitor, or wait, until another thread who finished running to
    // notify it.
    private Object mutex = new Object();

    // The flag here is used for the code to tell which thread it is. true means the thread who prints upper case, false
    // means the thread who prints lower case. Of course, we can use different ways to mark different thread. If we use
    // array of numbers to mark threads, e.g. {1, 2, 3}, then we need to write switch conditions in run() method. This
    // value need to be injected through constructor during object instantiation for runnable.
    private final boolean isUpperCase;

    // Why static? Because the threads can share static/class-level values, not object level values. Each printer obj
    // instance will have it own char value if not using static here, thus we cannot track their overall progress; each
    // thread will print their own set of alphabets, rather than taking turns like t1: a, t2: b, t1: c, t2: d .. etc
    private static char c = 'a';

    public ConcurrentAlphabetPrinter (Object obj, boolean flag) {
        this.mutex = obj;
        this.isUpperCase = flag;
    }

    @Override
    public void run() {
        while (c < 'z'){
            if(isUpperCase) {
                synchronized(mutex) {
                    System.out.println(Thread.currentThread()+ ": " + Character.toUpperCase(c));
                    c++;
                    try {
                        mutex.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(mutex) {
                    System.out.println(Thread.currentThread()+ ": " + c);
                    c++;
                    mutex.notify();
                }

            }
        }
    }


}
