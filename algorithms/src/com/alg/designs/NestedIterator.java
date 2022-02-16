package com.alg.designs;

import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> nestedList;
    int index;
    int size;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        this.index = 0;
        int curSize = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            curSize = curSize + getSize(nestedList.get(i));
        }
        this.size = curSize;
    }

    private int getSize(NestedInteger ni){
        int size = 0;
        if(!ni.isInteger()){
            size = size + getSize(ni);
        } else {
            size = 1;
        }
        return size;
    }

    @Override
    public Integer next() {
        return 1;
    }

    @Override
    public boolean hasNext() {
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */