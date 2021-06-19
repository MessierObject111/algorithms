package com.java.se.inheritancePolymorphism.question1;

import java.util.HashMap;

public class Test1 {
    // Test method Overloading in class inheritance
    public static void main(String[] args) {
        Mammal mammal = new Horse();
        System.out.println("---------Mammal - Horse initialized;---------");
        Cattle cattle = new Horse();
        System.out.println("---------Cattle - Horse initialized;---------");
        Horse horse = new Horse();
        System.out.println("---------Horse - Horse initialized;----------");

        System.out.println(mammal.getClass());
        System.out.println(cattle.getClass());
        System.out.println(horse.getClass());

        System.out.println("---------This is method overriding-------------");
        mammal.call();
        cattle.call();
        horse.call();

        System.out.println("--------This is also method overriding---------");
        mammal.getName("Frosty");
        cattle.getName("Molly");
        horse.getName("Blacky");

        System.out.println("---------This is method overloading------------");
        mammal.eat(mammal);
        mammal.eat(cattle);
        mammal.eat(horse);

        cattle.eat(mammal);
        cattle.eat(cattle);
        cattle.eat(horse);

        horse.eat(mammal);
        horse.eat(cattle);
        horse.eat(horse);

        System.out.println("---------This is method overloading------------");
        Cattle c2 = new Cattle();
        Horse h2 = (Horse) c2;

        Mammal h3 = (Horse) method1();

    }

    private static Cattle method1 (){
        return new Horse();
    }
}
