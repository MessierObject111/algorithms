package com.alg.binarySearch;

/**
 * There is an integer array which has the following features:
 *
 * The numbers in adjacent positions are different.
 * A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
 * We define a position P is a peak if:
 *
 * A[P] > A[P-1] && A[P] > A[P+1]
 * Find a peak element in this array. Return the index of the peak.
 *
 * It's guaranteed the array has at least one peak.
 * The array may contain multiple peeks, find any of them.
 * The array has at least 3 numbers in it.
 *
 */
public class FindPeakElement {
    /**
     * Iterate through the array to find the downward points.
     * time complexity: O(n)
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeakA(int[] A) {
        // write your code here
        if(A.length == 1) {
            return A[0];
        }
        int i = 1;
        for(; i < A.length; i++) {
            int pointerA = A[i-1];
            int pointerB = A[i];
            if(pointerB < pointerA) {
                return i - 1;
            }
        }
        return A.length - 1;

    }

    /**
     *
     * @param A
     * @return
     */
    public int findPeakB(int[] A) {
        // write your code here
        if(A.length == 1) {
            return A[0];
        }
        int start = 1, end = A.length -2;
        // Note 1: start + 1 < end
        while (start + 1 < end) {
            // Note 2:
            int mid = start + (end - start)/2;
            // Note 3：=, <, > 分开讨论，mid 不+1也不-1
            // Well we have to check mid - 1 and mid + 1 to see if it is peak for this fucking problem
            if (A[mid - 1] < A[mid]) {
                start = mid;

            } else {
                end = mid;
            }

        }
        if(A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }

    public int findPeak(int[] A) {
        // write your code here
        int start = 1, end = A.length-2; // 1.答案在之间，2.不会出界
        while(start + 1 <  end) {
            int mid = (start + end) / 2;
            if(A[mid] < A[mid - 1]) {
                end = mid;
            } else if(A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }



    public static void main(String[] args) {
        FindPeakElement instance = new FindPeakElement();
        System.out.println(3/2);
        System.out.println(4/2);

        int[] array = {1,8,2,3,4,5,7,6};
        System.out.println(instance.findPeakB(array));
    }
}
