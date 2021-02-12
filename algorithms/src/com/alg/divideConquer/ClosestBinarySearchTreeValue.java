package com.alg.divideConquer;

import com.alg.common.TreeNode;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Example
 * Example1
 *
 * Input: root = {5,4,9,2,#,8,10} and target = 6.124780
 * Output: 5
 * Explanation：
 * Binary tree {5,4,9,2,#,8,10},  denote the following structure:
 *         5
 *        / \
 *      4    9
 *     /    / \
 *    2    8  10
 * Example2
 *
 * Input: root = {3,2,4,1} and target = 4.142857
 * Output: 4
 * Explanation：
 * Binary tree {3,2,4,1},  denote the following structure:
 *      3
 *     / \
 *   2    4
 *  /
 * 1
 */
public class ClosestBinarySearchTreeValue {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */

    public int closestValue(TreeNode root, double target) {
        // write your code here
        if (root == null) {
            return 0;
        }

        TreeNode closestLow = lowerBound(root, target);
        TreeNode closestHigh = upperBound(root, target);
        if(closestLow == null) {
            return closestHigh.val;
        }
        if(closestHigh == null) {
            return closestLow.val;
        }
        if(target - closestLow.val > closestHigh.val - target) {
            return closestHigh.val;
        }
        return closestLow.val;

    }

    /**
     * FIND THE biggest node that is smaller than target.
     * @param node
     * @param target
     * @return
     */
    private TreeNode lowerBound (TreeNode node, double target) {
        /*
        The reason why the null check happens inside the function call, rather than checking if branch is null before
        calling?
         */
        if (node == null) {
            return null;
        }

        if (target <= node.val) {
            if (node.left != null) return lowerBound(node.left, target);
            if (node.left == null) return null;
        }
        if (node.val < target) {
            TreeNode lowerNode = lowerBound(node.right, target);
            if (lowerNode != null) {
                return lowerNode;
            }
        }

        return node;
    }

    /**
     * Find the smallest node that is bigger than target.
     * @param node
     * @param target
     * @return
     */
    private TreeNode upperBound (TreeNode node, double target) {
        if (node == null) {
            return null;
        }

        if (node.val < target) {
            if(node.right != null) return upperBound(node.right, target);
            if (node.right == null) return null;
        }

        if (node.val >= target) {
            TreeNode upperNode = upperBound(node.left, target);
            if (upperNode != null) {
                return upperNode;
            }
        }
        return node;
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
        ClosestBinarySearchTreeValue instance = new ClosestBinarySearchTreeValue();
        System.out.println(instance.closestValue(root, 6.12));//Expects 5
    }

}
