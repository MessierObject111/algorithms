package com.companies.meta;
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

import java.util.HashSet;
import java.util.Set;

/**
 * 1650. Lowest Common Ancestor of a Binary Tree III
 * Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).
 *
 * Each node will have a reference to its parent node. The definition for Node is below:
 *
 * class Node {
 *     public int val;
 *     public Node left;
 *     public Node right;
 *     public Node parent;
 * }
 * According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a tree T is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)."
 *
 *
 */
public class LowestCommonAncestorofBinaryTreeIII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    public Node lowestCommonAncestor(Node p, Node q) {
        Node lca = null;
        Set<Node> set = new HashSet<>();
        while(p != null || q != null) {
            if(p != null) {
                if(set.contains(p)) {
                    lca = p;
                    break;
                } else {
                    set.add(p);
                }
                p = p.parent;
            }

            if(q != null) {
                if(set.contains(q)) {
                    lca = q;
                    break;
                } else {
                    set.add(q);
                }
                q = q.parent;
            }

        }
        return lca;
    }
}
