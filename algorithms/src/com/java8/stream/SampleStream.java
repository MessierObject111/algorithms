package com.java8.stream;

public class SampleStream {

    public static void main(String[] args) {
        SampleWorker workerA = new SampleWorker("Alyx", 27, Sex.FEMALE);
        try {
            Class sampleWorkerClazz = Class.forName("com.java8.stream.SampleWorker");
            sampleWorkerClazz.getConstructors();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
