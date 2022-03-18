package com.alg.dfs;

import com.alg.common.TreeNode;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = new TreeNode();

        if(root1 == null ) {
            return root2;
        }
        if(root2 == null) {
            return root1;
        }
        root.val = root1.val + root2.val;

        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);

        return root;
    }

    public static void main(String[] args) {
        MergeTwoBinaryTrees sol = new MergeTwoBinaryTrees();

        TreeNode root1 = new TreeNode(1);
        TreeNode root1a = new TreeNode(3);
        TreeNode root1b = new TreeNode(2);
        TreeNode root1aa = new TreeNode(5);
        root1.left = root1a;
        root1.right = root1b;
        root1a.left = root1aa;

        TreeNode root2 = new TreeNode(2);
        TreeNode root2a = new TreeNode(1);
        TreeNode root2b = new TreeNode(3);
        TreeNode root2ab = new TreeNode(4);
        TreeNode root2bb = new TreeNode(7);
        root2.left = root2a;
        root2.right = root2b;
        root2a.right = root2ab;
        root2b.right = root2bb;

        System.out.println(sol.mergeTrees(root1, root2));
    }
}
