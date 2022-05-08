package com.alg.tree;
//https://leetcode.com/problems/find-leaves-of-binary-tree/

import com.alg.common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        TreeNode pseudoRoot = new TreeNode(0);
        pseudoRoot.left = root;
        List<List<Integer>> res = new ArrayList<>();
        while(pseudoRoot.left != null) {
            List<Integer> curLeaves = dfs(pseudoRoot, root, true);
            res.add(curLeaves);
        }
        return res;
    }

    private List<Integer> dfs(TreeNode parent, TreeNode node, boolean isLeft) {
        List<Integer> curLeaves = new ArrayList<>();
        if(node.left == null && node.right == null) {
            curLeaves.add(node.val);
            if(isLeft) {
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        if(node.left != null) {
            curLeaves.addAll(dfs(node, node.left, true));
        }
        if(node.right != null) {
            curLeaves.addAll(dfs(node, node.right, false));
        }
        return curLeaves;
    }

    public static void main(String[] args) {
        FindLeavesOfBinaryTree366 sol = new FindLeavesOfBinaryTree366();
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

        List<List<Integer>> res = sol.findLeaves(root);
        res.stream().forEach(level -> {
            level.stream().forEach(ele -> {
                System.out.print(ele + ", ");
            });
            System.out.println();
        });
    }
}
