package com.alg.designs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

/**
 * Implement a thread safe bounded blocking queue that has the following methods:
 *
 * BoundedBlockingQueue(int capacity) The constructor initializes the queue with a maximum capacity.
 * void enqueue(int element) Adds an element to the front of the queue. If the queue is full, the calling thread is
 * blocked until the queue is no longer full.
 * int dequeue() Returns the element at the rear of the queue and removes it. If the queue is empty, the calling thread
 * is blocked until the queue is no longer empty.
 * int size() Returns the number of elements currently in the queue.
 * Your implementation will be tested using multiple threads at the same time. Each thread will either be a producer
 * thread that only makes calls to the enqueue method or a consumer thread that only makes calls to the dequeue method. The size method will be called after every test case.
 *
 * Please do not use built-in implementations of bounded blocking queue as this will not be accepted in an interview.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * 1
 * 1
 * ["BoundedBlockingQueue","enqueue","dequeue","dequeue","enqueue","enqueue","enqueue","enqueue","dequeue"]
 * [[2],[1],[],[],[0],[2],[3],[4],[]]
 *
 * Output:
 * [1,0,2,2]
 *
 * Explanation:
 * Number of producer threads = 1
 * Number of consumer threads = 1
 *
 * BoundedBlockingQueue queue = new BoundedBlockingQueue(2);   // initialize the queue with capacity = 2.
 *
 * queue.enqueue(1);   // The producer thread enqueues 1 to the queue.
 * queue.dequeue();    // The consumer thread calls dequeue and returns 1 from the queue.
 * queue.dequeue();    // Since the queue is empty, the consumer thread is blocked.
 * queue.enqueue(0);   // The producer thread enqueues 0 to the queue. The consumer thread is unblocked and returns 0 from the queue.
 * queue.enqueue(2);   // The producer thread enqueues 2 to the queue.
 * queue.enqueue(3);   // The producer thread enqueues 3 to the queue.
 * queue.enqueue(4);   // The producer thread is blocked because the queue's capacity (2) is reached.
 * queue.dequeue();    // The consumer thread returns 2 from the queue. The producer thread is unblocked and enqueues 4 to the queue.
 * queue.size();       // 2 elements remaining in the queue. size() is always called at the end of each test case.
 *
 *
 * Example 2:
 *
 * Input:
 * 3
 * 4
 * ["BoundedBlockingQueue","enqueue","enqueue","enqueue","dequeue","dequeue","dequeue","enqueue"]
 * [[3],[1],[0],[2],[],[],[],[3]]
 *
 * Output:
 * [1,0,2,1]
 *
 * Explanation:
 * Number of producer threads = 3
 * Number of consumer threads = 4
 *
 * BoundedBlockingQueue queue = new BoundedBlockingQueue(3);   // initialize the queue with capacity = 3.
 *
 * queue.enqueue(1);   // Producer thread P1 enqueues 1 to the queue.
 * queue.enqueue(0);   // Producer thread P2 enqueues 0 to the queue.
 * queue.enqueue(2);   // Producer thread P3 enqueues 2 to the queue.
 * queue.dequeue();    // Consumer thread C1 calls dequeue.
 * queue.dequeue();    // Consumer thread C2 calls dequeue.
 * queue.dequeue();    // Consumer thread C3 calls dequeue.
 * queue.enqueue(3);   // One of the producer threads enqueues 3 to the queue.
 * queue.size();       // 1 element remaining in the queue.
 *
 * Since the number of threads for producer/consumer is greater than 1, we do not know how the threads will be scheduled
 * in the operating system, even though the input seems to imply the ordering. Therefore, any of the output [1,0,2] or [1,2,0] or [0,1,2] or [0,2,1] or [2,0,1] or [2,1,0] will be accepted.
 */
public class BoundedBlockingQueue {
    private Semaphore enq;

    private Semaphore deq;

    ConcurrentLinkedQueue<Integer> q;

    public BoundedBlockingQueue(int capacity) {
        q =  new ConcurrentLinkedQueue<>();
        enq = new Semaphore(capacity);
        deq = new Semaphore(0);
        System.out.println("Construct - enq permits:" + enq.availablePermits() + " deq permits: " + deq.availablePermits());
    }
    /**
     * WARNING: The requirement is asking us to DEQUEUE it later when queue got pushed in some elements, when multiple
     * dequeue() got called when size reached 0. Once we enqueue() it later, those dequeue() call threads who got
     * blocked earlier will dequeue them immediately.
     * @param element
     * @throws InterruptedException
     */
    public void enqueue(int element) throws InterruptedException {
        enq.acquire();
        q.add(element);
        deq.release();
        System.out.println("Enqueue - enq permits:" + enq.availablePermits() + " deq permits: " + deq.availablePermits());
    }

    /**
     * WARNING: The requirement is asking us to DEQUEUE it later when queue got pushed in some elements
     * @return
     * @throws InterruptedException
     */
    public int dequeue() throws InterruptedException {
        deq.acquire();
        int val = q.poll();
        enq.release();
        System.out.println("Dequeue - enq permits:" + enq.availablePermits() + " deq permits: " + deq.availablePermits());
        return val;
    }

    public int size() {
        return q.size();
    }

    public static void main(String[] args) {
        BoundedBlockingQueue queue = new BoundedBlockingQueue(2);
        List<Runnable> listOfActions = new ArrayList<>();
        listOfActions.add(new EnqueueTask(queue, 1));
        listOfActions.add(new EnqueueTask(queue, 2));
        listOfActions.add(new EnqueueTask(queue, 3));
        listOfActions.add(new EnqueueTask(queue, 4));
        listOfActions.add(new EnqueueTask(queue, 5));
        listOfActions.add(new DequeueTask(queue));
        listOfActions.add(new DequeueTask(queue));
        listOfActions.add(new DequeueTask(queue));
        listOfActions.add(new DequeueTask(queue));
        listOfActions.add(new DequeueTask(queue));
        listOfActions.add(new DequeueTask(queue));
        for(int i = 0; i<listOfActions.size(); i++) {
            Thread t = new Thread(listOfActions.get(i));
            t.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        queue.deq.drainPermits();
//        queue.enq.drainPermits();
        System.exit(0);

    }


}

class EnqueueTask implements Runnable{
    private int param;
    private BoundedBlockingQueue q;
    public EnqueueTask (BoundedBlockingQueue q, int param){
        this.param = param;
        this.q = q;
    }
    @Override
    public void run() {
        try {
            q.enqueue(param);
            System.out.println("Enqueue action executed. param: " + param + " size:" + q.size()+ " time:" + (System.currentTimeMillis()/1000) % 60 + "." + (System.currentTimeMillis()%1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class DequeueTask implements Runnable{
    private BoundedBlockingQueue q;
    public DequeueTask (BoundedBlockingQueue q){
        this.q = q;
    }
    @Override
    public void run() {
        try {
            q.dequeue();
            System.out.println("Dequeue action executed.         " + " size:" + q.size() + " time:" + (System.currentTimeMillis()/ 1000) % 60+ "." + (System.currentTimeMillis()%1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
