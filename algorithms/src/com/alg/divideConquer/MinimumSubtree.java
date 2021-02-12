package com.alg.divideConquer;

import com.alg.common.TreeNode;

/**
 * Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.
 * Example 1:
 *
 * Input:
 * {1,-5,2,1,2,-4,-5}
 * Output:1
 * Explanation:
 * The tree is look like this:
 *      1
 *    /   \
 *  -5     2
 *  / \   /  \
 * 1   2 -4  -5
 * The sum of whole tree is minimum, so return the root.
 * Example 2:
 *
 * Input:
 * {1}
 * Output:1
 * Explanation:
 * The tree is look like this:
 *    1
 * There is one and only one subtree in the tree. So we return 1.
 */
public class MinimumSubtree {
    private int MIN_SUM = Integer.MAX_VALUE;
    private TreeNode MIN_SUB = new TreeNode(Integer.MAX_VALUE);
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        if (root == null) {
            return root;
        }
        sumOfTree(root);
        return MIN_SUB;
    }

    private int sumOfTree (TreeNode node) {
        int sum = Integer.MAX_VALUE;
        if (node == null) {
            sum = 0;
        }
        if (node.left == null && node.right == null) {
            sum = node.val;
        }
        if (node.left != null && node.right == null) {
            sum = sumOfTree(node.left) + node.val;
        }
        if (node.left == null && node.right != null) {
            sum = sumOfTree(node.right) + node.val;
        }
        if (node.left != null && node.right != null) {
            sum = sumOfTree(node.left) + sumOfTree(node.right) + node.val;
        }
        if (this.MIN_SUM > sum) {
            this.MIN_SUM = sum;
            this.MIN_SUB = node;
//            System.out.println("this.MIN_SUM: " + this.MIN_SUM);
        }
        return sum;
    }

    public void reset () {
        this.MIN_SUM = Integer.MAX_VALUE;
        this.MIN_SUB = null;
    }

    public static void main(String[] args) {
        MinimumSubtree instance = new MinimumSubtree();
        if (1 == 1) {
            TreeNode root = new TreeNode(1);

            TreeNode node_1a = new TreeNode(5);
            TreeNode node_1b = new TreeNode(2);

            TreeNode node_2a = new TreeNode(-1);
//        TreeNode node_1b = new TreeNode(4);
            TreeNode node_2c = new TreeNode(-4);
            TreeNode node_2d = new TreeNode(-5);

            root.left = node_1a;
            root.right = node_1b;
            node_1a.left = node_2a;
            node_1b.left = node_2c;
            node_1b.right = node_2d;
/**
 *  *         1
 *  *        / \
 *  *       5    2
 *  *     /    / \
 *  *    -1   -4  -5
 */
            System.out.println(instance.findSubtree(root).val); //Expects 2
            instance.reset();
        }
        if (1 == 1) {
            TreeNode root = new TreeNode(1);

            TreeNode node_1a = new TreeNode(-5);
            TreeNode node_1b = new TreeNode(2);

            TreeNode node_2a = new TreeNode(1);
            TreeNode node_2b = new TreeNode(2);
            TreeNode node_2c = new TreeNode(-4);
            TreeNode node_2d = new TreeNode(-5);

            root.left = node_1a;
            root.right = node_1b;
            node_1a.left = node_2a;
            node_1a.right = node_2b;
            node_1b.left = node_2c;
            node_1b.right = node_2d;
/**
 *  *          1
 *  *        /  \
 *  *      -5    2
 *  *     / \    / \
 *  *    1   2 -4  -5
 */
            System.out.println(instance.findSubtree(root).val); //Expects 1
        }
    }
}
