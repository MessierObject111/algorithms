package com.java.se.inheritancePolymorphism.question1;

public class Cattle extends Mammal {
    void eat(Cattle c) { System.out.println("Cattle eats hay"); }

    void call() {
        System.out.println("Cattle moo!");
    }

    @Override
    void getName (String name) {
        System.out.println("Cattle name: "+ name);
    }

    public Cattle() {
        System.out.println("Constructing Cattle");
    }

    public void cattleOnly () {
        System.out.println("This is Cattle class only method!");
    }
}
