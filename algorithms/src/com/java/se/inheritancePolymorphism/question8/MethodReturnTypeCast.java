package com.java.se.inheritancePolymorphism.question8;

import java.io.IOException;
/*
So, if Base class has ArrayList methodA(); and Ext has List methodA(); .
Can methodA in Ext override the one in Base? How about if Base has List methodA() and Ext has ArrayList methodA()?

if Base has void method1() throws IOException, so which method1 implementation in Ext can override method1 in Base
1. void method1()
2. void method1() throws FileNotFoundException
3. void method1() throws Exception
4. void method1() throws IOException, ClassNotFoundException
5. void method1() throws RuntimeException
*/
public class MethodReturnTypeCast {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println("-------------");
        Animal mammal = new Mammal();


        System.out.println("-------Animal print------");
        try {
            animal.printNames();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("------Mammal print-------");
        try {
            mammal.printNames();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
