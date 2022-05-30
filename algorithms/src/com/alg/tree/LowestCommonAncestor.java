package com.alg.tree;

import com.alg.common.TreeNode;

import java.util.*;

/**
 * 88. Lowest Common Ancestor of a Binary Tree
 * Divide & Conquer
 *
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 *
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 * Example 1:
 *
 * Input：{1},1,1
 * Output：1
 * Explanation：
 *  For the following binary tree（only one node）:
 *          1
 *  LCA(1,1) = 1
 * Example 2:
 *
 * Input：{4,3,7,#,#,5,6},3,5
 * Output：4
 * Explanation：
 *  For the following binary tree:
 *
 *       4
 *      / \
 *     3   7
 *        / \
 *       5   6
 *
 *  LCA(3, 5) = 4
 */
public class LowestCommonAncestor {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        //Return A if the children of root contains A, return B if they contain B, returns null if none of them.
        if (root == null || root == A || root == B) {
            return root;
        }
        //Divide
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        //Conquer
        if(left != null && right != null) {
            return root;
        }
        if(left != null && right == null) {
            return left;
        }
        if(left == null & right != null) {
            return right;
        }
        return null;

    }

    /**
     * 2022-05-16 Attempted again, have zero idea of the answer I did before and had to read answer for O(N) solution :(
     * When thinking about recursive functions to calculate sum/find a target etc,
     * Consider the possibility of having a global object to store the result.
     **/
    //Solution 2 ==================================================================
    private TreeNode ans;

    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        search(root, p, q);
        return ans;
    }

    private boolean search(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) return false;
        boolean left = search(node.left, p, q);
        boolean right = search(node.right, p, q);
        if(node == p || node == q || left || right) {
            if( (left && right) ||
                    (left && node == p) ||
                    (left && node == q) ||
                    (right && node == p) ||
                    (right && node == q)) {
                ans = node;
            }
            return true;
        }
        return false;
    }
    //=======================================

    //Solution 3 ==================================================================
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        //Traverse by level: hold each level's nodes
        Deque<TreeNode> stack = new ArrayDeque<>();
        //Map to keep track of each node's parent node
        Map<TreeNode, TreeNode> map = new HashMap<>();

        stack.push(root);
        map.put(root, null);


        //When existing parent map does not contain both p & q, keep drilling until it does
        while(!(map.containsKey(p) && map.containsKey(q))) {
            TreeNode node = stack.pop();

            if(node.left != null) {
                map.put(node.left, node);
                stack.push(node.left);
            }

            if(node.right != null) {
                map.put(node.right, node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> set = new HashSet<TreeNode>();
        set.add(p);
        TreeNode pParent = p;
        while(pParent != null) {
            set.add(pParent);
            pParent = map.get(pParent);
        }

        TreeNode qParent = q;
        while(!set.contains(qParent)) {
            qParent = map.get(qParent);
        }

        return qParent;
    }

    public static void main(String[] args) {
        LowestCommonAncestor instance = new LowestCommonAncestor();
        //==================Test Case 1=====================
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
        System.out.println(instance.lowestCommonAncestor3(node_1, node_5, node_7).val);//-1 expected;

        //==================Test Case 2=====================
        TreeNode tc2_root = new TreeNode(1);
        TreeNode tc2_left = new TreeNode(2);

        tc2_root.left = tc2_left;

        System.out.println(instance.lowestCommonAncestor3(tc2_root, tc2_left, tc2_root).val);//1 expected;
    }
}
