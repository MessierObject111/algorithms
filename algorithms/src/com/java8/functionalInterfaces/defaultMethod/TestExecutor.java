package com.java8.functionalInterfaces.defaultMethod;

import com.java8.functionalInterfaces.SampleFunctionalInterface;

public class TestExecutor implements SampleFunctionalInterface {
    @Override
    public String sampleFunctionalMethod(String s) {

        return s + " - processed;";
    }
}
