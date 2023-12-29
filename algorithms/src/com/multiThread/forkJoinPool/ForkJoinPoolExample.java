package com.multiThread.forkJoinPool;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Sample data
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        ForkJoinPool pool = new ForkJoinPool(12);

        // Print the current pool size of the ForkJoinPool used by the parallel stream
        System.out.println("------ForkJoinPool local pool Test------");
        pool.submit(()->{
            Arrays.asList(numbers)
                    .parallelStream()
                    .forEach(e -> {
                        // Print the current pool size
                        long threadId = Thread.currentThread().getId();
                        System.out.println("Integer:"+ e +"; Current Pool Size: " + pool.getPoolSize() + " Thread # " + threadId );
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                    });
        }).get();

        //If we don't use local pool but to use the common pool,
        System.out.println("------ForkJoinPool.commonPool Test------");
        Arrays.asList(numbers)
                .parallelStream()
                .forEach(e -> {
                    // Print the current pool size
                    long threadId = Thread.currentThread().getId();
                    System.out.println("Integer:"+ e +"; Current Pool Size: " + ForkJoinPool.commonPool().getPoolSize() + " Thread # " + threadId );
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                });

//        System.out.println("Sum: " + currentPoolSize);
    }
}
