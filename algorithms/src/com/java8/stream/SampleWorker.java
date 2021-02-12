package com.java8.stream;

public class SampleWorker extends SamplePerson {
    private double salary;

    public SampleWorker(String name, int age, Sex sex) {
        super(name, age, sex);
    }


    @Override
    public String toString() {
        return "SampleWorker{" +
                "salary=" + salary +
                '}';
    }

    @Override
    public String greet() {
        return null;
    }
}
