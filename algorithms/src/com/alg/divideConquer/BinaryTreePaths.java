package com.alg.divideConquer;

import com.alg.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Example 1:
 *
 * Input：{1,2,3,#,5}
 * Output：["1->2->5","1->3"]
 * Explanation：
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * Example 2:
 *
 * Input：{1,2}
 * Output：["1->2"]
 * Explanation：
 *    1
 *  /
 * 2
 */
public class BinaryTreePaths {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        ArrayList<String> list = new ArrayList<>();
        if (root == null) return list;
        traverse (root, list, "");
        return list;
    }

    private void traverse (TreeNode node, ArrayList<String> list, String path) {
        if (node.left == null && node.right == null) {
            String finalPath = path + Integer.toString(node.val);
            list.add(finalPath);
            return;
        }
        if (node.left != null) {
            traverse(node.left, list, path + Integer.toString(node.val) + "->");
        }
        if (node.right != null) {
            traverse(node.right, list, path + Integer.toString(node.val) + "->");
        }
    }

    public static void main(String[] args) {
        BinaryTreePaths instance = new BinaryTreePaths();
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
        List<String> result = instance.binaryTreePaths(root);
        for(String path : result) {
            System.out.println(path);
        }
    }
}
