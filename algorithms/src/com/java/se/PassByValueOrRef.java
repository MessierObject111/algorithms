package com.java.se;

import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class PassByValueOrRef {
    public void alterPrimitiveValues(int i, long l, int[] d, char c) {
        i = i + 1;
        l = l + 1;
        d[0] = d[0] + 1;
        c = 'z';
        System.out.println("Primitives in method call stack:");
        System.out.println("int i = " + i);
        System.out.println("long l = " + l);
        System.out.print("int[] d[0] = "); System.out.println(d[0]);
        System.out.println("char c = " + c);
        System.out.println();
    }

    public void alterObjects (AtomicInteger ai, String s, AtomicInteger[] list, HashSet set) {
        System.out.println("String addr " + Integer.toHexString(s.hashCode()));
        ai.getAndAdd(1);
        s = s + "-altered";
        list[0].getAndAdd(1);
        set.add("altered");
        System.out.println("Objects method call stack:");
        System.out.println("AtomicInteger ai = " + ai);
        System.out.println("String s = " + s);
        System.out.println("String addr " + Integer.toHexString(s.hashCode()));
        System.out.println("AtomicInteger[0] array item = " + list[0].get());
        set.stream().forEach(i -> {
            System.out.println("HashSet set item = " + i);
        });
        System.out.println();
    }

    public static void main(String[] args) {
        int i = 0;
        long l = 100L;
        int[] d = new int[1];
        d[0] = 0;
        char c = 'c';

        AtomicInteger ai = new AtomicInteger(1);
        String s = "Hello world!";
        AtomicInteger[] list = new AtomicInteger[1];
        list[0] = new AtomicInteger(1);
        HashSet set = new HashSet();
        for (int j = 0; j < 5; j++) {
            final String uuid = UUID.randomUUID().toString();
            set.add(uuid);
        }

        PassByValueOrRef test = new PassByValueOrRef();
        test.alterPrimitiveValues(i, l, d, c);
        test.alterObjects(ai, s, list, set);

        System.out.println("Primitives in main caller:");
        System.out.println("int i = " + i);
        System.out.println("long l = " + l);
        System.out.print("int[] d[0] = "); System.out.println(d[0]);
        System.out.println("char c = " + c);
        System.out.println();

        System.out.println("Objects in main caller:");
        System.out.println("AtomicInteger ai = " + ai);
        System.out.println("String addr " + Integer.toHexString(s.hashCode()));
        System.out.println("String s = " + s);
        System.out.println("AtomicInteger[0] array item = " + list[0].get());
        set.stream().forEach(e -> {
            System.out.println("HashSet set item = " + e);
        });
    }
}
