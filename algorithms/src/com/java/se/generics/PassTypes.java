package com.java.se.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PassTypes {

    public <E> boolean containsElement(E [] elements, E element){
        for (E e : elements){
            if(e.equals(element)){
                return true;
            }
        }
        return false;
    }

    public <K> int sum (K num1, K num2) {
//        K result = num1 + num2;
        return 121;
    }

    public void passTypeList (List<Object> list) {
        list.stream().forEach(e -> {
            System.out.println(e.toString());
        });
    }

    public <T> T genericCollection (Collection<T> c) {
        return (T) c.toArray()[0];
    }

    public static void main(String[] args) {
        PassTypes pt = new PassTypes();
//        List<String> list = new ArrayList();
        //why List<String> is not subtype of List<Object> but ArrayList<String> is subtype of List<String>?
        List list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");

        pt.passTypeList(list);

        String result = (String) pt.genericCollection(list); // A
        System.out.println(result);

        List<String> ls = new ArrayList<String> ();
//        List<Object> lo = ls; // boom
//        lo.add(new Object()); // boom
//        String s = ls.get(0); // boom boom


    }
}
