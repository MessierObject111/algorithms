package com.alg.tree.traversal;
import com.alg.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-preorder-traversal/description/
public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        helper(root, list);
        return list;
    }

    private void helper(TreeNode node, List<Integer> list){
        if(node!=null) {
            list.add(node.val);
            helper(node.left, list);
            helper(node.right, list);
        }
    }
}
