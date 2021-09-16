package com.java8.stream.mergeLists;

import com.java8.stream.SamplePerson;
import com.java8.stream.SampleWorker;
import com.java8.stream.Sex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSortFilterListsTest {
    public static void main(String[] args) {
        SampleWorker p1 = new SampleWorker("Alyx", 24, Sex.FEMALE);
        SampleWorker p2 = new SampleWorker("Beatrice", 22, Sex.FEMALE);
        SampleWorker p3 = new SampleWorker("Charles", 17, Sex.MALE);
        SampleWorker p4 = new SampleWorker("Derick", 33, Sex.MALE);
        SampleWorker p5 = new SampleWorker("Eric", 44, Sex.MALE);
        SampleWorker p6 = new SampleWorker("Flora", 20, Sex.FEMALE);
        SampleWorker p7 = new SampleWorker("Greg", 15, Sex.MALE);

        List<SampleWorker> list1 = new ArrayList<>();
        list1.add(p1);
        list1.add(p2);
        list1.add(p3);

        List<SampleWorker> list2 = new ArrayList<>();
        list2.add(p4);
        list2.add(p5);
        list2.add(p6);
        list2.add(p7);

        //Classic merge:
//        List<SampleWorker> newList = new ArrayList<SampleWorker>();
//        newList.addAll(list1);
//        newList.addAll(list2);

        //Java 8 stream API merge:
        List<SampleWorker> newList = Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toList());

        //Classic sort
//        List<SampleWorker> sortedList = newList.stream().sorted((o1, o2)-> {
//            return o1.getAge() - o2.getAge();
//        }).collect(Collectors.toList());

        //Sort with Comparator.comparingInt method
        List<SampleWorker> sortedList = newList.stream().sorted(Comparator.comparingInt(SamplePerson::getAge)).collect(Collectors.toList());

//        sortedList.forEach(sampleWorker -> {
//            System.out.println(sampleWorker.getName());
//        });

        //Filter: find workers who are more than 22 years old
        List<SampleWorker> filteredList = newList.stream().filter(p -> p.getAge() > 22).collect(Collectors.toList());

        filteredList.forEach(sampleWorker -> {
            System.out.println(sampleWorker.getName());
        });
    }
}
