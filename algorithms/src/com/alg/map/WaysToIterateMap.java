package com.alg.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WaysToIterateMap {
    static Map map = new HashMap();

    public static void main(String[] args) {
        //Populating the map
        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");
        map.put("D", "4");
        map.put("E", "5");
        map.put("F", "6");
        map.put("G", "7");

        //Iterating over Map.entrySet()
        System.out.println("-------Print By EntrySet--------");
        Set<Map.Entry> entry = map.entrySet();
        entry.stream().forEach(e -> {
            System.out.println(e.getKey() + " - " + e.getValue());
        });

        //Iterating over keys and searching for values (inefficient)
        System.out.println("-------Print By KeySet--------");
        Set<String> keySet = map.keySet();
        keySet.stream().forEach(k->{
            System.out.println(k + "-" + map.get(k));
        });

        //Iterating using iterators over Map.Entry<K, V>
        System.out.println("-------Print By EntrySet iterator--------");
        Iterator<Map.Entry> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> en = iterator.next();
            System.out.println("Key = " + en.getKey() +
                    ", Value = " + en.getValue());
        }
        //Iterating using forEach()
        System.out.println("-------Print By forEach() + lambda expression--------");
        map.forEach((k, v)->{
            System.out.println(k + ": "+ v);
        });
    }
}
