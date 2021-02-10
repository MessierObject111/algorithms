package com.alg.divideConquer;

//Can be done with both DFS and Divide & Conquer

import com.alg.common.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Example 1:
 *
 * Input: tree = {}
 * Output: 0
 * Explanation: The height of empty tree is 0.
 * Example 2:
 *
 * Input: tree = {1,2,3,#,#,4,5}
 * Output: 3
 * Explanation: Like this:
 *    1
 *   / \
 *  2   3
 *     / \
 *    4   5
 * it will be serialized {1,2,3,#,#,4,5}
 *
 */
public class MaximumDepthOfBinaryTree {
    private int depth;
    /**
     * Uses DFS to find the max depth of the tree.
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        traverse(root, 1);
        return depth;
    }

    private void traverse (TreeNode node, int level) {
        if(node == null) {
            return;
        }
        this.depth = this.depth < level ? level : this.depth;
        traverse(node.left, level++);
        traverse(node.right, level++);
    }

    /**
     * Uses Divide & Conquer to find the max depth of the tree.
     * @param root
     * @return
     */
    public int maxDepthDivideNConquer (TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDepth = maxDepthDivideNConquer (root.left) + 1;
        int rightDepth = maxDepthDivideNConquer (root.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode node_1a = new TreeNode(4);
        TreeNode node_1b = new TreeNode(9);

        TreeNode node_2a = new TreeNode(2);
//        TreeNode node_1b = new TreeNode(4);
        TreeNode node_2c = new TreeNode(8);
        TreeNode node_2d = new TreeNode(10);

        TreeNode node_4a = new TreeNode(12);

        root.left = node_1a;
        root.right = node_1b;
        node_1a.left = node_2a;
        node_1b.left = node_2c;
        node_1b.right = node_2d;
        node_2d.right = node_4a;
/**
 *  *         5
 *  *        / \
 *  *      4    9
 *  *     /    / \
 *  *    2    8  10
 *  *              \
 *  *              12
 */
        MaximumDepthOfBinaryTree instance = new MaximumDepthOfBinaryTree();
        System.out.println(instance.maxDepthDivideNConquer(root));
    }
}
