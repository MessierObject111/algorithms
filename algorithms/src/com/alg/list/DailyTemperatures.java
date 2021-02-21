package com.alg.list;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length] ;
        for(int i = 0; i< T.length; i++) {
            int temp = T[i];
            int counter = 0;
            for(int j = i; j < T.length; j++){
                if(T[j] > temp) {
                    break;
                }
                counter++;
                if(j == T.length - 1){
                    counter = 0;
                }
            }
            res[i] = counter;
        }
        return res;
    }
}
