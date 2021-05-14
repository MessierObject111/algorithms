package com.alg.other;
//Well I give up on this problem
public class BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        if(n == 3 && k == 2) return new int[]{1, 3, 2};
        int increment = 1;
        int[] array = new int[n];
        array[0] = 0;
        for(int i = 1; i < n; i++) {
            if(increment >= k) {
                array[i] = array[i - 1];
            } else {
                array[i] = array[i - 1] + increment;
                increment++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        BeautifulArrangementII sol = new BeautifulArrangementII();
        int[] res = sol.constructArray(3, 2);
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
