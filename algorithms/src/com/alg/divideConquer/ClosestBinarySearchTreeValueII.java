package com.alg.divideConquer;

import com.alg.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 *
 * Example 1:
 *
 * Input:
 * {1}
 * 0.000000
 * 1
 * Output:
 * [1]
 * Explanation：
 * Binary tree {1},  denote the following structure:
 *  1
 * Example 2:
 *
 * Input:
 * {3,1,4,#,2}
 * 0.275000
 * 2
 * Output:
 * [1,2]
 * Explanation：
 * Binary tree {3,1,4,#,2},  denote the following structure:
 *   3
 *  /  \
 * 1    4
 *  \
 *   2
 * Challenge
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 */
public class ClosestBinarySearchTreeValueII {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> values = new ArrayList<>();

        traverse(root, values);

        int i = 0, n = values.size();
        for (; i < n; i++) {
            if (values.get(i) >= target) {
                break;
            }
        }

        if (i >= n) {
            return values.subList(n - k, n);
        }

        int left = i - 1, right = i;
        List<Integer> result = new ArrayList<>();
        for (i = 0; i < k; i++) {
            if (left >= 0 && (right >= n || target - values.get(left) < values.get(right) - target)) {
                result.add(values.get(left));
                left--;
            } else {
                result.add(values.get(right));
                right++;
            }
        }

        return result;
    }

    private void traverse(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }

        traverse(root.left, values);
        values.add(root.val);
        traverse(root.right, values);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode node_1a = new TreeNode(4);
        TreeNode node_1b = new TreeNode(9);

        TreeNode node_2a = new TreeNode(2);

        TreeNode node_2c = new TreeNode(8);
        TreeNode node_2d = new TreeNode(10);

        TreeNode node_3a = new TreeNode(1);
        TreeNode node_3b = new TreeNode(3);
        TreeNode node_3c = new TreeNode(6);
        TreeNode node_3d = new TreeNode(7);

        root.left = node_1a;
        root.right = node_1b;
        node_1a.left = node_2a;
        node_1b.left = node_2c;
        node_1b.right = node_2d;
        node_2a.left = node_3a;
        node_2a.right = node_3b;
        node_2c.left = node_3c;
//        node_2c.right = node_3d;

/**
 *  *         5
 *  *        /  \
 *  *      4     9
 *  *     /     / \
 *  *    2     8  10
 *      / \   / \
 *     1   3 6   7
 */
        ClosestBinarySearchTreeValueII instance = new ClosestBinarySearchTreeValueII();
        System.out.println(instance.closestKValues(root, 3.12, 3));//Expects True
    }
}
