package com.multiThread.future;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class CallableTest {
    public static void main(String[] args) {
        //
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        AtomicLong counter = new AtomicLong(0);
        Callable callable1 = new Callable() {
            @Override
            public Long call() throws Exception {
                for(int i = 0; i < 1000_000; i++) {
                    counter.addAndGet(1);
                }
                System.out.println("[" + Thread.currentThread() + "] finished callable 1");
                return counter.get();
            }
        };

        Callable callable2 = () -> {
            for(int i = 0; i < 1000_000; i++) {
                counter.addAndGet(1);
            }
            System.out.println("[" + Thread.currentThread() + "] finished callable 2");
            return (Long) counter.get();
        };
        System.out.println("=====================Test 1===========================");

        Future<Long> future1 = threadPool.submit(callable1);// Will be executed by another thread
        Future<Long> future2 = threadPool.submit(callable2);// Will be executed by another thread

        // NOTE: Future will take the value at the moment when the tasks finishes, and
        // even that value gets updated later, it won't care. Thus in result, it may show
        // numbers other than 2000,000 for future1/future2, because one task may have been
        // executing

        // Both callables are sharing single counter with an AtomicLong

        //TODO: Why I am getting weird results that one of future1 / future2 will get number that is less than 2000,000?

        try {
            // Will be executed by main thread
            while(!(future1.isDone() && future2.isDone())) {
                Thread.sleep(100);
            }

            System.out.println("[" + Thread.currentThread() + "] future1: " + future1.get());
            System.out.println("[" + Thread.currentThread() + "] future2: " + future2.get());


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("=====================Test 2===========================");
        try {
            // If call() directly, main thread won't split sub threads, and will execute in
            // main thread instead.
            long count1 = (Long) callable1.call();
            long count2 = (Long) callable2.call();
            System.out.println(count1);
            System.out.println(count2);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("=====================Test 3===========================");
        FutureTask<Long> futureTask = new FutureTask<>(callable1);
        Thread t = new Thread(futureTask);
        t.start();
// …
        try {
            Long result = futureTask.get(); // will wait for the async completion
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        ThreadPoolExecutor threadPoolExecutor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.exit(0);
    }
}
