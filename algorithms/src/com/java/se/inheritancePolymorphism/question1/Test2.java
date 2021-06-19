package com.java.se.inheritancePolymorphism.question1;

public class Test2 {

    // Upcast and downcast
    public static void main(String[] args) {
        Mammal mammal = new Mammal();
        Horse horse = new Horse();

        mammal.mammalOnly();
        horse.horseOnly();

        System.out.println("---------Upcast----------");
        Mammal horseUpcast = (Mammal) horse;
        horseUpcast.mammalOnly();
//        horseUpcast.horseOnly(); //Compile Error
        horseUpcast.call();

        System.out.println("---------Downcast----------");
        Mammal m = new Horse();

        if(m instanceof Horse) {
            Horse mammalDowncast = (Horse) m;
            mammalDowncast.horseOnly();
            mammalDowncast.mammalOnly();
            mammalDowncast.call();
        }

        //Compiler won't report error here but it will report error as soon as it runs at runtime
        try{
            Horse mammalDowncast_0 = (Horse) mammal;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }


    }
}
