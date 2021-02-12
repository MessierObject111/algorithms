package com.java8.stream.threadPools;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://dzone.com/articles/be-aware-of-forkjoinpoolcommonpool

public class CommonPoolTest {

    public static void main(String[] args) {

        System.out.println("CPU Core: " + Runtime.getRuntime().availableProcessors());

        System.out.println("CommonPool Parallelism: " + ForkJoinPool.commonPool().getParallelism());

        System.out.println("CommonPool Common Parallelism: " + ForkJoinPool.getCommonPoolParallelism());

        long start = System.nanoTime();

        // JDK 10 needed
//        List<CompletableFuture<Void>> futures = IntStream.range(0, 100)
//                .mapToObj(i -> CompletableFuture.runAsync(CommonPoolTest::blockingOperation))
//                .collect(Collectors.toUnmodifiableList());
//        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
//        System.out.println("Processed in " + Duration.ofNanos(System.nanoTime() - start).toSeconds() + " sec");

        // for range to 1000
        //CPU Core: 8
        //CommonPool Parallelism: 7
        //CommonPool Common Parallelism: 7
        //Processed in 143 sec

        // for range to 100
        //Processed in 15 sec
    }

    private static void blockingOperation() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


