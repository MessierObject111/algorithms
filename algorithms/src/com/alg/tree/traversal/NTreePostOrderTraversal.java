package com.alg.tree.traversal;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
public class NTreePostOrderTraversal {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        helper(root, list);
        return list;
    }

    private void helper(Node node, List<Integer> list) {
        if(node == null) return;
        List<Node> children = node.children;
        children.forEach(n->{
            helper(n, list);
        });
        list.add(node.val);
    }
}
