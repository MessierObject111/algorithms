package com.java8.functionalInterfaces.predicate;

import java.util.function.Predicate;

public class PredicateImplA implements Predicate<Integer> {
    @Override
    public boolean test(Integer n) {
        if(n%2 == 0) {
            return true;
        } else{
            return false;
        }
    }
}
