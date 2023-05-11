package com.alg.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeDeserializeNTree {
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
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        dfp(root, sb);
        return sb.toString();
    }

    private void dfp(Node node, StringBuilder sb) {
//        if(node != null) {
//            sb.append(node.val).append(",");
//        } \
        sb.append(node.val).append(",");

        if(node.children != null) {
            node.children.stream().forEach(n -> {
                dfp(n, sb);
            });
            sb.append("null").append(",");
        } else {
            sb.append("null").append(",");
            return;
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Node root = new Node();
        List<String> list = Arrays.asList(data.split(","));
        buildTree(root, list, 0);
        return root;
    }

    private void buildTree(Node node, List<String> list, int index) {
//        String val = list.get(index);
//        if(val.equals("null")) {
//            return;
//        }
//        node.val = Integer.valueOf(val);
//        List<Integer> children = new ArrayList<>();
//        //for(int i = 0; i < )
//        buildTree();
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

        String res = serialize(root);
        System.out.println(res);
        //0,1,4,null,5,null,2,null,3,null,
        //
    }
    public static void main(String[] args) {
        SerializeDeserializeNTree sol = new SerializeDeserializeNTree();
        sol.test();
    }
}
