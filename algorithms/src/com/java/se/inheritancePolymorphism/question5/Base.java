package com.java.se.inheritancePolymorphism.question5;

public class Base {
    public String name = "Base";

    public static void staticPrint () {
        System.out.println("This is static Base;");
    }

    public void print () {
        System.out.println("This is Base;");
    }

    public void callPrint () {
        staticPrint();
        print();
    }

    public String getName () {
        return this.name;
    }

    public Base() {
        System.out.println("Constructing Base...");
        print();
    }
}
