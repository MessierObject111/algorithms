package com.alg.tree;

import com.alg.common.TreeNode;

import java.util.*;

public class KthLargestSunInBinaryTree {
    //Traverse binary tree by levels (and calculate each level's sum), then order the list of sums before
    //checking corner cases like k > number of sums. Note the k here starts by 1, so result should be list.get(k-1)
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> levels = new ArrayList<Long>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        helper(queue, levels);
        if(levels.size() < k) return -1;
        Collections.sort(levels, Collections.reverseOrder());
        return levels.get(k - 1);
    }

    private void helper(Queue<TreeNode> queue, List<Long> levels) {
        long listSum = 0;
        Queue<TreeNode> children = new LinkedList<TreeNode>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            listSum += node.val;
            if(node.left != null) children.add(node.left);
            if(node.right != null) children.add(node.right);
        }
        levels.add(listSum);
        if(!children.isEmpty()) helper(children, levels);
    }

    public static void main(String[] args) {

        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_6 = new TreeNode(6);
        TreeNode node_7 = new TreeNode(7);
        TreeNode node_8 = new TreeNode(8);
        TreeNode node_9 = new TreeNode(9);
        TreeNode node_10 = new TreeNode(10);
        TreeNode node_11 = new TreeNode(11);
        TreeNode node_12 = new TreeNode(12);
        TreeNode node_13 = new TreeNode(13);
        TreeNode node_14 = new TreeNode(14);
        TreeNode node_15 = new TreeNode(15);
        TreeNode node_16 = new TreeNode(16);

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

        KthLargestSunInBinaryTree sol = new KthLargestSunInBinaryTree();
        long res = sol.kthLargestLevelSum(node_1, 2);
        System.out.println(res);
    }
}
