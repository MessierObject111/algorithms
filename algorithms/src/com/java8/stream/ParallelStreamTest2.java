package com.java8.stream;

import java.util.stream.IntStream;

public class ParallelStreamTest2 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        IntStream.range(0,100_000_000)

                .map(x -> {
//                    try {
//                        com.google.common.io.Files.readLines(new File("asf"), Charset.defaultCharset());
//                    } catch (IOException e) {
//                        throw  new RuntimeException(e);
//                    }
                    return (int) Math.pow(x,3);
                }).count();
//                .reduce(0,(x,y) -> x+y);

        System.out.println("Without parallel(ms): " + (System.nanoTime() - startTime)/1_000_000);

        startTime = System.nanoTime();
        IntStream.range(0,100_000_000)
                .parallel()
                .map(x -> {
//                    try {
//                        com.google.common.io.Files.readLines(new File("asf"), Charset.defaultCharset());
//                    } catch (IOException e) {
//                        throw  new RuntimeException(e);
//                    }
                    return (int) Math.pow(x,3);
                }).count();
//                .reduce(0,(x,y) -> x+y);

        System.out.println("With parallel (ms): " + (System.nanoTime() - startTime)/1_000_000);
    }
}
