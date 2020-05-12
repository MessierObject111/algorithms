package com.alg.divideConquer;

import com.alg.common.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Example 1:
 *
 * Input: {}
 * Output: 0
 * Example 2:
 *
 * Input:  {1,#,2,3}
 * Output: 3
 * Explanation:
 * 	1
 * 	 \
 * 	  2
 * 	 /
 * 	3
 * it will be serialized {1,#,2,3}
 * Example 3:
 *
 * Input:  {1,2,3,#,#,4,5}
 * Output: 2
 * Explanation:
 *       1
 *      / \
 *     2   3
 *        / \
 *       4   5
 * it will be serialized {1,2,3,#,#,4,5}
 */
public class MinimumDepthOfBinaryTree {
    /**
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            System.out.println("root: " + root.val);
            System.out.println("left: " + 0 + " right: " + 0);
            return 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
//        System.out.println("root: " + root.val);
//        System.out.println("left: " + left + " right: " + right);
        if(root.left != null && root.right != null) {
            return Math.min(left, right) + 1;
        }
        return left == 0 ? right + 1 : left + 1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode node_1a = new TreeNode(4);
        TreeNode node_1b = new TreeNode(9);

        TreeNode node_2a = new TreeNode(2);

        TreeNode node_2c = new TreeNode(8);
        TreeNode node_2d = new TreeNode(10);

        TreeNode node_4a = new TreeNode(12);

        root.left = node_1a;
        root.right = node_1b;
//        node_1a.left = node_2a;
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
        MinimumDepthOfBinaryTree instance = new MinimumDepthOfBinaryTree();
        System.out.println(instance.minDepth(root));
    }
}
