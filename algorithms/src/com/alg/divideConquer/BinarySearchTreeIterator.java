package com.alg.divideConquer;

import com.alg.common.TreeNode;
//import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Design an iterator over a binary search tree with the following rules:
 *
 * Elements are visited in ascending order (i.e. an in-order traversal)
 * next() and hasNext() queries run in O(1) time in average.
 * Example
 * Example 1
 *
 * Input:  {10,1,11,#,6,#,12}
 * Output:  [1, 6, 10, 11, 12]
 * Explanation:
 * The BST is look like this:
 *   10
 *   /\
 *  1 11
 *   \  \
 *    6  12
 * You can return the inorder traversal of a BST [1, 6, 10, 11, 12]
 * Example 2
 *
 * Input: {2,1,3}
 * Output: [1,2,3]
 * Explanation:
 * The BST is look like this:
 *   2
 *  / \
 * 1   3
 * You can return the inorder traversal of a BST tree [1,2,3]
 * Challenge
 * Extra memory usage O(h), h is the height of the tree.
 *
 * Super Star: Extra memory usage O(1)
 */
public class BinarySearchTreeIterator {

    //TODO: I don't know what the hell this question is asking me to do
    public class BSTIterator {
        private Stack<TreeNode> stack = new Stack<>();
        /*
         * @param root: The root of binary tree.
         */public BSTIterator(TreeNode root) {
            // do intialization if necessary
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

//        private void traverse (TreeNode node, List<TreeNode> list) {
//            if (node.left != null) {
//                traverse(node.left, list);
//            }
//            list.add(node);
//            if(node.right != null) {
//                traverse(node.right, list);
//            }
//        }

        /*
         * @return: True if there has next node, or false
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /*
         * @return: return next node
         */
        public TreeNode next() {
            // write your code here
            TreeNode curt = stack.peek();
            TreeNode node = curt;

            // move to the next node
            if (node.right == null) {
                node = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            } else {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }

            return curt;
        }
    }
}
