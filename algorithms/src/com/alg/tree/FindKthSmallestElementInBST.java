package com.alg.tree;

import com.alg.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. Kth Smallest Element in a BST
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the
 * values of the nodes in the tree.
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 *
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth
 * smallest frequently, how would you optimize?
 *
 * Answer: Use LinkedList instead of ArrayList?
 *
 */

public class FindKthSmallestElementInBST {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            // We need to do a in-order traversal to print all the node in ordered manner
            if(root == null) return 0;
            List<Integer> list = new ArrayList<>();
            inOrderTraversal(root, list);
            return list.get(k-1);
        }

        private void inOrderTraversal(TreeNode node, List<Integer> list) {
            if(node.left != null) inOrderTraversal(node.left, list);
            list.add(node.val);
            if(node.right != null) inOrderTraversal(node.right, list);
        }
    }
}
