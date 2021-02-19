package com.alg.graph;

import java.util.ArrayList;
import java.util.List;
//finished without using IDE! :)
public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        paths.add(0);
        traverseAndAdd(graph, 0, paths, n, result);
        return result;
    }

    private void traverseAndAdd(int[][]graph, int position, List<Integer> pathsToCurrentNode, int n, List<List<Integer>> result) {
        if(position == n - 1) {
            result.add(pathsToCurrentNode);
            return;
        }
        int[] accessibleNodes = graph[position];
        if(accessibleNodes.length > 0){
            for(int i = 0; i < accessibleNodes.length; i++) {
                List<Integer> pathsToNextNode = new ArrayList<Integer>();
                pathsToNextNode.addAll(pathsToCurrentNode);
                pathsToNextNode.add(accessibleNodes[i]);
                traverseAndAdd(graph, accessibleNodes[i], pathsToNextNode, n, result);
            }
        }
    }
}
