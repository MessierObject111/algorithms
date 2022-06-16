package com.companies.amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SortJunctionBoxes {
    public List<String> sortJunctionBoxes(List<String> junctionBoxNameVersion){
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                int index1 = o1.indexOf(" ");
                String o1version = o1.substring(index1);
                String o1name = o1.split(" ")[0];

                int index2 = o2.indexOf(" ");
                String o2version = o2.substring(index2);
                String o2name = o2.split(" ")[0];

                return o1version.compareTo(o2version) == 0 ? o1name.compareTo(o2name): o1version.compareTo(o2version);
            }
        });

        //New way of implementing a PriorityQueue with Lambda
        PriorityQueue<String> sortCustomString = new PriorityQueue<>((o1, o2)->{
            int index1 = o1.indexOf(" ");
            String o1version = o1.substring(index1);
            String o1name = o1.split(" ")[0];

            int index2 = o2.indexOf(" ");
            String o2version = o2.substring(index2);
            String o2name = o2.split(" ")[0];

            return o1version.compareTo(o2version) == 0 ? o1name.compareTo(o2name): o1version.compareTo(o2version);
        });

        for(String nameVersion : junctionBoxNameVersion) {
            queue.add(nameVersion);
        }
        List<String> sortedList = new ArrayList<>();
        while(!queue.isEmpty()) {
            sortedList.add(queue.poll());
        }
        return sortedList;
    }

    private void printCompareResult(String o1, String o2) {
        int index1 = o1.indexOf(" ");
        String o1version = o1.substring(index1);
        String o1name = o1.split(" ")[0];

        int index2 = o2.indexOf(" ");
        String o2version = o2.substring(index2);
        String o2name = o2.split(" ")[0];
        System.out.println(o1version + " vs " + o2version + ": " +o1version.compareTo(o2version));
        System.out.println(o1name+ " vs " + o2name+ ": " + o1name.compareTo(o2name));
    }

    public static void main(String[] args) {
        List<String> junctionBoxes = new ArrayList<>();
        junctionBoxes.add("JunctionBox232 alpha DB2");
        junctionBoxes.add("JunctionBox830 beta M");
        junctionBoxes.add("JunctionBox174 alpha V");
        junctionBoxes.add("JunctionBox565 charlie");
        junctionBoxes.add("JunctionBox069 beta M");
        junctionBoxes.add("JunctionBox340 102");

        SortJunctionBoxes sol = new SortJunctionBoxes();
        List<String> sorted = sol.sortJunctionBoxes(junctionBoxes);
        for(int i = 0; i < sorted.size() - 1; i++) {
            //sol.printCompareResult(sorted.get(i), sorted.get(i+1));
            //System.out.println("-------------------------------");
            System.out.println(sorted.get(i));
        }

        //Test Priority Queue
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int index1 = o1.indexOf(" ");
                String o1version = o1.substring(index1);
                String o1name = o1.split(" ")[0];

                int index2 = o2.indexOf(" ");
                String o2version = o2.substring(index2);
                String o2name = o2.split(" ")[0];

                return o1version.compareTo(o2version) == 0 ? o1name.compareTo(o2name): o1version.compareTo(o2version);
            }
        });
        queue.add("pear 7");
        queue.add("plum 6");
        queue.add("pineapple 2");
        queue.add("apple 7");
        queue.add("peach 4");
        queue.add("durian 5");
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }
}
