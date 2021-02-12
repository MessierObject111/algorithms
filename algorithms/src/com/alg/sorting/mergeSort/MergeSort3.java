package com.alg.sorting.mergeSort;

import com.alg.common.TreeNode;

//2021-02-10
public class MergeSort3 {
    /**
     * This is a template for iterating over an array from start
     * to end by a 'Binary Tree Traversal' way.
     * It will be extremely useful for algorithms like merge sort.
     * It calculates the middle point, divides given array by
     * left half + right half, then narrows down it recursively
     * until only one item is in given range (start == end).
     * When such condition is met, place merging logic right after
     * that to merge left + right recursively.
     * Because it keep diving down, and doesn't do logic before
     * both left & right 'leaf' is reached, it resembles
     * similarities to an post-order-traversal of binary tree.
     * It has to be 'Post-Order-Traversal' because the merge can
     * only begin when both left and right sub-arrays are iterated
     * and 'took care of'.
     * A more detailed visualized map can be found at
     * https://www.baeldung.com/java-merge-sort
     * @param array
     * @param start
     * @param end
     */
    public void postOrderTraversalOnArray(int[] array, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            postOrderTraversalOnArray(array, start, mid);
            postOrderTraversalOnArray(array, mid + 1, end);
            // Place merging logic here...
//            System.out.println("Merge: start:" + start + " mid:"+ mid + " end:" + end);
            merge(array, start, mid, end);

        }
    }

    // as comparison
    public void postOrderTraversalOnTree (TreeNode root) {
        if (root != null) {
            postOrderTraversalOnTree(root.left);
            postOrderTraversalOnTree(root.right);
            //  Place logic here...
        }
    }

    /**
     * This method will do the essential "merge & sort" logic.
     * Thanks to the groundwork laid before, All we need to do
     * here is to assume the left and right sub array are
     * already sorted, we just need to merge them into a bigger
     * array then copy to the original array. Previous method
     * calls this method from smaller subsets to bigger subsets
     * with classic divide and conquer.
     * @param list
     * @param left
     * @param mid
     * @param end
     */
    private void merge(int[] list, int left, int mid, int end) {
        int leftSize = mid - left + 1;// TODO: Why the + 1 here? How about base case merge(list, 0, 0, 1)?
        int rightSize = end - mid;
        int[] leftTemp = new int[leftSize];
        int[] rightTemp = new int[rightSize];
        for(int i = 0; i < leftSize; i++) {
            leftTemp[i] = list[left + i];// It guarantees leftTemp is not empty; at least 1
        }
        for(int j = 0; j < rightSize; j++) {
            rightTemp[j] = list[mid + 1 + j]; // mid + 1 is the official start point for sub array on the right side
        }

        int i = 0, j = 0, index = left;
        while (i < leftSize && j < rightSize) {
            if(leftTemp[i] >= rightTemp[j]) {
                list[index] = leftTemp[i];
                i++;
            } else {
                list[index] = rightTemp[j];
                j++;
            }
            index++;
        }
        while(i < leftSize) {
            list[index] = leftTemp[i];
            i++;
            index++;
        }
        while(j < rightSize) {
            list[index] = rightTemp[j];
            j++;
            index++;
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 9, 4, 7, 1, 2, 4, 8, 6, 3};
        MergeSort3 solution = new MergeSort3();
        solution.postOrderTraversalOnArray(array, 0, array.length - 1);
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
//        System.out.println("1/2 = "+1/2);//0
//        System.out.println("8/2 = "+8/2);//4
//        System.out.println("13/2 = "+13/2);//6
    }
}
