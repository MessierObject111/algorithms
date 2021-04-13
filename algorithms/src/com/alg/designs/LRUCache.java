package com.alg.designs;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, Integer> cache;
    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {

    }
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}
