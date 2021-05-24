package com.multiThread.cacheLine;

public class Cacheline_NoPadding {
    public static class T{
        //8字节
//        public volatile long p1,p2,p3,p4,p5,p6,p7;
        private volatile long x = 0L;
    }
    private static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(()->{
            for(long i = 0;i < 1000_0000L;i++){
                //volatile的缓存一致性协议MESI或者锁总线，会消耗时间
                arr[0].x = i;
            }
        });

        Thread thread2 = new Thread(()->{
            for(long i = 0;i< 1000_0000L;i++){
                arr[1].x = i;
            }
        });
        long startTime = System.nanoTime();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Total Time Elapsed："+(System.nanoTime()-startTime)/100_000);
    }
//————————————————
//    版权声明：本文为CSDN博主「mofeizhi」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//    原文链接：https://blog.csdn.net/mofeizhi/article/details/106816026
}
