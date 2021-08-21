package com.java.se.inheritancePolymorphism.question2;

public class Test2 {
    public static void main(String[] args) {
        Base a = new Ext();
        a.staticHello();
        a.hello();

        staticPrintStr("Yo");
        printStr("Hello");
    }

    public static void staticPrintStr (String str) {
        System.out.println("Static Print String:" + str);
    }

    public static void printStr (String str) {
        System.out.println("Print String: " + str);
    }
}
