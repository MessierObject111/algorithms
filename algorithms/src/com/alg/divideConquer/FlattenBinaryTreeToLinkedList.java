package com.alg.divideConquer;

import com.alg.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Flatten a binary tree to a fake "linked list" in pre-order traversal.
 *
 * Here we use the right pointer in TreeNode as the next pointer in ListNode.
 * Example 1:
 *
 * Input:{1,2,5,3,4,#,6}
 * Output：{1,#,2,#,3,#,4,#,5,#,6}
 * Explanation：
 *      1
 *     / \
 *    2   5
 *   / \   \
 *  3   4   6
 *
 * 1
 * \
 *  2
 *   \
 *    3
 *     \
 *      4
 *       \
 *        5
 *         \
 *          6
 * Example 2:
 *
 * Input:{1}
 * Output:{1}
 * Explanation：
 *          1
 *          1
 */
public class FlattenBinaryTreeToLinkedList {
    /**
     * This method uses a separate list to store the nodes while doing pre-order-traversing; removes all sub-tree once
     * current recursion is finished.
     * Then, it appends all the nodes to root.right in loop until all nodes in list is used.
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        LinkedList<TreeNode> list = new LinkedList<>();
        if(root == null) return;
        traverse (root, list);
        TreeNode start = root;
        TreeNode node = list.poll();
        while (node != null) {
            if(start.equals(node)) {
                node = list.poll();
                continue;
            }
            start.right = node;
            start = start.right;
            node = list.poll();
        }
    }

    private void traverse (TreeNode node, List<TreeNode> list) {
        if (node != null) {
            list.add(node);
        }
        if (node.left != null) {
            traverse(node.left, list);
            node.left = null;
        }
        if (node.right != null) {
            traverse(node.right, list);
            node.right = null;
        }
    }

    private TreeNode lastNode = null;

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        TreeNode right = root.right;
        flatten2(root.left);
        flatten2(right);
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
        FlattenBinaryTreeToLinkedList instance = new FlattenBinaryTreeToLinkedList();
        TreeNode target = root;
        instance.flatten2(target);
        while (target != null) {
            System.out.println(target.val);
            target = target.right;
        }
    }
}
