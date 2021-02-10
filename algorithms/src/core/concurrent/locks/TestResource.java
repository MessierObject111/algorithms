package core.concurrent.locks;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestResource {
    // displayQueueLock is created to make
    // displayQueueLock thread safe.
    // When T1 aquires lock on testresource(o1)
    // object displayRecord method
    // T2 has to wait for lock to be released
    // by T1 on testresource(o1) object
    // displayRecord method.  But T3, can execute
    // readRecord method with out waiting for lock
    // to be released by t1 as
    // readRecord method uses readQueueLock not
    // displayQueueLock.
    private final Lock displayQueueLock = new ReentrantLock();
    private final Lock readQueueLock = new ReentrantLock();

    // displayRecord uses displayQueueLock to
    // achieve thread safety.
    public void displayRecord(Object document) {
        final Lock displayLock = this.displayQueueLock;
        displayLock.lock();
        try
        {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().
                    getName() + ": TestResource: display a Job"+
                    " for a duration of " + (duration / 1000) + " seconds ::"+
                    " Time - " + new Date());
            Thread.sleep(duration);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.printf("%s: The document has been"+
                    " displayed\n", Thread.currentThread().getName());
            displayLock.unlock();
        }
    }

    // readRecord uses readQueueLock to achieve thread safety.
    public void readRecord(Object document) {
        final Lock readQueueLock = this.readQueueLock;
        readQueueLock.lock();
        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.println
                    (Thread.currentThread().getName()
                            + ": TestResource: reading a Job for a duration of " +
                            (duration / 1000) + " seconds :: Time - " +
                            new Date());
            Thread.sleep(duration);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("%s: The document has"+
                    " been read\n", Thread.currentThread().getName());
            readQueueLock.unlock();
        }
    }

}
