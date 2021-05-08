package com.java8.functionalInterfaces.defaultMethod;

import java.io.IOException;
import java.io.PrintWriter;

public interface MyFunctionalInterface {
    public void execute();

    public default void print(String text) {
        System.out.println(text);
    }

    public static void print(String text, PrintWriter writer) throws IOException {
        writer.write(text);
    }
}
