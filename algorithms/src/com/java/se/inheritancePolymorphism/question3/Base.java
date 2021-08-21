package com.java.se.inheritancePolymorphism.question3;

class Base {
    static int value = 0;
    Base() {
        addValue();
    }
    static void addValue() {
        value += 10;
        System.out.println("Base add");
    }
    int getValue() { return value; }
}

class Derived extends Base {
    Derived() {
        addValue();
    }
//    @Override
    static void addValue() {
        value += 23;
        System.out.println("Derived add");
    }
}

 class Test {
    public static void main(String[] args) {
        Base b = new Derived();
        System.out.println(b.getValue());
    }
}
