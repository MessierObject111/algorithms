package com.alg.binarySearch;

/**
 * The code base version is an integer start from 1 to n. One day, someone committed a bad version in the code case, so
 * it caused this version and the following versions are all failed in the unit tests. Find the first bad version.
 *
 * You can call isBadVersion to help you determine which version is the first bad one. The details interface can be
 * found in the code's annotation part.
 *
 * Given n = 5:
 *
 *     isBadVersion(3) -> false
 *     isBadVersion(5) -> true
 *     isBadVersion(4) -> true
 *
 * Here we are 100% sure that the 4th version is the first bad version.
 * Challenge
 * You should call isBadVersion as few as possible.
 */

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether
 * the kth code version is bad or not.
 */
public class FirstBadVersion {
    public static class SVNRepo {
        private static ArrayList<Boolean> repoVersions;
        private static int counter;
        public static void init (ArrayList<Boolean> list) {
            counter = 0;
            repoVersions = list;
        }
        public static boolean isBadVersion(int k) {
            counter++;
//            System.out.println(counter);
            return repoVersions.get(k - 1);
//            return k == 2147483647 ? true : false;
        }
        public static int showCount(){
            return counter;
        }
    }
    /**
     * Use classical binary search method to locate the bad version; to handle MAX_INT case, we used BigInteger
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if(n < 1) return -1;
        if(n == 1) return 1;
        if(SVNRepo.isBadVersion(1)) return 1;
        BigInteger left = new BigInteger("1");
        BigInteger right = new BigInteger(Integer.toString(n));
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        while(left.add(one).compareTo(right) == -1) {
            BigInteger mid = (left.add(right)).divide(two);
//            System.out.println(mid);
            if(SVNRepo.isBadVersion(mid.intValue())) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if(!SVNRepo.isBadVersion(left.intValue()) && SVNRepo.isBadVersion(right.intValue())) {
            return right.intValue();
        }
        return -1;
    }

    /**
     * Use exponential steps to search for the bad version.
     * @param n
     * @return
     */
    public int findFirstBadVersionExpStep(int n) {
        if(n < 1) return -1;
        if(n == 1) return 1;
        if(SVNRepo.isBadVersion(1)) return 1;
        int index = 1;
        int step = 1;
        while (step != 0) {
            while(n - index  < step
                    || SVNRepo.isBadVersion(index + step)) {
                step >>= 1;
            }
            index += step;
            step <<= 1;
        }
        if(SVNRepo.isBadVersion(index + 1)){
            return index + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for(int i = 0; i <= 998; i++) {
            list.add(false);
        }
        for(int i = 999; i <= 999; i++) {
            list.add(true);
        }
//        list.add(false);
//        list.add(true);
        SVNRepo.init(list);
        FirstBadVersion instance = new FirstBadVersion();
//        int index = instance.findFirstBadVersion(2147483647);
        int index = instance.findFirstBadVersionExpStep(1000);
        System.out.println(index);
        System.out.println(SVNRepo.showCount());
    }
}
