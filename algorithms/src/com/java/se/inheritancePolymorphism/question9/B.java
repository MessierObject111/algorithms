package com.java.se.inheritancePolymorphism.question9;

// Can I make child class abstract while parent class concrete?
// Can I make abstract
public abstract class B extends A {
    private int a = 0;
    private int b = 1;

    public B(int a) {
        this.a = a;
    }

    public B(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public B() {
    }

    @Override
    public void talk () {
        System.out.println("This is B speaking.");
    }
}
