package com.alg.sorting;

/**
 * Quick sort is not a divide & conquer algorithm -- It does not build the result bottom-up; it starts the sorting in
 * upper recursions by putting all the elements smaller than pivot to the left unordered, and all the elements bigger
 * than the pivot to the right unordered.
 */
public class QuickSort {
    public void quickSort (int[] nums, int start, int end) {
        if(start >= end) return ;
        int left = start, right = end;
        int pivot = nums[(left + right) / 2];
        int mid = (left + right) / 2;
//        System.out.println("left: "+ left + " right: "+ right +" mid: "+mid + " pivot: " + pivot);
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            /*
            Swap those element at left and right because the left one is greater than pivot and right one is smaller
            than pivot. If left == right, left will become pivot index + 1 and right will become pivot index - 1...
            */
            if(left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                // Both pointers needs to go toward center pivot one step after swapping for the next while loop.
                left++;
                right--;
            }
        }
        /*
          ..which is why in the next sub-array recursion, we only need to sort from start -> right and left -> end.
          ...start, ...., left, pivot, right, ...end, ...
        */
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }

    public static void main(String[] args) {
//        int[] nums1 = {4, 8, 3, 9, 5, 2, 7, 1, 6};
//        QuickSort instance = new QuickSort();
//        instance.quickSort(nums1, 0, nums1.length - 1);
//        for(int i = 0; i < nums1.length; i++) {
//            System.out.print(nums1[i] + " ");
//        }
//        System.out.println(" ---- -----");

        int[] nums1 = {19,25,66,51,5,40,43,9,0,4,55,28,63,67,35,57};
        QuickSort instance = new QuickSort();
        instance.quickSort(nums1, 0, nums1.length - 1);
        for(int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println(" ---- -----");
        try {
            int[] nums2 = {19,-10,-2,40,3,36,57,25,66,51,5,40,-8,43,9,-5,0,4,55,28,63,67,-2,35,57,0,0,30,17,55,22,34,-4,
                    42,57,52,4,65,6,-2,8,12,31,43,26,34,31,19,-3,36,34,11,58,23,13,7,17,10,33,-5,10,53,14,56,18,8,-6,-2,37,7};
            int[] expected = {-10,-8,-6,-5,-5,-4,-3,-2,-2,-2,-2,0,0,0,3,4,4,5,6,7,7,8,8,9,10,10,11,12,13,14,17,17,18,19,
                    19,22,23,25,26,28,30,31,31,33,34,34,34,35,36,36,37,40,40,42,43,43,51,52,53,55,55,56,57,57,57,58,63,65,66,67};
            boolean abnormally = false;
            instance.quickSort(nums2, 0, nums2.length - 1);
            for(int i = 0; i < nums2.length; i++) {
                if(nums2[i] == expected[i]) {
                    System.out.println(nums2[i] + " - "+ expected[i]);
                } else {
                    System.out.println(nums2[i] + " - "+ expected[i]);
                    abnormally = true;
                    break;
                }
            }
            if(abnormally) {
                System.out.println("***Array not sorted***");
            }else{
                System.out.println("---Array successfully sorted---");
            }
        } catch (Exception e) {

        }

    }
}
