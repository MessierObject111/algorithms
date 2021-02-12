package com.alg.sorting.mergeSort;

// Sample from internet
public class MergeSort2 {

    /**
     * To call this method to begin sorting
     * @param arr
     * @param start
     * @param end
     */
    void sort(int arr[], int start, int end)
    {
        // Part A: Slice the array till it is down to one item. Condition breaks at start == end
        if (start < end)
        {
            int mid = (start + end)/2;// Part B: Slice the array till it is down to one item
            sort(arr, start, mid);
            sort(arr , mid+1, end);
            merge(arr, start, mid, end);// Merge back to one single array recursively
        }
    }

    /**
     * This recursive method will merge and sort given array recursively
     * @param arr
     * @param start
     * @param mid
     * @param end
     */
    void merge(int arr[], int start, int mid, int end)
    {
        int leftSize = mid - start + 1;// TODO: Why the + 1 here??
        int rightSize = end - mid;
        int LeftArray[] = new int [leftSize];
        int RightArray[] = new int [rightSize];
        for (int i=0; i < leftSize; ++i)
            LeftArray[i] = arr[start + i];
        for (int j=0; j < rightSize; ++j)
            RightArray[j] = arr[mid + 1+ j]; //TODO: Left array ends at mid, so right array starts at mid+1
        int i = 0, j = 0;
        int k = start;
        while (i<leftSize && j<rightSize) // Copying to original array from temp arrays by order
        {
            if (LeftArray[i] <= RightArray[j])
            {
                arr[k] = LeftArray[i];
                i++;
            }
            else
            {
                arr[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i<leftSize)
        {
            arr[k] = LeftArray[i];
            i++;
            k++;
        }
        while (j<rightSize)
        {
            arr[k] = RightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        // Test
        int[] array = {5, 9, 4, 7, 1, 2, 4, 8, 6, 3};
        MergeSort2 solution = new MergeSort2();
        solution.sort(array, 0, array.length - 1);
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
