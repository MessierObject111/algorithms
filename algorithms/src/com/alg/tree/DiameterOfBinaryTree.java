package com.alg.tree;

import com.alg.common.TreeNode;
//https://leetcode.com/problems/diameter-of-binary-tree/submissions/
//It is supposed to be easy question, but I couldn't think out a solution.
//Once knowing solution, it is pretty easy to implement
public class DiameterOfBinaryTree {
    private int diameter = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {

        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);

        diameter = Math.max(diameter, leftMax + rightMax);
        return diameter;
    }

    private int dfs(TreeNode node) {
        if(node == null) return 0;
        int leftMax = dfs(node.left);
        int rightMax = dfs(node.right);

        diameter = Math.max(diameter, leftMax + rightMax);

        return Math.max(leftMax, rightMax) + 1;
    }
}
