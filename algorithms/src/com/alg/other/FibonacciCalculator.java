package com.alg.other;

public class FibonacciCalculator {

    public static Double fibonacci (int index) {
        if(index == 0 ) return 0.0;
        if(index ==1 || index == 2) return 1.0;
        Double i = 1.0;
        Double j = 1.0;
        for(int m = 0; m < index - 1; m++) {
            Double sum = i + j;
            i = j;
            j = sum;
        }
        return j;
    }

    public static Double recursiveFibonacci (int index) {
        if(index <= 0) return 0.0;
        if (index == 1 || index == 2) return 1.0;
        if (index > 2) {
            return recursiveFibonacci(index - 1) + recursiveFibonacci (index - 2);
        }
        return 0.0;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            System.out.println(fibonacci(i));
        }

//        for(int i = 0; i < 100; i++){
//            System.out.println(recursiveFibonacci(i));
//        }
    }
}
