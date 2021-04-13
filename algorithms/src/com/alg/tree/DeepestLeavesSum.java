package com.alg.tree;

import com.alg.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<TreeNode>> levels = new ArrayList<>();

        q.offer(root);
        int size = q.size();

        while(!q.isEmpty()) {
            List<TreeNode> currentLevelNodes = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();// Not pop()
                currentLevelNodes.add(node);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            levels.add(currentLevelNodes);
            size = q.size();
        }
        int numOfLevels = levels.size();
        System.out.println(numOfLevels);
        List<TreeNode> lastLevelNodes = levels.get(numOfLevels - 1);
        int sum = lastLevelNodes.stream().mapToInt(e->e.val).sum();
        return sum;
    }

    public static void main(String[] args) {
        DeepestLeavesSum sol = new DeepestLeavesSum();
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_6 = new TreeNode(6);

        node_1.left = node_2;
        node_1.right = node_5;
        node_2.left = node_3;
        node_2.right = node_4;
        node_5.right = node_6;

        TreeNode root = node_1;
        System.out.println(sol.deepestLeavesSum(root));
    }
}
