package com.java8.functionalInterfaces.defaultMethod;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Runner {
    TestExecutor testExecutor = new TestExecutor();
    public ArrayList<String> process (ArrayList<String> list) {
        list = (ArrayList<String>) list.stream().map(testExecutor::sampleFunctionalMethod)
                .collect(Collectors.toList());
        return list;
    }
}