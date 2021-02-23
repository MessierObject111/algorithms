package com.alg.tree;
import com.alg.common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The difference between this to leetcode 987 is the comparing logic when nodes are in the same column and same row.
 * 987 requires us to order by value when that happens, while this problem requires order by preorder-traversing order.
 *
 * When two nodes have the same position (i.e. same X and same Y value), 314 asks us to sort them in the result based
 * on X ("from left to right"), while 987 asks us to sort them in the result based on the nodes' values.
 */
class GridContainer implements Comparable<GridContainer>{
    int row;
    int col;
    List<Integer> nodes;

    public GridContainer(){

    }

    public GridContainer(int row, int col, List<Integer> nodes) {
        this.row = row;
        this.col = col;
        this.nodes = nodes;
    }

    @Override
    public int compareTo(GridContainer o) {
        if(row == o.row) {
            return col - o.col;
        }
        return this.row - o.row;
    }
}

public class BinaryTreeVerticalOrderTraversal314 {
    Map<String, GridContainer> gridNodes = new HashMap<>();
    private int leftMost = 0;
    private int rightMost = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        bfs(root, 0, 0);
        Set<Map.Entry<String, GridContainer>> entries = gridNodes.entrySet();
        List<GridContainer> grids = entries.stream().map((e)->{
            return e.getValue();
        }).collect(Collectors.toList());
        PriorityQueue<GridContainer> queue = new PriorityQueue<>();
        for(int i = 0; i < grids.size(); i++) {
            GridContainer grid = grids.get(i);
            queue.offer(grid);
        }
        List<List<Integer>> negativeList = new ArrayList<>();
        List<List<Integer>> positiveList = new ArrayList<>();
        for(int i = 0; i < Math.abs(leftMost) + 1; i++) {
            negativeList.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < Math.abs(rightMost) + 1; i++) {
            positiveList.add(new ArrayList<Integer>());
        }
        while(!queue.isEmpty()) {
            GridContainer grid = queue.poll();
            int col = grid.col;
            if(col < 0) {
                if(negativeList.get(-col).isEmpty()) {
                    negativeList.set(-col, grid.nodes);
                } else {
                    negativeList.get(-col).addAll(grid.nodes);
                }

            } else {
                if(positiveList.get(col).isEmpty()) {
                    positiveList.set(col, grid.nodes);
                }else {
                    positiveList.get(col).addAll(grid.nodes);
                }
            }
        }
        for(int i = negativeList.size() - 1; i >= 0; i--) {
            if(!negativeList.get(i).isEmpty()) result.add(negativeList.get(i));
        }
        for(int i = 0; i < positiveList.size(); i++) {
            if(!positiveList.get(i).isEmpty()) result.add(positiveList.get(i));
        }
        return result;
    }

    private void bfs(TreeNode node, int row, int col) {
        if(node == null) return;
        String key = 31 * row + " - " + 30 * col;
        leftMost = Math.min(leftMost, col);
        rightMost = Math.max(rightMost, col);
        GridContainer list = gridNodes.get(key);
        if(list == null) {
            List<Integer> nodes = new ArrayList<>();
            nodes.add(node.val);
            GridContainer newList = new GridContainer(row, col, nodes);
            gridNodes.put(key, newList);
        } else {
            List nodes = list.nodes;
            nodes.add(node.val);
        }
        bfs(node.left, row + 1, col - 1);
        bfs(node.right, row + 1, col + 1);
    }

    public static void main(String[] args) {
        BinaryTreeVerticalOrderTraversal314 s = new BinaryTreeVerticalOrderTraversal314();

        TreeNode root = new TreeNode(1);
        TreeNode node_1 = new TreeNode(0);
        TreeNode node_2 = new TreeNode(3);
        TreeNode node_3 = new TreeNode(2);
        TreeNode node_4 = new TreeNode(4);
//        TreeNode node_5 = new TreeNode(4);
//        TreeNode node_6 = new TreeNode(-2);

        root.left = node_1;
        root.right = node_2;
        node_2.left = node_3;
        node_2.right = node_4;
//        node_2.left = node_5;
//        node_2.right = node_6;

        List<List<Integer>> result = s.verticalOrder(root);
        System.out.println();

    }
}
