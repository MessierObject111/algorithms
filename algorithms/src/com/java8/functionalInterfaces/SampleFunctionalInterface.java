package com.java8.functionalInterfaces;

@FunctionalInterface
public interface SampleFunctionalInterface {
    abstract String sampleFunctionalMethod (String s);

    static String staticMethodA() {
        return "Hello";
    }
}
