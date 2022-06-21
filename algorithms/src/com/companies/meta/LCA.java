package com.companies.meta;

import com.alg.common.TreeNode;
import com.alg.tree.LowestCommonAncestor;

public class LCA {
    //2022-06-20
    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        search(root, p, q);
        return ans;
    }

    private boolean search(TreeNode node, TreeNode p, TreeNode q) {
        //1. Terminal case for false:
        if(node == null) return false;
        //2.If there is any leaves of node containing p or q, return true;
        // In the meanwhile, when certain criteria meets, mark the ans
        boolean isLeft = search(node.left, p, q);
        boolean isRight = search(node.right, p, q);
        if(isLeft || isRight || node == p || node == q) {
            //There are 2 cases where current node must be LCA:
            //1. both isLeft and isRight is true.
            //2. One of the isLeft/isRight is true, and current node equals to one of p/q;
            if( (isLeft && isRight) ||
                    ((isLeft || isRight) && (node == p || node == q))) {
                ans = node;
            }
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
        LCA instance = new LCA();
        //==================Test Case 1=====================
        TreeNode node_1 = new TreeNode(-1);
        TreeNode node_2 = new TreeNode(-2);
        TreeNode node_3 = new TreeNode(-3);
        TreeNode node_4 = new TreeNode(-4);
        TreeNode node_5 = new TreeNode(-5);
        TreeNode node_6 = new TreeNode(-6);
        TreeNode node_7 = new TreeNode(-7);
        TreeNode node_8 = new TreeNode(-8);
        TreeNode node_9 = new TreeNode(-9);
        TreeNode node_10 = new TreeNode(-10);
        TreeNode node_11 = new TreeNode(-11);
        TreeNode node_12 = new TreeNode(-12);
        TreeNode node_13 = new TreeNode(-13);
        TreeNode node_14 = new TreeNode(-14);
        TreeNode node_15 = new TreeNode(-15);
        TreeNode node_16 = new TreeNode(-16);

        node_1.left = node_2;
        node_1.right = node_3;
        node_2.left = node_4;
        node_2.right = node_5;
        node_3.left = node_6;
        node_3.right = node_7;
        node_4.left = node_8;
        node_4.right = node_9;
        node_5.left = node_10;
        node_5.right = node_11;
        node_6.left = node_12;
        node_6.right = node_13;
        node_7.left = node_14;
        node_7.right = node_15;
        node_8.left = node_16;
        System.out.println(instance.lowestCommonAncestor(node_1, node_5, node_7).val);//-1 expected;

        //==================Test Case 2=====================
        TreeNode tc2_root = new TreeNode(1);
        TreeNode tc2_left = new TreeNode(2);

        tc2_root.left = tc2_left;

        System.out.println(instance.lowestCommonAncestor(tc2_root, tc2_left, tc2_root).val);//1 expected;
        String str = "0123456";
        System.out.println(str.substring(0,1));
        System.out.println(str.substring(0,0));
        System.out.println(str.substring(0,6));
    }
}
