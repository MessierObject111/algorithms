package com.alg.tree.traversal;

import com.alg.tree.SerializeDeserializeNTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        helper(queue, res);
        return res;
    }

    private void helper( Queue<Node> queue, List<List<Integer>> res) {
        List<Integer> list = new ArrayList<>();
        Queue<Node> childrenQueue = new LinkedList<Node>();
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            list.add(node.val);
            //System.out.print(node.val + ",");
            List<Node> children = node.children;
            if(children != null) {
                children.stream().forEach(c->childrenQueue.offer(c));
            }
        }
        //System.out.println();
        res.add(list);
        if(!childrenQueue.isEmpty()) helper(childrenQueue, res);

    }

    public void test() {
        Node root = new Node(0);

        Node n0_0 = new Node(1);
        Node n0_1 = new Node(2);
        Node n0_2 = new Node(3);

        Node n1_0 = new Node(4);
        Node n1_1 = new Node(5);

        List<Node> tier1 = new ArrayList<>();
        tier1.add(n0_0);
        tier1.add(n0_1);
        tier1.add(n0_2);
        root.children = tier1;

        List<Node> tier2 = new ArrayList<>();
        tier2.add(n1_0);
        tier2.add(n1_1);
        n0_0.children = tier2;

        List<List<Integer>> res = levelOrder(root);
        res.stream().forEach(l-> {
            l.stream().forEach(i-> System.out.print(i + " "));
            System.out.println();
        });
        //0,1,4,null,5,null,2,null,3,null,
        //
        System.out.println("Done");
    }

    public static void main(String[] args) {
        NaryTreeLevelOrderTraversal sol = new NaryTreeLevelOrderTraversal();
        sol.test();
    }
}
