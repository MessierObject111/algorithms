package com.java8.functionalInterfaces.defaultMethod;

import java.util.ArrayList;
import java.util.HashMap;

public class TestRun {
    static Runner runner = new Runner();

    public static void main(String[] args) {
        TestExecutor te = new TestExecutor();
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");

        list = runner.process(list);

        list.stream().forEach((s) -> System.out.println(s));

        Thread t = new Thread (()->{
            System.out.println(Thread.currentThread().getName());
        });

        HashMap map = new HashMap();
    }

}
