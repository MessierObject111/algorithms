package com.alg.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 615. Course Schedule
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed
 * as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example
 * Example 1:
 *
 * Input: n = 2, prerequisites = [[1,0]]
 * Output: true
 * Example 2:
 *
 * Input: n = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 *
 * Analysis: Basically we are trying to find if there are any loops in given graph. We can use BFS
 */
public class CourseSchedule {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //TODO:
        List[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        // 建图
        for (int[] edge: prerequisites) {
            graph[edge[1]].add(edge[0]);
            inDegree[edge[0]]++;
        }

        int numChoose = 0;
        Queue que = new LinkedList();

        // 将入度为 0 的编号加入队列
        for(int i = 0; i < inDegree.length; i++){
            if (inDegree[i] == 0) {
                que.add(i);
            }
        }

        while (! que.isEmpty()) {
            int now = (int)que.poll();
            numChoose++;
            // 将每条边删去，如果入度降为 0，再加入队列
            for (int i = 0; i < graph[now].size(); i++) {
                int nxt = (int)graph[now].get(i);
                inDegree[nxt]--;
                if (inDegree[nxt] == 0) {
                    que.add(nxt);
                }
            }
        }

        return numChoose == numCourses;
    }
}
