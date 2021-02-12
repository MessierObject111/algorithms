package com.alg.sorting.mergeSort;

// 2021-02-11
public class MergeSort {

    public void sort (int[] input) {
        if(input.length > 1) {
            divide(input, 0, input.length - 1);
        }
    }

    /**
     * This is a template for iterating over an array from start to end by a 'Binary Tree Traversal' way.
     * It will be extremely useful for algorithms like merge sort.
     * It calculates the middle point, divides given array by left half + right half,
     * then narrows down it recursively until only one item is in given range (start == end).
     * When such condition is met, place merging logic right after that to merge left + right recursively.
     * Because it keep tracing down, and doesn't do logic before both left & right 'leaf' is reached, it resembles
     * similarities to an post-order-traversal of binary tree. It has to be 'Post-Order-Traversal' because
     * the merge can only begin when both left and right sub-arrays are iterated and 'took care of'.
     * A more detailed visualized map can be found at https://www.baeldung.com/java-merge-sort
     * @param array
     * @param start
     * @param end
     */
    public void divide(int[] array, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            divide(array, start, mid);
            divide(array, mid + 1, end);
            // Place merging logic here...
//            System.out.println("Merge: start:" + start + " mid:"+ mid + " end:" + end);
            mergeBack(array, start, mid, end);

        }
        if(start == end) {
            // printing when successfully pinpoint single array item
//            System.out.println("atom size reached: start:" + start + " value:"+ array[start]);
        }
    }

    /**
     * Merge the given left + right lists and update original array's order
     * @param list
     * @param start
     * @param middle
     * @param end
     */
    private void mergeBack (int[] list, int start, int middle, int end) {
        int leftSize = middle - start + 1;
        int rightSize = end - middle;
        int[] leftTemp = new int[leftSize];
        int[] rightTemp = new int[rightSize];
        for(int i =0; i < leftSize; i++) {
            leftTemp[i] = list[start + i];
        }
        for(int j =0; j < rightSize; j++) {
            rightTemp[j] = list[middle + j + 1];
        }
        int i = 0, j = 0, index = start;
        while(i < leftSize && j < rightSize) {
            if (leftTemp[i] >= rightTemp[j]) {
                list[index] = leftTemp[i];
                i++;
            } else {
                list[index] = rightTemp[j];
                j++;
            }
            index++;
        }
        while (i < leftSize) {
            list[index] = leftTemp[i];
            i++;
            index++;
        }
        while (j < rightSize) {
            list[index] = rightTemp[j];
            j++;
            index++;
        }
    }


    public static void main(String[] args) {
        int[] array = {5, 9, 4, 7, 1, 2, 4, 8, 6, 3};
        MergeSort solution = new MergeSort();
        solution.sort(array);
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
