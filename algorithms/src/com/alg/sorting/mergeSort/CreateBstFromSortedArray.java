package com.alg.sorting.mergeSort;

import com.alg.common.TreeNode;

public class CreateBstFromSortedArray {
    public TreeNode createBstFromSortedArray (int[] array) {
        int length = array.length;
        TreeNode root = new TreeNode(0);
        if (length == 1) {
            root = new TreeNode(array[0]);
        }
        inOrderTraversal(array, 0, length - 1, root);
        return root;
    }

    private void inOrderTraversal (int[] list, int start, int end, TreeNode root) {
        if(start < end) {
            int mid = start + (end - start) / 2;
            try {
                root.val = list[mid];
                System.out.println("value attached:" + root.val);
                TreeNode left = new TreeNode(0);
                TreeNode right = new TreeNode(0);
                root.left = left;
                root.right = right;
                inOrderTraversal(list, start, mid, root.left);
                inOrderTraversal(list, mid+1, end, root.right);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }


        }
        if(start == end) {
            // printing when successfully pinpoint single array item
//            System.out.println("atom size reached: start:" + start + " value:"+ list[start]);
        }


    }

    public static void main(String[] args) {
        int[] list_1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        CreateBstFromSortedArray solution = new CreateBstFromSortedArray();
        TreeNode node = solution.createBstFromSortedArray(list_1);
        System.out.println(node.val);
    }
}
