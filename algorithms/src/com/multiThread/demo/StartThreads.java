package com.multiThread.demo;

import java.util.List;
import java.util.function.Predicate;

public class StartThreads {

    public static void main(String[] args) {
//        List list = () -> {};
        Predicate predicate = (a) -> {
            return false;
        };
        Runnable runnable = ()-> {
            System.out.println();
        };
        Thread t1 = new Thread(runnable);

        Thread t2 = new Thread(() -> System.out.println());

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println();
            }
        });

        Thread t4 = new Thread () {
            public void doSomething () {
                // ... your code here
                System.out.println();
            }
        };

        Thread t5 = new Thread(null, () -> System.out.println(), "String name");
    }
}
