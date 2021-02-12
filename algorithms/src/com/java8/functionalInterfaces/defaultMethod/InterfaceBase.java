package com.java8.functionalInterfaces.defaultMethod;
//@FunctionalInterface
public interface InterfaceBase {
    abstract void abstractMethod ();

    static String staticMethodA() {
        return "Hello";
    }

    static String staticMethodB() {
        return "Hello";
    }
}
