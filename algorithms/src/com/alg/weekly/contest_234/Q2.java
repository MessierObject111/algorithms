package com.alg.weekly.contest_234;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.*;
/**
 * If i % 2 == 0, then arr[i] = perm[i / 2].
 * If i % 2 == 1, then arr[i] = perm[n / 2 + (i - 1) / 2].
 *
 * https://leetcode.com/contest/weekly-contest-234/problems/minimum-number-of-operations-to-reinitialize-a-permutation/
 */
public class Q2 {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            perm[i] = i;
        }
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0){
                arr[i] = perm[i / 2];
            }
            if(i % 2 == 1){
                arr[i] = perm[n / 2 + (i - 1) / 2];
//                System.out.print(i + ": ");
//                System.out.print("  n / 2 =" + n/2);
//                System.out.print("  (i - 1) / 2 =" + (i - 1) / 2);
//                System.out.println();
            }
            System.out.println(i+ ": " +arr[i]);
        }
        int result = minimumSwaps(arr) + 1;

        return result;
    }

    private int minimumSwaps(int[] arr) {
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==i+1) continue;
            count++;
            int tmp = arr[i];
            arr[i] = arr[tmp-1];
            arr[tmp-1] = tmp;
            i--;
        }
        return count;
    }

    /**
     * From leetcode user uwi
     * @param n
     * @return
     */
    public int reinitializePermutationUwi(int n) {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = i;
        int[] base = Arrays.copyOf(a, n);

        int step = 0;
        while(true){
            int[] b = new int[n];
            for(int i = 0;i < n;i++){
                if(i % 2 == 0){
                    b[i] = a[i/2];
                }else{
                    b[i] = a[n/2+(i-1)/2];
                }
            }
            step++;
            if(Arrays.equals(base, b)){
                return step;
            }
            a = b;
        }
    }

    public static void main(String[] args) {
        Q2 q = new Q2();
        System.out.println(q.reinitializePermutationUwi(6));
    }
}
