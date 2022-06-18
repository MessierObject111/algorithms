package com.companies.meta;

import com.alg.common.TreeNode;

public class RangeSumOfBST {
    private int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        //Terminal condition;
        if(root.val >= low && root.val <= high) {
            sum += root.val;
        }
        //Recurse through children; the "&& root.val > low" part here is to boost performance by avoiding unecessary iterations
        if(root.left != null && root.val > low) {
            rangeSumBST(root.left, low, high);
        }
        //Same recurse to right node;
        if(root.right != null && root.val < high) {
            rangeSumBST(root.right, low, high);
        }
        return sum;
    }
}
