package com.alg.divideConquer;

import com.alg.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class ValidateBinarySearchTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        traverse(root, list);
        TreeNode temp = list.poll();
        while(!list.isEmpty()) {
            TreeNode current = list.poll();
            if (temp.val >= current.val) {
                return false;
            }
            temp = current;
        }
        return true;
    }

    /**
     * Do an in-order-traversal for the tree and add nodes to a list; if the tree is a BST, the list will be sorted.
     * Note it only checks if it is BST, not if it is a balanced BST.
     * @param node
     * @param list
     */
    private void traverse (TreeNode node, List<TreeNode> list) {

        if (node.left != null) {
            traverse(node.left, list);
        }
        if (node != null) {
//            System.out.println(node.val);
            list.add(node);
        }
        if (node.right != null) {
            traverse(node.right, list);
        }
    }

    public boolean isValidBSTDivideConquer(TreeNode root) {
        return divideConquer(root).isBST;
    }

    class ResultType {
        public boolean isBST;
        public TreeNode maxNode, minNode;
        public ResultType(boolean isBST) {
            this.isBST = isBST;
            this.maxNode = null;
            this.minNode = null;
        }
    }
    private ResultType divideConquer(TreeNode node) {
        if (node == null) {
            return new ResultType(true);
        }

        ResultType left = divideConquer(node.left);
        ResultType right = divideConquer(node.right);
        if (!left.isBST || !right.isBST) {
            return new ResultType(false);
        }

        if (left.maxNode != null && left.maxNode.val >= node.val) {
            return new ResultType(false);
        }

        if (right.minNode != null && right.minNode.val <= node.val) {
            return new ResultType(false);
        }

        // is bst
        ResultType result = new ResultType(true);
        result.minNode = left.minNode != null ? left.minNode : node;
        result.maxNode = right.maxNode != null ? right.maxNode : node;

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode node_1a = new TreeNode(4);
        TreeNode node_1b = new TreeNode(9);

        TreeNode node_2a = new TreeNode(2);

        TreeNode node_2c = new TreeNode(8);
        TreeNode node_2d = new TreeNode(10);

        TreeNode node_3a = new TreeNode(1);
        TreeNode node_3b = new TreeNode(3);
        TreeNode node_3c = new TreeNode(6);
        TreeNode node_3d = new TreeNode(7);

        root.left = node_1a;
        root.right = node_1b;
        node_1a.left = node_2a;
        node_1b.left = node_2c;
        node_1b.right = node_2d;
        node_2a.left = node_3a;
        node_2a.right = node_3b;
        node_2c.left = node_3c;
//        node_2c.right = node_3d;

/**
 *  *         5
 *  *        /  \
 *  *      4     9
 *  *     /     / \
 *  *    2     8  10
 *      / \   / \
 *     1   3 6   7
 */
        ValidateBinarySearchTree instance = new ValidateBinarySearchTree();
        System.out.println(instance.isValidBST(root));//Expects True
    }
}
