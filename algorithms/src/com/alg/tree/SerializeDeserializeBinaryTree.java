package com.alg.tree;

import com.alg.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 */
public class SerializeDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        //Data type is int
        //method is public
        //speed is priority
        StringBuilder sb = new StringBuilder();

        return recurseSerialize(sb, root).toString();
    }

    private StringBuilder recurseSerialize(StringBuilder sb, TreeNode node) {
        if(node != null) {
            sb.append(node.val).append(",");
            recurseSerialize(sb, node.left);
            recurseSerialize(sb, node.right);
        } else {
            sb.append("null").append(",");
        }
        return sb;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(array));
        if(list.size() > 0) {
            return recursiveDeserialize(list);
        }
        return null;
    }

    private TreeNode recursiveDeserialize(List <String> list) {
        String head = list.get(0);
        list.remove(0);
        if(head.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(head));

        node.left = recursiveDeserialize(list);
        node.right = recursiveDeserialize(list);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        //==================Test Case 1=====================
        TreeNode node_1 = new TreeNode(-1);
        TreeNode node_2 = new TreeNode(-2);
        TreeNode node_3 = new TreeNode(-3);
        TreeNode node_4 = new TreeNode(-4);
        TreeNode node_5 = new TreeNode(-5);
        TreeNode node_6 = new TreeNode(-6);
        TreeNode node_7 = new TreeNode(-7);

        node_1.left = node_2;
        node_1.right = node_3;
        node_2.left = node_4;
        node_2.right = node_5;
        node_3.left = node_6;
        node_6.right = node_7;
        /*
                1
            2       3
          4   5   6
                    7
         */

        SerializeDeserializeBinaryTree sol = new SerializeDeserializeBinaryTree();
        String text = sol.serialize(node_1);
        System.out.println(text);
        TreeNode reconstructedRoot = sol.deserialize(text);
        System.out.println("Deserialization finished");
    }
}
