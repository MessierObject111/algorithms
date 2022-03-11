package com.alg.twoPointers;

/**
 * You are given an array arr which consists of only zeros and ones, divide the array into three non-empty parts such
 * that all of these parts represent the same binary value.
 *
 * If it is possible, return any [i, j] with i + 1 < j, such that:
 *
 * arr[0], arr[1], ..., arr[i] is the first part,
 * arr[i + 1], arr[i + 2], ..., arr[j - 1] is the second part, and
 * arr[j], arr[j + 1], ..., arr[arr.length - 1] is the third part.
 * All three parts have equal binary values.
 * If it is not possible, return [-1, -1].
 *
 * Note that the entire part is used when considering what binary value it represents. For example, [1,1,0] represents 6
 * in decimal, not 3. Also, leading zeros are allowed, so [0,1,1] and [1,1] represent the same value.
 *
 *
 * **/
public class ThreeEqualParts {
    public int[] threeEqualParts(int[] arr) {
        int result[] = new int[2];
        for(int i = 0; i <= arr.length - 2; i++) {
            for(int j = i + 2; j <= arr.length - 1; j++) {
                int p1 = 0; //->i
                int p2 = i+1; // ->j-1
                int p3 = j; // -> arr.length
//                if(i == 1 && j == 4) {
//                    System.out.println("Bingo");
//                }
                p1 = findNextNoneZeroIndex(p1, i, arr);
                p2 = findNextNoneZeroIndex(p2, j-1, arr);
                p3 = findNextNoneZeroIndex(p3, arr.length - 1, arr);
                for(; p1 <= i && p2 < j && p3 <= arr.length - 1; p1++, p2++, p3++) {
                    if(arr[p1] != arr[p2] || arr[p2] != arr[p3]) {
                        break;
                    }
                    if(p1 == i && p2 == j-1 && p3 == arr.length - 1) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
        }
        result[0] = -1;
        result[1] = -1;
        return result;
    }

    private int findNextNoneZeroIndex (int p, int boundary, int[] arr) {
        if(p == boundary) return p;
        while (p < boundary && arr[p] == 0) {
            p++;
        }
        return p;
    }

    public static void main(String[] args) {
        ThreeEqualParts sol = new ThreeEqualParts();
        int[] arr = {1,0,1,0,1}; // {0, 3}; from 0 - i(0), then i+1(1) - j-1(2), then j(3) - 4
        int[] result = sol.threeEqualParts(arr);
        System.out.println(result[0] + ", " + result[1]);

        int[] arr2 = {0,1,0,1,1}; // {1, 4};
        int[] result2 = sol.threeEqualParts(arr2);
        System.out.println(result2[0] + ", " + result2[1]);

//        int[] arr3 = {0,0,0,0,0};//[0,4];
//        int[] result3 = sol.threeEqualParts(arr3);
//        System.out.println(result3[0] + ", " + result3[1]);
    }
}
