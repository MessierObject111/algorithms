package com.java.se.inheritancePolymorphism.question5;

public class TestFieldPolymorphism {

    public static void main(String[] args) {
        Base base =  new Base();
        Base ext = new Ext();

        System.out.println("--------------name--------------");
        System.out.println(base.name);
        System.out.println(ext.name);

        System.out.println("--------------staticPrint--------------");
        base.staticPrint();
        ext.staticPrint();

        System.out.println("--------------print--------------");
        base.print();
        ext.print();

        System.out.println("--------------callPrint--------------");
        base.callPrint();
        ext.callPrint();

        System.out.println("--------------callParentPrint--------------");
        ((Ext) ext).callParentPrint(); // Note here where I have to Case it to Ext to call the callParentPrint() method

        System.out.println("--------------callParent Name--------------");
        System.out.println(ext.getName()); // Base

    }
}
