package com.alg.designs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache {
    private ConcurrentHashMap<Integer, Integer> cache;
    private LinkedList<Integer> ranking;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new ConcurrentHashMap<>();
        this.ranking = new LinkedList<>();
    }

    public int get(int key) {
        Integer value = this.cache.get(key);
        if(value != null) {
            int i = 0;
            while(ranking.get(i) != key) {
                i++;
            }
            ranking.remove(i);
            //Then add it to the top
            ranking.offer(key);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.get(key) == null &&
                cache.size() >= this.capacity) {
            int keyToRemove = this.ranking.poll();
            cache.remove(keyToRemove);
        }
        cache.put(key, value);
        ranking.add(key);
    }
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    public static void main(String[] args) {
        LRUCache sol = new LRUCache(2);
        System.out.println(sol.get(2));
//        sol.put(1, 1);
        sol.put(2, 6);

        System.out.println(sol.get(1));
        sol.put(1, 5);
        sol.put(1, 2);
        sol.put(5, 5);
        System.out.println(sol.get(1));
        System.out.println(sol.get(2));

//        ["LRUCache","get","put","get","put","put","get","get"]
//        [[2],       [2],   [2,6],[1], [1,5],[1,2], [1],  [2]]
//        [null,      -1,     null,-1,  null,  null,  2,   -1]
    }
}
