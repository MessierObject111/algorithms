package com.multiThread.locks;

import com.java8.stream.SamplePerson;
import com.java8.stream.SampleWorker;
import com.java8.stream.Sex;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class MockDbCache {
    private static ArrayList<SampleWorker> list;
    private static final ReentrantLock flag;

    static {
        list = new ArrayList();
        list.add(new SampleWorker("Adam", 19, Sex.MALE));
        list.add(new SampleWorker("Beatrice", 43, Sex.FEMALE));
        list.add(new SampleWorker("Charlie", 15, Sex.MALE));
        list.add(new SampleWorker("Olivia", 54, Sex.FEMALE));
        list.add(new SampleWorker("Emma", 38, Sex.FEMALE));
        list.add(new SampleWorker("Derek", 9, Sex.MALE));
        list.add(new SampleWorker("Sophia", 84, Sex.FEMALE));

        flag = new ReentrantLock();
    }

    public List read(int criteria) {

        while(flag.isLocked()) {
            System.out.println("flag is locked, sleep for 1 second");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("read successful");
        return list.stream().filter((p)->{
            return p.getAge() > criteria;
        }).collect(Collectors.toList());
    }

    public void write (SampleWorker woker) {
        flag.lock();
        System.out.println("Cache locked;");
        list.add(woker);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("transaction committed.");
        flag.unlock();
        System.out.println("Cache unlocked;");
    }

    public static void main(String[] args) {
        MockDbCache cache = new MockDbCache();

        Runnable writeTask = ()-> {
            System.out.println("Starting to write to Cache");
            SampleWorker worker = new SampleWorker("Alexa", 31, Sex.FEMALE);
            cache.write(worker);

        };

        Runnable readTask = () -> {
            System.out.println("Starting to read cache;");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<SampleWorker> result1 = cache.read(30);
            result1.stream().forEach((w->{
                System.out.println(w.getName());
            }));
        };

        Thread writeThread = new Thread(writeTask);
        Thread readThread = new Thread(readTask);

        writeThread.start();
//        try {
//            writeThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        readThread.start();
    }
}
