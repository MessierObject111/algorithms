package com.alg.tree;

import com.alg.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenBinaryTreeToLinkedList {
    public static TreeNode root;
    static {
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

        root = node_1;
    }

    public void flatten(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        traverse(root, queue);
        TreeNode start = queue.poll();
        TreeNode current;
        while(!queue.isEmpty()) {
            current = queue.poll();
            start.left = null;
            current.left = null;
            start.right = current;
            start = current;
        }
    }

    public void traverse(TreeNode root, Queue queue) {
        queue.offer(root);
        if(root.left != null) {
            traverse(root.left, queue);
        }
        if(root.right != null) {
            traverse(root.right, queue);
        }
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList solution = new FlattenBinaryTreeToLinkedList();
        solution.flatten(root);
        while(root != null) {
            System.out.println(root.val);
            root= root.right;
        }
        System.out.println("Finished");
    }
}
