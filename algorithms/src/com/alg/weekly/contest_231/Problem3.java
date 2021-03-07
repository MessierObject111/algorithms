package com.alg.weekly.contest_231;

import java.util.ArrayList;
import java.util.List;

class GNode {
    int index;
    List<GPath> paths;

    public GNode(int index) {
        this.index = index;
        paths = new ArrayList<>();
    }
}

class GPath {
    GNode node;
    int distance;

    public GPath(GNode node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class Problem3 {
    public int countRestrictedPaths(int n, int[][] edges) {
        List<GNode> nodes = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            nodes.add(new GNode(i));
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}};
    }
}


