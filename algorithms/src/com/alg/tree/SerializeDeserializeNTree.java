package com.alg.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/description/
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

    //This is nothing but a counter, an object containing a int so it
    // can be shared across function calls to keep track of current index/state.
    class WrappableInt {
        private int value;
        public WrappableInt(int x) {
            this.value = x;
        }
        public int getValue() {
            return this.value;
        }
        public void increment() {
            this.value++;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) return "";
        dfp(root, sb);
        return sb.toString();
    }

    private void dfp(Node node, StringBuilder sb) {
        if(node != null) {
            sb.append(node.val).append(",");
        } else {
            return;
        }
        //sb.append(node.val).append(",");

        if(node.children != null) {
            node.children.stream().forEach(n -> {
                dfp(n, sb);
            });
            sb.append("#").append(",");
        } else {
            sb.append("#").append(",");
            return;
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data == null || data.equals("")) return null;
        List<String> list = Arrays.asList(data.split(","));
        Node root = buildTreeRecursive(list, new WrappableInt(0));
        return root;
    }

    private Node buildTreeRecursive(List<String> list, WrappableInt index) {
        if(index.getValue() == list.size()) {
            return null;
        }
        Node node;
        if(list.get(index.getValue()).equals("#")) {
            //System.out.println("reaching leaf, return;");
            return null;
        } else {
            node = new Node(Integer.valueOf(list.get(index.getValue())));
            //System.out.println("node created: " + list.get(index.getValue()) + " index:" + index);
        }
        node.children = new ArrayList<>();
        index.increment();
        while(!list.get(index.getValue()).equals("#") && index.getValue() < list.size()) {
            //System.out.println("add children node for "+ list.get(index.getValue()) +", index:" + (index.getValue()));
            node.children.add(buildTreeRecursive(list, index));
        }
        //System.out.println("# met; going up one level");
        index.increment();
        return node;
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
        Node tree = deserialize(res);
        //0,1,4,null,5,null,2,null,3,null,
        //
        System.out.println("Done");
    }
    public static void main(String[] args) {
        SerializeDeserializeNTree sol = new SerializeDeserializeNTree();
        sol.test();
    }
}
