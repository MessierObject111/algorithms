package com.java.se.inheritancePolymorphism.question8;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mammal extends Animal{
    // Trying overriding List with ArrayList
    public ArrayList getNames () {
        ArrayList list = new ArrayList();
        list.add("Mouse");
        list.add("Cat");
        list.add("Dog");
        list.add("Cow");
        list.add("Human");
        return list;
    }

    // Trying overriding ArrayList with List
//    public List getTemperatures() {
//        List list = new ArrayList();
//        list.add("Warm Blooded");
//        return list;
//    }

    //Overrides method in parent who throws IOException
    public void printNames () throws IOException {
        List list = getNames();
        list.stream().forEach(name-> {
            System.out.println(name);
        });
    }

    public Mammal() {
        try {
            printNames();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
