package com.alg.divideConquer;

import com.alg.common.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 *
 * Example  1:
 * 	Input: tree = {1,2,3}
 * 	Output: true
 *
 * 	Explanation:
 * 	This is a balanced binary tree.
 * 		  1
 * 		 / \
 * 		2  3
 *
 *
 * Example  2:
 * 	Input: tree = {3,9,20,#,#,15,7}
 * 	Output: true
 *
 * 	Explanation:
 * 	This is a balanced binary tree.
 * 		  3
 * 		 / \
 * 		9  20
 * 		  /  \
 * 		 15   7
 *
 *
 * Example  3:
 * 	Input: tree = {1,#,2,3,4}
 * 	Output: false
 *
 * 	Explanation:
 * 	This is not a balanced tree.
 * 	The height of node 1's right sub-tree is 2 but left sub-tree is 0.
 * 		  1
 * 		   \
 * 		   2
 * 		  /  \
 * 		 3   4
 *
 */
public class BalancedBinaryTree {
    private int numOfNodes = 0;
    private int depth = 0;

    private static final int NOT_BALANCED = -1;
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if(root == null) return true;
        return maxDepth(root) != NOT_BALANCED;
    }

    private int maxDepth (TreeNode node) {
        if (node == null) return 0;
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        if(left == NOT_BALANCED || right == NOT_BALANCED) {
            return NOT_BALANCED;
        }
        if(Math.abs(left - right) > 1) {
            return NOT_BALANCED;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode node_1a = new TreeNode(4);
        TreeNode node_1b = new TreeNode(9);

        TreeNode node_2a = new TreeNode(2);
//        TreeNode node_1b = new TreeNode(4);
        TreeNode node_2c = new TreeNode(8);
        TreeNode node_2d = new TreeNode(10);

        root.left = node_1a;
        root.right = node_1b;
        node_1a.left = node_2a;
        node_1b.left = node_2c;
        node_1b.right = node_2d;
/**
 *  *         5
 *  *        / \
 *  *      4    9
 *  *     /    / \
 *  *    2    8  10
 */
        BalancedBinaryTree instance = new BalancedBinaryTree();
        System.out.println(instance.isBalanced(root));//Expects true
    }
}
