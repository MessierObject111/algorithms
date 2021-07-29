package com.alg.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsList {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        System.out.println(arrayList.getClass());
        List<Integer> list = Arrays.asList(1, 2);
        System.out.println(list);
        System.out.println(list.getClass());
        System.out.println(list.contains(1));
        System.out.println(list.contains(3));

        //UnsupportedOperationException: Note here that the list returned from Arrays.asList()
        list.add(3);
        System.out.println(list.contains(3));
    }
}
