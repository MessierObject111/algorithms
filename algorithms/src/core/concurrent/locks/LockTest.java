package core.concurrent.locks;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Test class to test the lock example
// 5 threads are created with DisplayJob
// and 5 thread are created with ReadJob.
// Both these jobs use single TestResource named "test".
public class LockTest
{
    public static void main(String[] args)
    {
        TestResource test = new TestResource();
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 5; i++)
        {
            thread[i] = new Thread(new DisplayJob(test),
                    "Thread " + i);
        }
        for (int i = 5; i < 10; i++)
        {
            thread[i] = new Thread(new ReadJob(test),
                    "Thread " + i);
        }
        for (int i = 0; i < 10; i++)
        {
            thread[i].start();
        }
    }

}
