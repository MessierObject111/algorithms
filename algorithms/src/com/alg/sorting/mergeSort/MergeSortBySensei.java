package com.alg.sorting.mergeSort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSortBySensei {
    public static void mergeSort(int[] arr, int l, int r){
    if (l < r){
        int m = l + (r-l)/2;
        mergeSort(arr,l,m);
        mergeSort(arr,m+1,r);
        merge1(arr, l, m, r);
        System.out.println(String.format("l=%d; m=%d; r=%d; ",l,m,r) + Arrays.stream(arr).boxed().collect(Collectors.toList()));

    }
}

    public static void merge1(int[] arr,int l, int m, int r ){
        int[] leftArr = new int[m-l+1];
        System.arraycopy(arr,l,leftArr,0,m-l+1);

        int[] rightArr = new int[r-m] ;
        System.arraycopy(arr,m+1,rightArr,0,r-m);

        int i=0,j=0, k =l;
        while (i < leftArr.length && j < rightArr.length){
            if (leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }
            else {
                arr[k]= rightArr[j];
                j++;
            }
            k++;
        }
//        while (i < leftArr.length){
//            arr[ k] = leftArr[i];
//            i++;
//            k++;
//        }
        System.arraycopy(leftArr,i,arr,k,leftArr.length-i);

//        while (j < rightArr.length){
//            arr[k] = rightArr[j];
//            j++;
//            k++;
//        }
        System.arraycopy(rightArr,j,arr,k,rightArr.length-j);

    }

    public static void merge2(int[] arr,int l, int m, int r ){
        int[] result = new int[r-l+1];

        int i=l,j=m+1, k =0;
        while (i <= m  && j <= r){
            if (arr[i] <= arr[j]){
                result[k] = arr[i];
                i++;
            }
            else {
                result[k]= arr[j];
                j++;
            }
            k++;
        }
        if (i <= m){
            System.arraycopy(arr,i,result,k,m-i+1);
        }
        if (j <= r){
            System.arraycopy(arr,j,result,k,r-j+1);
        }
        System.arraycopy(result,0,arr,l,r-l+1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{232,44,1,455,98,20,79,210};
        mergeSort(a,0,a.length-1);
        System.out.println(Arrays.stream(a).boxed()
                .collect(Collectors.toList()));
    }
}
