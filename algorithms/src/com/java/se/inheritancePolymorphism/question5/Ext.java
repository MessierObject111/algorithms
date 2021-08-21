package com.java.se.inheritancePolymorphism.question5;

public class Ext extends Base {
    public String name = "Ext";

    public static void staticPrint () {
        System.out.println("This is static Ext;");
    }

    public void print () {
        System.out.println("This is Ext;");
    }

    public void callPrint () {
        staticPrint();
        print();
    }

    /*
    As mentioned earlier, in Java fields cannot be overridden in a subclass. If you define a field in a subclass with
    the same name as a field in the superclass, the field in the subclass will hide (shadow) the field in the
    superclass. If the subclass tries to access the field, it will access the field in the subclass.

    If, however, the subclass calls up into a method in the superclass, and that method accesses the field with the same
    name as in the subclass, it is the field in the superclass that is accessed.
     */
    public String getName () {
        //same as super.name;
        return super.getName();
    }

    public void callParentPrint () {
        super.callPrint();
    }

    public Ext() {
        System.out.println("Constructing Ext...");
        print();
    }
}