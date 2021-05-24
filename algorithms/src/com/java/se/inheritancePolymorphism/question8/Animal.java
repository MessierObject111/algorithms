package com.java.se.inheritancePolymorphism.question8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Animal {
    public List getNames () {
        List list = new ArrayList();
        list.add("Fish");
        list.add("Amphibian");
        list.add("Reptile");
        list.add("Bird");
        list.add("Mammal");
        return list;
    }

    public ArrayList getTemperatures() {
        ArrayList list = new ArrayList();
        list.add("Warm Blooded");
        list.add("Cold Blooded");
        return list;
    }

    public void printNames () throws Exception {
        List list = getNames();
        list.stream().forEach(name-> {
            System.out.println(name);
        });
    }

    public Animal() {
        try {
            printNames();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
