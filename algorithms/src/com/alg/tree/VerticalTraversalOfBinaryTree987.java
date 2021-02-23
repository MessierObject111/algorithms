package com.alg.tree;

import com.alg.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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
class PriorityNode implements Comparable<PriorityNode>{
    int leftIndex;
    int downIndex;
    int val;
    public PriorityNode (){};
    public PriorityNode (int left, int down, int val){
        this.leftIndex = left;
        this.downIndex = down;
        this.val = val;
    };
    @Override
    public int compareTo(PriorityNode node) {
        if(leftIndex == node.leftIndex) {
            if(downIndex == node.downIndex) {
                return val - node.val;
            }
            return downIndex - node.downIndex;
        }
        return leftIndex - node.leftIndex;
    }
}
class VerticalTraversalOfBinaryTree {
    PriorityQueue<PriorityNode> queue = new PriorityQueue<>();
    private int leftMost = 0;
    private int rightMost = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int leftIndex = 0;
        int downIndex = 0;
        int val = root.val;
        queue.offer(new PriorityNode(leftIndex, downIndex, val));
        recurse(root.left, (leftIndex - 1), downIndex + 1);
        recurse(root.right, (leftIndex + 1), downIndex + 1);
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> negativeList = new ArrayList<>(Math.abs(leftMost) + 1);
        List<List<Integer>> positiveList = new ArrayList<>(rightMost + 1);

        for(int i = 0; i < Math.abs(leftMost) + 1; i++) {
            negativeList.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < Math.abs(rightMost) + 1; i++) {
            positiveList.add(new ArrayList<Integer>());
        }

        while(!queue.isEmpty()) {
            PriorityNode node = queue.poll();
            int left = node.leftIndex;
            int down = node.downIndex;
            int nodeVal = node.val;

            List<Integer> list;
            if(left < 0) {
                list = negativeList.get(-left);

            } else {
                list = positiveList.get(left);
            }
            list.add(nodeVal);
        }
        for(int i = negativeList.size() - 1; i >= 0; i--) {
            if(!negativeList.get(i).isEmpty()) result.add(negativeList.get(i));
        }
        for(int i = 0; i < positiveList.size(); i++) {
            if(!positiveList.get(i).isEmpty()) result.add(positiveList.get(i));
        }
        return result;
    }

    private void recurse(TreeNode node, int left, int down) {
        if(node == null) return;
        int val = node.val;
        queue.offer(new PriorityNode(left, down, val));
        leftMost = Math.min(leftMost, left);
        rightMost = Math.max(rightMost, left);
        System.out.println("Node val:" + val + " leftInd: " + left + " downInd: "+ down + " leftMost: "+ leftMost + " rightMost: " + rightMost);
        recurse(node.left, (left - 1), down + 1);
        recurse(node.right, (left + 1), down + 1);
    }

    public static void main(String[] args) {
        VerticalTraversalOfBinaryTree s = new VerticalTraversalOfBinaryTree();

        TreeNode root = new TreeNode(1);
        TreeNode node_1 = new TreeNode(0);
        TreeNode node_2 = new TreeNode(3);
        TreeNode node_3 = new TreeNode(2);
        TreeNode node_4 = new TreeNode(4);
//        TreeNode node_5 = new TreeNode(4);
//        TreeNode node_6 = new TreeNode(-2);

        root.left = node_1;
        root.right = node_2;
        node_2.left = node_3;
        node_2.right = node_4;
//        node_2.left = node_5;
//        node_2.right = node_6;

        List<List<Integer>> result = s.verticalTraversal(root);
        System.out.println();

    }
}