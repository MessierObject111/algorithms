package com.alg.bfs;

import com.alg.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * Example 1:
 *
 * Input：{1,2,3}
 * Output：[[1],[2,3]]
 * Explanation：
 *   1
 *  / \
 * 2   3
 * it will be serialized {1,2,3}
 * level order traversal
 * Example 2:
 *
 * Input：{1,#,2,3}
 * Output：[[1],[2],[3]]
 * Explanation：
 * 1
 *  \
 *   2
 *  /
 * 3
 * it will be serialized {1,#,2,3}
 * level order traversal
 * Challenge
 * Challenge 1: Using only 1 queue to implement it.
 *
 * Challenge 2: Use BFS algorithm to do it.
 *
 * Notice
 * The first data is the root node, followed by the value of the left and right son nodes, and "#" indicates that there is no child node.
 * The number of nodes does not exceed 20.
 * TODO: write it again
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList result = new ArrayList();

        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0 ; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal instance = new BinaryTreeLevelOrderTraversal();
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

        List<List<Integer>> result = instance.levelOrder(node_1);
        for(List<Integer> level : result) {
            for(Integer num : level) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
