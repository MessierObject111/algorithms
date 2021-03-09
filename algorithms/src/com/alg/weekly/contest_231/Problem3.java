package com.alg.weekly.contest_231;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 5699. Number of Restricted Paths From First to Last Node
 * User Accepted:373
 * User Tried:674
 * Total Accepted:376
 * Total Submissions:1090
 * Difficulty:Medium
 * There is an undirected weighted connected graph. You are given a positive integer n which denotes that the graph has
 * n nodes labeled from 1 to n, and an array edges where each edges[i] = [ui, vi, weighti] denotes that there is an edge
 * between nodes ui and vi with weight equal to weighti.
 *
 * A path from node start to node end is a sequence of nodes [z0, z1, z2, ..., zk] such that z0 = start and zk = end and
 * there is an edge between zi and zi+1 where 0 <= i <= k-1.
 *
 * The distance of a path is the sum of the weights on the edges of the path. Let distanceToLastNode(x) denote the
 * shortest distance of a path between node n and node x. A restricted path is a path that also satisfies that
 * distanceToLastNode(zi) > distanceToLastNode(zi+1) where 0 <= i <= k-1.
 *
 * Return the number of restricted paths from node 1 to node n. Since that number may be too large, return it
 * modulo 109 + 7.
 *
 *
 */
class GNode {
    int index;
    Map<GNode, Integer> paths;
    int distanceToLastNode;

    public GNode(int index) {
        this.index = index;
        paths = new HashMap<>();
        distanceToLastNode = Integer.MAX_VALUE;
    }
}

public class Problem3 {
    int count = 0;
    public int countRestrictedPaths(int n, int[][] edges) {
        Map<Integer, GNode> nodes = new HashMap<>();
        HashSet<GNode> visited = new HashSet<>();
        // Populate all the nodes;
        for(int i = 1; i <= n; i++) {
            nodes.put(i, new GNode(i));
        }
        // Populate all the graph with paths
        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int indexA = edge[0];
            int indexB = edge[1];
            int weight = edge[2];
            populateNodes(indexA, indexB, weight, nodes);
        }
        //Iterate and mark all nodes with its distanceToLastNode value;
        markAndSweep(nodes.get(n), 0, visited);

        //Find restricted paths based on distanceToLastNode values;
        findRestrictive(nodes.get(n), 0);

        return count;
    }

    private void populateNodes (int indexA, int indexB, int weight, Map<Integer, GNode> map) {
        try {
            GNode nodeA = map.get(indexA);
            GNode nodeB = map.get(indexB);
            nodeA.paths.put(nodeB, weight);
            nodeB.paths.put(nodeA, weight);
        } catch (NullPointerException e) {
            System.out.println("NodeA: " + indexA + " NodeB: " + indexB);
            e.printStackTrace();
            System.exit(1);
        }

    }

    /**
     * Iterate and mark all nodes with its distanceToLastNode value
     * Mistake/Bug 1: I did not mark visited nodes and kept revisiting visited ones. StackOverFlow!
     * Mistake/Bug 2: The visited set is shared between recursion calls. They should use new sets.
     * @param node
     * @param distance
     */
    private void markAndSweep(GNode node, int distance, HashSet<GNode> visited) {
        visited.add(node);
        System.out.println("cur dis: " + node.distanceToLastNode + " new dis:"+ distance);
        if(node.distanceToLastNode > distance) {
            node.distanceToLastNode = distance;
        }
        if(node.paths != null && !node.paths.isEmpty()) {
            Map<GNode, Integer> paths = node.paths;
            paths.forEach((k,v)->{
                if(!visited.contains(k)) {
                    System.out.println(" current:" + node.index + " next:" + k.index);
                    HashSet<GNode> newSet = (HashSet<GNode>) visited.clone();
                    markAndSweep(k, v + node.distanceToLastNode, visited);
                }
            });
            System.out.println("Ran out at:" + node.index);
        }
    }

    private void findRestrictive (GNode node, int prevDistanceToLast){
        int distance = node.distanceToLastNode;
        if(distance > prevDistanceToLast) {
            //Is restrictive, continue until reaches end
            if(node.index == 0) count++;
            Map<GNode, Integer> paths = node.paths;
            Set<Map.Entry<GNode, Integer>> pathsSet = paths.entrySet().stream().filter((entry)->{
                return entry.getKey().index < node.index;
            }).collect(Collectors.toSet());
            pathsSet.stream().forEach(entry->{
                GNode nextNode = entry.getKey();
                findRestrictive(nextNode, node.distanceToLastNode);
            });
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}};
        Problem3 sol = new Problem3();
        System.out.println(sol.countRestrictedPaths(n, edges));
    }
}


