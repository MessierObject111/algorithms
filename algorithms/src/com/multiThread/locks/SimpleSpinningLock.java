package com.multiThread.locks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class SimpleSpinningLock {

    /**
     * 持有锁的线程，null表示锁未被线程持有
     */
    private AtomicReference<Thread> ref = new AtomicReference<>();

    public void lock(){
        Thread currentThread = Thread.currentThread();
        while(!ref.compareAndSet(null, currentThread)){
            //当ref为null的时候compareAndSet返回true，反之为false
            //通过循环不断的自旋判断锁是否被其他线程持有
        }
    }

    public void unLock() {
        Thread cur = Thread.currentThread();
        if(ref.get() != cur){
            //exception ...
        }
        ref.set(null);
    }

    static int count  = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CountDownLatch countDownLatch = new CountDownLatch(100);
        SimpleSpinningLock simpleSpinningLock = new SimpleSpinningLock();
        for (int i = 0 ; i < 100 ; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    simpleSpinningLock.lock();
                    ++count;
                    simpleSpinningLock.unLock();
                    countDownLatch.countDown();
                }
            });

        }
        countDownLatch.await();
        System.out.println(count);
    }

//    作者：深夜里的程序猿
//    链接：https://juejin.cn/post/6844903838349000717
//    来源：掘金
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}