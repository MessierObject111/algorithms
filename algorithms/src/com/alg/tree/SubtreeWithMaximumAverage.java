package com.alg.tree;

import com.alg.common.TreeNode;


/**
 * 597. Subtree with Maximum Average
 * Given a binary tree, find the subtree with maximum average. Return the root of the subtree.
 * LintCode will print the subtree which root is your return node.
 * It's guaranteed that there is only one subtree with maximum average.
 *
 * Example 1
 *
 * Input：
 * {1,-5,11,1,2,4,-2}
 * Output：11
 * Explanation:
 * The tree is look like this:
 *      1
 *    /   \
 *  -5     11
 *  / \   /  \
 * 1   2 4    -2
 * The average of subtree of 11 is 4.3333, is the maximun.
 * Example 2
 *
 * Input：
 * {1,-5,11}
 * Output：11
 * Explanation:
 *      1
 *    /   \
 *  -5     11
 * The average of subtree of 1,-5,11 is 2.333,-5,11. So the subtree of 11 is the maximun.
 *
 */
public class SubtreeWithMaximumAverage {
    // 2020-04-26
    // Apparently we need to calculate this from bottom up, first the lower
    // levels' average, then add them up to top.
    // Then we need to use DFS
    // Which means recursion - I wrote this and failed 3-4 times before
    // making it buig-free.
    // At first I didn't consider null case. Then the result from dividing
    // integers are integers even if I put double in front of result :
    // Double result = A/B; Had to defined double A = double first.
    // Then the Double.MIN_VALUE is not what I thought.
    /**
     * Definition of TreeNode:
     * public class TreeNode {
     *     public int val;
     *     public TreeNode left, right;
     *     public TreeNode(int val) {
     *         this.val = val;
     *         this.left = this.right = null;
     *     }
     * }
     */

    private TreeNode MAX_NODE;
    private double MAX_AVERAGE;

    public SubtreeWithMaximumAverage() {
        MAX_NODE = new TreeNode(0);
        MAX_AVERAGE = Integer.MIN_VALUE;
    }

    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        if (root == null ) return null;
        MAX_NODE.val = Integer.MIN_VALUE;
        averageValue(root);
        return MAX_NODE;
    }

    public int[] averageValue (TreeNode node) {

        if(node.left != null && node.right == null) {
            int[] leftResult = averageValue(node.left);
            int leftSum = leftResult[0];
            int leftCount = leftResult[1];
            double sum = leftSum + node.val;
            int count = leftCount+1;
            double average = sum/count;
            if (average > MAX_AVERAGE) {
                this.MAX_AVERAGE = average;
                this.MAX_NODE = node;
            }
            int[] result = {(int)sum, count};
            return result;
        }
        if(node.left == null && node.right != null) {
            int[] rightResult = averageValue(node.right);
            int rightSum = rightResult[0];
            int rightCount = rightResult[1];
            double sum = rightSum + node.val;
            int count = rightCount+1;
            double average = sum/count;
            if (average > MAX_AVERAGE) {
                this.MAX_AVERAGE = average;
                this.MAX_NODE = node;
            }
            int[] result = {(int)sum, count};
            return result;
        }
        if(node.left != null && node.right != null) {
            int[] leftResult = averageValue(node.left);
            int leftSum = leftResult[0];
            int leftCount = leftResult[1];

            int[] rightResult = averageValue(node.right);
            int rightSum = rightResult[0];
            int rightCount = rightResult[1];

            double sum = leftSum + rightSum + node.val;
            int count = leftCount + rightCount + 1;
            double average = sum/count;
            if (average > MAX_AVERAGE) {
                this.MAX_AVERAGE = average;
                this.MAX_NODE = node;
            }
            int[] result = {(int)sum, count};
            return result;
        }

//        if (node.left == null && node.right == null)
        double average = node.val;
        if (average > MAX_AVERAGE) {
            this.MAX_AVERAGE = average;
            this.MAX_NODE = node;
        }
        int[] result = {node.val, 1};
        return result;
    }

    public static void main(String[] args) {
        SubtreeWithMaximumAverage instance = new SubtreeWithMaximumAverage();
        /**
         * {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10,-11,-12,-13,-14,-15,-16}
         * Output
         * {-2147483648}
         * Expected
         * {-2,-4,-5,-8,-9,-10,-11,-16}
         */
//        TreeNode root = new TreeNode(1);
//        TreeNode node_1 = new TreeNode(-5);
//        TreeNode node_2 = new TreeNode(11);
//        TreeNode node_3 = new TreeNode(1);
//        TreeNode node_4 = new TreeNode(2);
//        TreeNode node_5 = new TreeNode(4);
//        TreeNode node_6 = new TreeNode(-2);

//        root.left = node_1;
//        root.right = node_2;
//        node_1.left = node_3;
//        node_1.right = node_4;
//        node_2.left = node_5;
//        node_2.right = node_6;



        TreeNode node_1 = new TreeNode(-1);
        TreeNode node_2 = new TreeNode(-2);
        TreeNode node_3 = new TreeNode(-3);
        TreeNode node_4 = new TreeNode(-4);
        TreeNode node_5 = new TreeNode(-5);
        TreeNode node_6 = new TreeNode(-6);
        TreeNode node_7 = new TreeNode(-7);
        TreeNode node_8 = new TreeNode(-8);
        TreeNode node_9 = new TreeNode(-9);
        TreeNode node_10 = new TreeNode(-10);
        TreeNode node_11 = new TreeNode(-11);
        TreeNode node_12 = new TreeNode(-12);
        TreeNode node_13 = new TreeNode(-13);
        TreeNode node_14 = new TreeNode(-14);
        TreeNode node_15 = new TreeNode(-15);
        TreeNode node_16 = new TreeNode(-16);

        node_1.left = node_2;
        node_1.right = node_3;
        node_2.left = node_4;
        node_2.right = node_5;
        node_3.left = node_6;
        node_3.right = node_7;
        node_4.left = node_8;
        node_4.right = node_9;
        node_5.left = node_10;
        node_5.right = node_11;
        node_6.left = node_12;
        node_6.right = node_13;
        node_7.left = node_14;
        node_7.right = node_15;
        node_8.left = node_16;



        TreeNode result = instance.findSubtree2(node_1);
        System.out.println(result.val);

    }
}
