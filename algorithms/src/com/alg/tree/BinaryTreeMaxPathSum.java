package com.alg.tree;

import com.alg.common.TreeNode;
import com.java.se.inheritancePolymorphism.question9.B;

public class BinaryTreeMaxPathSum {

    int MAX_SUM = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        //Calculate left side's max path sum, then the right side's max path sum,
        //then decide whether it is better to combine itself with both， or pick one side only
        dfs(root);
        return MAX_SUM;
    }

    private int dfs(TreeNode node) {
        if(node == null) return 0;
        //It is vital part here that we pick either 0, or the left/right max path sum here; if the left max path sum is
        // negative number, we simply choose to not pick it up as part of path, a.k.a treat it as zero here. Same for
        // right side max path sum. This recipe down below will always get the max possible combination of path sum of
        // current node, no matter it is node.val alone, or val + left, or val + right, or val + left + right.
        //e.g: root = 5, l = 3, r = -7, max path sum should be root + l + 0 because -7 < 0;
        //e.g: root = 5, l = 3, r = 7, max path sum should be root + l + r because 7 > 0;
        int lm = Math.max(dfs(node.left), 0);
        int rm = Math.max(dfs(node.right), 0);
        int maxPathSumOfNodeByItself = lm + rm + node.val;
        MAX_SUM = MAX_SUM < maxPathSumOfNodeByItself ? maxPathSumOfNodeByItself : MAX_SUM;

        //When current node serves as a child node/partial path of sum, we can only choose left sum + val or right sum +
        // val, or val itself to pass back to caller, because a single path cannot branch out two branches in one node.
        int maxPathSumOfNodeAsBranch = Math.max(lm, rm) + node.val;
        return maxPathSumOfNodeAsBranch;
    }

    public static void main(String[] args) {
        TreeNode node_1 = new TreeNode(11);
        TreeNode node_2 = new TreeNode(5);
        TreeNode node_3 = new TreeNode(-3);

        node_1.left = node_2;
        node_1.right = node_3;

        TreeNode root = node_1;

        BinaryTreeMaxPathSum sol = new BinaryTreeMaxPathSum();
        System.out.println(sol.maxPathSum(root));//Should be 11 + 5 + 0 = 16
    }
}
