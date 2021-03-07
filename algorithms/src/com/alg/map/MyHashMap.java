package com.alg.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map {

    Entry<K, V>[] entries;
    static int INIT_SIZE = 16;

    MyHashMap () {
        this(INIT_SIZE);
    }

    MyHashMap(int size) {
        this.entries = new Entry[size];
    }

    @Override
    public int size() {
        return entries.length;
    }

    @Override
    public boolean isEmpty() {
        if(entries.length == 0) return true;
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
