package com.alg.sorting;

public class QuickSortII {
    public void quickSort_wrong_version (int[] nums, int start, int end) {
        if(start >= end) return ;
        int left = start, right = end;
        // 1-The pivot VALUE should be stored before we iterate; In the process of element shuffling around pivot value,
        // the pivot element itself may get moved to somewhere else, too. e.g, 2, 3, 1, 4 pivot will be '3' at index 1,
        // but it will get moved to index 2 after sorting: 2, 1, 3, 4
        // If we store its index rather than value here,
        // it will cause bugs in below nums[mid] because nums[mid] can be a different element in the process
        int mid = (left + right) / 2;
//        System.out.println("left: "+ left + " right: "+ right + " mid: "+ mid + " pivot: " + nums[(left + right) / 2]);
        while (left <= right) {
            while (left <= right && nums[left] < nums[mid]) { // 1-The index 'pivot'
                left++;
            }
            while (left <= right && nums[right] > nums[mid]) { // 1-
                right--;
            }
            if(left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        // 2- I don't remember how I ended up in this below logic but it causes bugs
        // Now I understand what was my mistake. It is closely related to mistake No. 1 : the middle index for pivot is
        // not necessarily the middle number ordered by value, thus we cannot possibly use the middle index to determine
        // how to divide the current array to halves. e.g, for an array consisted of 10 elements (1 -? 10), the middle
        // index, 5, may have a number that is 2, or 8, on that index:
        //              | middle pivot: 9
        // {2, 8, 3, 5, 9, 1, 4, 7, 0, 6}
        // after first round of sorting:
        // {2, 8, 3, 5, 6, 1, 4, 7, 0, 9}
        // After sorting, we should locate the index of '9' the pivot, rather than sorting by the middle index 5, to
        // continue next layer of sorting recursion. 
        if(start < mid) {
            quickSort_wrong_version(nums, start, mid);
        }
        if(mid < end) {
            quickSort_wrong_version(nums, mid + 1, end);
        }
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
        QuickSortII instance = new QuickSortII();
        instance.quickSort_wrong_version(nums1, 0, nums1.length - 1);
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
            instance.quickSort_wrong_version(nums2, 0, nums2.length - 1);
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
