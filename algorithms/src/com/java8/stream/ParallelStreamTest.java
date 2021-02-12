package com.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ParallelStreamTest {
    private static ArrayList<Person> list;
    private static final String path = "C:\\Users\\MessierObject111\\Documents\\IntelliJProject\\algorithms\\src\\com\\stream";
    static {
        int i = 100000;
        list = new ArrayList<>(i);
        Random rand = new Random();

        while (i > 0) {
            // Generate random integers in range 0 to 999
            int age = rand.nextInt(100);
            Person p = new Person();
            if(i%2 == 1) {
                p = new Person(age, Gender.MALE);
            } else {
               p = new Person(age, Gender.FEMALE);
            };

            list.add(p);
            i--;
        }
    }

    private static class Person {
        int age;
        Gender sex;

        public Person() {
        }

        public Person(int age, Gender sex) {
            this.age = age;
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Gender getSex() {
            return sex;
        }

        public void setSex(Gender sex) {
            this.sex = sex;
        }
    }

    enum Gender {
        MALE,
        FEMALE
    }


    static class PrimeNumberCounter {
        public long countPrimes(int max) {
            ArrayList<Long> list = new ArrayList(max);
            long i = 0;
            while (i < max) {
                list.add(i);
                i++;
            }
            return list.stream().filter(this::isPrime).count();
        }

        public long countPrimesParallel(int max) {
            ArrayList<Long> list = new ArrayList(max);
            long i = 0;
            while (i < max) {
                list.add(i);
                i++;
            }
            return list.parallelStream().filter(this::isPrime).count();
        }

        public long countPrimesByForLoops(int max) {
            // We don't need to generate an arraylist to begin with here
//            ArrayList<Long> list = new ArrayList(max);
//            long j = 0;
//            while (j < max) {
//                list.add(j);
//                j++;
//            }
            int count = 0;
            for(long i = 0; i < max; i++) {
                if(isPrime(i)) {
                    count++;
                }
            }
            return count;
        }

        public boolean isPrime(long num) {
            boolean flag = false;
            for (int i = 2; i <= num / 2; ++i) {
                // condition for nonprime number
                if (num % i == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                return true;
            return false;
        }
    }



    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9);
        list.stream().forEach(System.out::println);
        System.out.println();
        list.parallelStream().forEach(System.out::println);
//        long start1 = System.currentTimeMillis();
//        list.stream().forEach(p -> {
//            //System.out.print(p.getSex() + " - " + p.getAge());
//            String temp = p.getSex() + " - " + p.getAge();
//        });
//        System.out.println();
//        long finish1 = System.currentTimeMillis();
//        long timeElapsed1 = finish1 - start1;
//        System.out.println("timeElapsed1: " + timeElapsed1);
//
//        long start2 = System.currentTimeMillis();
//        list.parallelStream().forEach(p -> {
////            System.out.print(p.getSex() + " - " + p.getAge());
//            String temp = p.getSex() + " - " + p.getAge();
//        });
//        System.out.println();
//        long finish2 = System.currentTimeMillis();
//        long timeElapsed2 = finish2 - start2;
//        System.out.println("timeElapsed2: " + timeElapsed2);

        PrimeNumberCounter primeNumberCounter = new PrimeNumberCounter();
        int max = 100_000;
        long start3 = System.currentTimeMillis();
        System.out.println("Count of primes with stream: " +  primeNumberCounter.countPrimes(max));
        long finish3 = System.currentTimeMillis();
        long timeElapsed3 = finish3 - start3;
        System.out.println("time Elapsed3: " + timeElapsed3);

        long start4 = System.currentTimeMillis();
        System.out.println("Count of primes with parallel stream: " +  primeNumberCounter.countPrimesParallel(max));
        long finish4 = System.currentTimeMillis();
        long timeElapsed4 = finish4 - start4;
        System.out.println("time Elapsed4: " + timeElapsed4);

        long start5 = System.currentTimeMillis();
        System.out.println("Count of primes by for loops: " + primeNumberCounter.countPrimesByForLoops(max));
        long finish5 = System.currentTimeMillis();
        long timeElapsed5 = finish5 - start5;
        System.out.println("time Elapsed5: " + timeElapsed5);
    }
}
//1000: 37 - 18
//10,000: 91 - 131
//100K: 411 - 468
