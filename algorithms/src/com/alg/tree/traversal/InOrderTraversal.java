package com.alg.tree.traversal;

import com.alg.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/binary-tree-inorder-traversal/description/
public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        helper(root, list);
        return list;
    }

    private void helper(TreeNode node, List<Integer> list){
        if(node!=null) {
            helper(node.left, list);
            list.add(node.val);
            helper(node.right, list);
        }
    }
}
