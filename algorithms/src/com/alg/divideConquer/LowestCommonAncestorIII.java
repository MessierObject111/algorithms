package com.alg.divideConquer;

import com.alg.common.TreeNode;

/**
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 * Return null if LCA does not exist.
 *
 * Example1
 *
 * Input:
 * {4, 3, 7, #, #, 5, 6}
 * 3 5
 * 5 6
 * 6 7
 * 5 8
 * Output:
 * 4
 * 7
 * 7
 * null
 * Explanation:
 *   4
 *  / \
 * 3   7
 *    / \
 *   5   6
 *
 * LCA(3, 5) = 4
 * LCA(5, 6) = 7
 * LCA(6, 7) = 7
 * LCA(5, 8) = null
 *
 * Example2
 *
 * Input:
 * {1}
 * 1 1
 * Output:
 * 1
 * Explanation:
 * The tree is just a node, whose value is 1.
 */
public class LowestCommonAncestorIII {
    private static final String NONE = "NONE";
    private static final String A = "A";
    private static final String B = "B";
//    private static final String BOTH = "BOTH";

    private TreeNode ancestor = null;
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        find(root, A, B);
        return this.ancestor;
    }

    private String find (TreeNode node, TreeNode A, TreeNode B) {
        if (node == null) {
            return this.NONE;
        }

        String left = find(node.left, A, B);
        String right = find(node.right, A, B);

        if((left == this.A && right == this.B) ||
                (left == this.B && right == this.A) ||
                (node == A && (left == this.B || right == this.B)) ||
                (node == B && (left == this.A || right == this.A))) {
            this.ancestor = node;
        }
        if(node == A || left == this.A || right == this.A) {
            return this.A;
        }
        if(node == B || left == this.B || right == this.B) {
            return this.B;
        }
        return this.NONE;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode node_1a = new TreeNode(4);
        TreeNode node_1b = new TreeNode(9);

        TreeNode node_2a = new TreeNode(2);
        TreeNode node_2b = new TreeNode(4);
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
        LowestCommonAncestorIII instance = new LowestCommonAncestorIII();
        System.out.println(instance.lowestCommonAncestor3(root, node_2c, node_2b) == null);//Expects 9
    }
}
