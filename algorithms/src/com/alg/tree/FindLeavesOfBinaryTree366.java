package com.alg.tree;
//https://leetcode.com/problems/find-leaves-of-binary-tree/

import com.alg.common.TreeNode;
import com.java.se.inheritancePolymorphism.question9.A;

import java.util.*;

public class FindLeavesOfBinaryTree366 {

    //First attempt O(N^2)
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

    //Optimized to O(N)
    public List<List<Integer>> findLeaves2(TreeNode root) {
        //Can I use an array list directly and insert on random indexes, or do I have to use Map here?
        //Answer: I have to use Map<Integer, List<Integer>> here because list.get(n) will throw error when list.size()<n

        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs2(root, map);
        List<List<Integer>> res = new ArrayList<>(map.size());
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            res.add(entry.getKey(), entry.getValue());
        };

        return res;
    }

    private int dfs2(TreeNode node, Map<Integer, List<Integer>> map) {
        if(node.left == null && node.right == null) {
            List<Integer> list ;
            if(map.size() == 0) {
                list = new ArrayList<>();
                list.add(node.val);
                map.put(0, list);
            } else {
                list = map.get(0);
                list.add(node.val);
            }
            return 0;
        }
        int left_level = 0;
        int right_level = 0;
        if (node.left != null) {
            left_level = dfs2(node.left, map);
        }
        if (node.right != null) {
            right_level = dfs2(node.right, map);
        }
        int current_level = Math.max(left_level, right_level) + 1;
        List<Integer> list;
        if(map.get(current_level) == null) {
            list = new ArrayList<>();
            list.add(node.val);
            map.put(current_level, list);
        } else {
            list = map.get(current_level);
            list.add(node.val);
        }

        return current_level;
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

        List<List<Integer>> res = sol.findLeaves2(root);
        res.stream().forEach(level -> {
            level.stream().forEach(ele -> {
                System.out.print(ele + ", ");
            });
            System.out.println();
        });

        //Expected answer:
        //3, 4, 6,
        //2, 5,
        //1,
    }
}
