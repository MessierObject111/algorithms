package com.alg.list;

import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    public String name;
    public int time;
    public int amount;
    public String city;
    public int index;
    public Transaction (String line, int index){
        String[] parts = line.split(",");
        String name = parts[0];
        int time = Integer.valueOf(parts[1]);
        int amount = Integer.valueOf(parts[2]);
        String city = parts[3];
        this.name = name;
        this.time = time;
        this.amount = amount;
        this.city = city;
        this.index = index;
    }
}
//2021-02-18: For god's sake, I got stuck in the problem for hours, just because
//    Math.abs(t.time - transaction.time) < 60
// should be
//    Math.abs(t.time - transaction.time) <= 60
// The test cases were too long and leetcode refused to print all of the expected result. Damn.
public class InvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {
        Set<Integer> invalidSet = new HashSet<>();
        // Group by individuals, then order each individual's transations
        // by time, then go over them one by one checking amount and locations
        Map<String, Set<Transaction>> mapByName = new HashMap<>();

        for(int i = 0; i < transactions.length; i++) {
            Transaction transaction = new Transaction(transactions[i], i);
            String name = transaction.name;
            if(transaction.amount > 1000) {
                invalidSet.add(transaction.index);
            }
            if(mapByName.get(name) == null) {
                Set<Transaction> set = new HashSet();
                set.add(transaction);
                mapByName.put(name, set);
            } else {
                Set<Transaction> existingSet = mapByName.get(name);
                //Search and find invalid transactions among existing right now when adding new elements
                List<Transaction> invalids = existingSet.stream().filter(t -> {
                    return (!t.city.equals(transaction.city)) && (Math.abs(t.time - transaction.time) <= 60);
                }).collect(Collectors.toList());

                if(!invalids.isEmpty()) {
                    invalidSet.addAll(invalids.stream()
                            .map(t -> t.index)
                            .collect(Collectors.toList()));
                    invalidSet.add(transaction.index);
                }
                existingSet.add(transaction);
            }

        }

        List invalidList = invalidSet.stream().map(index -> {
            return transactions[index];
        }).collect(Collectors.toList());
        return invalidList;
    }

    public static void main(String[] args) {
        InvalidTransactions s = new InvalidTransactions();

        String[] transactions_1 = {"alice,20,800,mtv","alice,50,100,beijing"};
        List result_1 = s.invalidTransactions(transactions_1);
        result_1.stream().forEach(t -> {
            System.out.println(t);
        });

        String[] transactions_2 = {"alice,20,800,mtv","alice,50,100,beijing"};
        List result_2 = s.invalidTransactions(transactions_2);
        result_2.stream().forEach(t -> {
            System.out.println(t);
        });

        String[] transactions_3 = {"alex,600,260,bangkok","bob,656,1366,bangkok",
                "alex,393,616,bangkok","bob,820,990,amsterdam","alex,596,1390,amsterdam"};
        List result_3 = s.invalidTransactions(transactions_3);
        result_3.stream().forEach(t -> {
            System.out.println(t);
        });

//                "alex,393,616,bangkok",
//                "alex,596,1390,amsterdam",//
//                "alex,600,260,bangkok",//
//
//
//
//                "bob,656,1366,bangkok", //
//                "bob,820,990,amsterdam",
        String[] transactions_4 = {"bob,55,173,barcelona","lee,113,952,zurich","maybe,115,1973,madrid","chalicefy,229,283,istanbul","bob,24,874,shanghai","alex,568,412,tokyo","alex,242,1710,milan","iris,722,879,shenzhen","chalicefy,281,1586,warsaw","maybe,246,778,bangkok","xnova,605,166,newdelhi","iris,631,991,hongkong","chalicefy,500,620,tokyo","chalicefy,380,428,istanbul","iris,905,180,barcelona","alex,810,732,shenzhen","iris,689,389,paris","xnova,475,298,singapore","lee,58,709,amsterdam","xnova,717,546,guangzhou","maybe,78,435,shenzhen","maybe,333,145,hongkong","lee,405,1230,hongkong","lee,456,1440,tokyo","chalicefy,286,1071,amsterdam","alex,55,271,shanghai","bob,91,273,warsaw","iris,195,1825,tokyo","maybe,639,417,madrid","maybe,305,882,chicago","lee,443,47,chicago","chalicefy,958,840,budapest","lee,162,1239,budapest","bob,701,505,montreal","alex,52,1575,munich","bob,533,1407,amsterdam","lee,621,491,tokyo","chalicefy,866,622,rome","alex,925,455,hongkong","lee,968,164,moscow","chalicefy,31,1119,newdelhi","iris,527,700,warsaw","bob,286,1694,dubai","maybe,903,29,barcelona","maybe,474,1606,prague","maybe,851,648,beijing","lee,48,655,chicago",
                "maybe,378,25,toronto","lee,922,691,munich","maybe,411,903,taipei","lee,651,112,guangzhou","lee,664,506,dubai","chalicefy,704,924,milan","maybe,333,1264,budapest","chalicefy,587,1112,singapore","maybe,428,437,moscow","lee,721,366,newdelhi","iris,824,1962,beijing","chalicefy,834,489,istanbul","alex,639,1473,zurich","xnova,898,738,tokyo","chalicefy,585,1313,frankfurt","xnova,730,759,beijing","alex,69,892,montreal","lee,77,91,barcelona","lee,722,611,taipei","chalicefy,706,1982,jakarta","chalicefy,743,584,luxembourg","xnova,683,322,istanbul","chalicefy,60,861,prague","alex,366,871,shenzhen","chalicefy,77,870,shenzhen","iris,913,1501,warsaw","iris,846,1176,warsaw","bob,873,69,zurich","alex,601,181,chicago","chalicefy,118,145,hongkong","bob,879,982,montreal","lee,994,950,chicago","maybe,885,1900,shanghai","lee,717,1447,shanghai","chalicefy,71,434,istanbul","bob,870,968,toronto","maybe,718,51,beijing","alex,669,896,istanbul","chalicefy,639,506,rome","alex,594,934,frankfurt","maybe,3,89,jakarta","xnova,328,1710,rome","alex,611,571,chicago","chalicefy,31,458,montreal","iris,973,696,toronto","iris,863,148,rome","chalicefy,926,511,warsaw","alex,218,1411,zurich","chalicefy,544,1296,shenzhen","iris,27,23,montreal","chalicefy,295,263,prague","maybe,575,31,munich","alex,215,174,prague"};
        List result_4 = s.invalidTransactions(transactions_4);
        result_4.stream().forEach(t -> {
            System.out.println(t);
        });

        String[] transactions_5 = {"chalicefy,31,1119,newdelhi","chalicefy,31,458,montreal","chalicefy,60,861,prague","chalicefy,71,434,istanbul","chalicefy,77,870,shenzhen","chalicefy,118,145,hongkong","chalicefy,229,283,istanbul ","chalicefy,281,1586,warsaw","chalicefy,286,1071,amsterdam","chalicefy,295,263,prague","chalicefy,380,428,istanbul","chalicefy,500,620,tokyo","chalicefy,544,1296,shenzhen","chalicefy,585,1313,frankfurt","chalicefy,587,1112,singapore ","chalicefy,639,506,rome","chalicefy,704,924,milan","chalicefy,706,1982,jakarta","chalicefy,743,584,luxembourg","chalicefy,834,489,istanbul","chalicefy,866,622,rome","chalicefy,926,511,warsaw","chalicefy,958,840,budapest"};
        List result_5 = s.invalidTransactions(transactions_5);
        // Looks like {name:chalicefy time:380 amount:428 city:istanbul} is the only valid one
        result_5.stream().forEach(t -> {
            System.out.println(t);
        });
    }
}
