package com.alg.divideConquer;

import com.alg.common.TreeNode;

import java.math.BigInteger;
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

    //After 5 years, I forgot everything about the original solution which use vertical-order traversal to judge if this is BST
    // I came up with a solution that use DFS, which use less memory
    public boolean isValidBSTIII(TreeNode root) {
        BigInteger bLeft = new BigInteger(String.valueOf(Integer.MIN_VALUE)).subtract(BigInteger.valueOf(1));
        BigInteger bRight = new BigInteger(String.valueOf(Integer.MAX_VALUE)).add(BigInteger.valueOf(1));
        boolean left = root.left == null ? true : dfs(root.left, bLeft, new BigInteger(String.valueOf(root.val)));
        boolean right = root.right == null ? true :dfs(root.right, new BigInteger(String.valueOf(root.val)), bRight);
        return left && right;
    }
    // Asking for Binary Search Tree, not 'Balanced' BST! 2022-08-28
    private boolean dfs(TreeNode node, BigInteger min, BigInteger max) {
        //If current value does not fall into the range, return false immediately
        System.out.println("********************** node: " + node.val + " range: " + min.toString() + " - " + max.toString());
        if(min.compareTo(new BigInteger(String.valueOf(node.val))) < 0 && max.compareTo(new BigInteger(String.valueOf(node.val))) > 0) {
            //If current node is a leaf, return true
            if(node.left == null && node.right == null) {
                System.out.println("Leaf: " + node.val);
                return true;
            } else {
                boolean l = true; boolean r = true;
                if(node.left != null) {
                    System.out.println("Going left: ") ;
                    l = dfs(node.left, min, new BigInteger(String.valueOf(node.val)));
                }
                if(node.right != null) {
                    System.out.println("Going right: ") ;
                    r = dfs(node.right, new BigInteger(String.valueOf(node.val)), max);
                }
                return l && r;
            }

        }
        System.out.println("Return false: " + node.val + " range: " + min.toString() + " - " + max.toString());
        return false;
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
        System.out.println(instance.isValidBSTIII(root));//Expects True

        BigInteger one = new BigInteger(String.valueOf(1));
        BigInteger two = new BigInteger(String.valueOf(2));
        System.out.println(one.compareTo(two));
    }
}
