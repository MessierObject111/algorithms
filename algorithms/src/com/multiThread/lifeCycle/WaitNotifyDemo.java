package com.multiThread.lifeCycle;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WaitNotifyDemo extends Object {

    private List syncList;

    public WaitNotifyDemo() {
        // create a new synchronized list to be used
        syncList = Collections.synchronizedList(new LinkedList());
    }

    // method used to remove an element from the list
    public String removeElement() throws InterruptedException {
        synchronized (syncList) {

            // while the list is empty, wait
            while (syncList.isEmpty()) {
                System.out.println("List is empty...");
                syncList.wait();
                System.out.println("Waiting...");
            }
            String element = (String) syncList.remove(0);

            return element;
        }
    }

    // method to add an element in the list
    public void addElement(String element) {
        System.out.println("Opening...");
        synchronized (syncList) {

            // add an element and notify all that an element exists
            syncList.add(element);
            System.out.println("New Element:'" + element + "'");

            syncList.notifyAll();
            System.out.println("notifyAll called!");
        }
        System.out.println("Closing...");
    }

    public static void main(String[] args) {
        final WaitNotifyDemo demo = new WaitNotifyDemo();

        Runnable removeElementTask = new Runnable() {

            public void run() {
                try {
                    String item = demo.removeElement();
                    System.out.println("removed " + item);
                } catch (InterruptedException ix) {
                    System.out.println("Interrupted Exception!");
                } catch (Exception x) {
                    System.out.println("Exception thrown.");
                }
            }
        };

        Runnable addElementTask = new Runnable() {

            // run adds an element in the list and starts the loop
            public void run() {
                demo.addElement("Hello!");
            }
        };

        try {
            Thread threadA1 = new Thread(removeElementTask, "removeElementThread1");
            threadA1.start();

            Thread.sleep(3000);

//            Thread threadA2 = new Thread(removeElementTask, "removeElementThread2");
//            threadA2.start();
//
//            Thread.sleep(3000);

            Thread threadB = new Thread(addElementTask, "addElementThread");
            threadB.start();

            Thread.sleep(5000);

//            threadA1.interrupt();
//            threadA2.interrupt();
        } catch (InterruptedException x) {
        }
    }
}