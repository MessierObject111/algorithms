package com.alg.other;

import javax.swing.text.html.HTMLDocument;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        double u = 3.5, v = 0.1;
        System.out.println(u/v);

//        int x = 5, y = 0;
//        System.out.println(x/y);

        BigDecimal commission = new BigDecimal(16373740.88);
        System.out.println(commission.toPlainString());
//        Double commission = 16373740.88;
//        System.out.println(Double.valueOf(commission));

//        String a = "FB";
//        String b = "Ea";
//
//        String a2 = "ZB";
//        String b2 = "Ya";
//
//        System.out.println(a.hashCode() == b.hashCode());  // True or False
//        System.out.println(a2.hashCode() == b2.hashCode());  // True or False
//
//        System.out.println(a2.hashCode());
//        System.out.println(b.hashCode());

//        String a = new String("Allen");
//        String b = new String("Allen");
//        String c = "Allen";
//        System.out.println(a == b);  // True or False
//        System.out.println(a.equals(b));  // True or False
//        System.out.println(a.hashCode() == b.hashCode());  // True or False
//        System.out.println(a.hashCode() == c.hashCode());  // True or False
//
////        List list = new ArrayList();
//        List list = Collections.synchronizedList(new ArrayList());
//
//        Map treemap = new TreeMap();
//        treemap.put("One", "1");
//        treemap.put("Two", "2");
//        treemap.put("Three", "3");
//
//        Set entry = treemap.entrySet();
//        entry.forEach(key -> {
//            System.out.println(key);
//        });
//
//        for (Object key:treemap.keySet()) {
//            System.out.println(key);
//        }
//
//        HashSet s = new HashSet<>();
        ConcurrentHashMap cm = new ConcurrentHashMap();
//        HashMap cm = new HashMap();
//        cm.put("Two", "2");
//        cm.put("One", "1");
//        System.out.println(cm.get("A"));
//        Collection hashSet =  cm.values();
//        hashSet.stream().forEach(e -> {
//            System.out.println(e);
//        });

        LinkedHashSet lhs = new LinkedHashSet();
        lhs.add("A");
        lhs.add("B");
        lhs.add("C");
        lhs.add("D");
        lhs.add("E");
        Iterator iterator = lhs.iterator();
        while(iterator.hasNext()) {
            String s = (String) iterator.next();
            System.out.println(s);
        }
    }

}
