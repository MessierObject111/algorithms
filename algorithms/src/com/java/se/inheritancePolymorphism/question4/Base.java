package com.java.se.inheritancePolymorphism.question4;

class Base {
    static int value = 0;
    Base() {
        addValue();
    }
    void addValue() {
        value += 10;
        System.out.println("Base add");
    }
    int getValue() { return value; }
}

class Derived extends Base {
    Derived() {
        addValue();
    }
    @Override
    void addValue() {
        value += 23;
        System.out.println("Derived add");
    }
}

class Test {
    public static void main(String[] args) {
        Base b = new Derived();
        System.out.println(b.getValue());

        int x= 3;
        m1(3);
    }
    static void m1(Long l) {
        System.out.println("long");

    }

    static void m1(Object l) {
        System.out.println("Object");

    }
}
