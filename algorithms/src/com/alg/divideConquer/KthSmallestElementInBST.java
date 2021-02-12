package com.alg.divideConquer;

import com.alg.common.TreeNode;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Example 1:
 *
 * Input：{1,#,2},2
 * Output：2
 * Explanation：
 * 	1
 * 	 \
 * 	  2
 * The second smallest element is 2.
 * Example 2:
 *
 * Input：{2,1,3},1
 * Output：1
 * Explanation：
 *   2
 *  / \
 * 1   3
 * The first smallest element is 1.
 * Challenge
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How
 * would you optimize the kthSmallest routine?
 */
public class KthSmallestElementInBST {
    private TreeNode kthElement = null;
    private int index = 0;
    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        // In-order traversal will iterate through the BST by ascending order
        int counter = 0;
        traverse(root, k);
        return this.kthElement.val;
    }

    private void traverse (TreeNode node, int k) {
        if (node == null) {
            return;
        }
        traverse(node.left, k);
//        System.out.println(node.val + " - " + this.index);
        this.index++;
        if (index == k) {
            this.kthElement = node;
        }
        traverse(node.right, k);
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
        KthSmallestElementInBST instance = new KthSmallestElementInBST();
        instance.traverse(root, 2);
        System.out.println(instance.kthElement.val);//Expects 4
    }
}
