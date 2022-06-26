package com.companies.meta;

import java.util.ArrayList;
import java.util.List;

public class ConvertBinarySearchTreeToDoublyLinkedList {
    Node head = new Node();
    List<Node> list = new ArrayList<>();

    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        search(root);

        int k = list.size();
        System.out.println("list size:" + k);
        //head.right = list.get(0);
        for(int i = 0; i < list.size(); i++){
            System.out.println("i: " + i);
            Node prev;
            if(i == 0) {
                prev = list.get(k - 1);
            } else {
                prev = list.get(i - 1);
            }
            Node cur = list.get(i);
            Node next;
            if(i == k - 1) {
                next = list.get(0);
            } else {
                next = list.get(i + 1);
            }
            System.out.println("prev: " + prev.val + " cur: " + cur.val + " next: "+next.val);
            cur.left = prev;
            cur.right = next;
        }

        return list.get(0);
    }
    private void search(Node node){
        if(node.left != null) search(node.left);
        list.add(node);
        if(node.right != null) search(node.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
