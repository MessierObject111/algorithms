package com.java.se.inheritancePolymorphism.question7;

public class NestedClassTest1 {
    public static void main(String[] args) {
        Hen hen = new Hen();
        System.out.println("--------------------------------");
        MeatHen meatHen = new MeatHen();
        System.out.println("--------------------------------");

        // Creating egg from Hen class
        Hen.Egg egg_1 = hen.new Egg();
        System.out.println("--------------------------------");
        Hen.Egg egg_2 = hen.new Egg();
        // Creating egg from MeatHen class, even MeatHen is subclass of Hen and do not have this Egg inner class defined
        System.out.println("--------------------------------");
        Hen.Egg egg_3 =  meatHen.new Egg();

        System.out.println(hen.getTemperature());
        System.out.println(egg_1.getTemperature());

        hen.call();
        egg_1.call();

    }
}
