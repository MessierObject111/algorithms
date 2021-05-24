package com.java.se.inheritancePolymorphism.question1;

public class Mammal {
    void eat(Mammal m) { System.out.println("Mammal eats food"); }

    void call() {
        System.out.println("Animal call!");
    }

    void getName (String name) {
        System.out.println("Animal name: "+ name);
    }

    public Mammal() {
        System.out.println("Constructing Mammal");
    }

    public void mammalOnly () {
        System.out.println("This is Mammal class only method!");
    }
}
