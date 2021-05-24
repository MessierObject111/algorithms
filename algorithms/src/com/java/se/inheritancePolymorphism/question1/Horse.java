package com.java.se.inheritancePolymorphism.question1;

public class Horse extends Cattle {
    void eat(Horse h) { System.out.println("Horse eats grass"); }

    void call() {
        System.out.println("Horse neigh!");
    }

    @Override
    void getName(String name) {
        System.out.println("Horse name: "+ name);
    }

    public Horse() {
        System.out.println("Constructing Horse");
    }

    public void horseOnly () {
        System.out.println("This is Horse class only method!");
    }
}
