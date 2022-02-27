package com.alg.binarySearch;

public class FirstBadVersion20220227 {
    //Apparently I forgot how this was done all together
    public boolean[] commits;
    public int firstBadVersion(int n) {
        long start = System.currentTimeMillis();
        if(isBadVersion(1)) return 1;
        int result = binarySearch(1, n);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Time used: "+ timeElapsed);//Time lapsed here proved recursion doesn't take noticeable more time than iteration
        return result;
    }

    private int binarySearch(int start, int end) {
        if(start + 1 >= end) { // BUG ALERT!!! INT overflow, should be (end-start <= 1)
            return isBadVersion(start) ? start : end;
        }
        int mid = start + (end - start)/2;//To avoid int overflow when doing (start + end)/2
        if(isBadVersion(mid)) return binarySearch(start, mid);
        return binarySearch(mid + 1, end);
    }

    private boolean isBadVersion(int index) {
//        System.out.println(index + " checked!");
        return this.commits[index];
    }

    public static void main(String[] args) {
        FirstBadVersion20220227 sol = new FirstBadVersion20220227();
        int n = 2147483645;
        int firstBadVersion = 2147483644;

        sol.commits = new boolean[n];

        for(int i = 0; i < firstBadVersion; i++) {
            sol.commits[i] = false;
        }
        for(int i = firstBadVersion; i < n; i++) {
            sol.commits[i] = true;
        }
        System.out.println(sol.firstBadVersion(n));;
    }
}
