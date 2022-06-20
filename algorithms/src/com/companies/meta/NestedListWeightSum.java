package com.companies.meta;

import java.util.List;

/**
 * 339. Nested List Weight Sum
 * Medium
 *
 * 1357
 *
 * 310
 *
 * Add to List
 *
 * Share
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.
 *
 * The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.
 *
 * Return the sum of each integer in nestedList multiplied by its depth.
 */
public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        for(int i = 0; i < nestedList.size(); i++) {
            int depth = 1;
            NestedInteger current = nestedList.get(i);
            if(current.isInteger()) {
                sum += current.getInteger() * depth;
                System.out.println("Integer added:" + current.getInteger() + " depth:" + depth + " sum:" + sum);
            } else {
                sum += recurseAdd(current.getList(), depth+1);
                System.out.println("Recurse done at: " + i + " sum:" + sum);
            }
        }
        return sum;
    }

    private int recurseAdd(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for(int i = 0; i < nestedList.size(); i++) {
            NestedInteger current = nestedList.get(i);
            if(current.isInteger()) {
                sum += current.getInteger() * depth;
                System.out.println("Integer added:" + current.getInteger() + " depth:" + depth + " sum:" + sum);
            } else {
                sum += recurseAdd(current.getList(), depth + 1);
            }
        }
        return sum;
    }
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *     // Constructor initializes an empty nested list.
     *     public NestedInteger();
     *
     *     // Constructor initializes a single integer.
     *     public NestedInteger(int value);
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // Set this NestedInteger to hold a single integer.
     *     public void setInteger(int value);
     *
     *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     *     public void add(NestedInteger ni);
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return empty list if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
    public interface NestedInteger {
//        public NestedInteger();
//        public NestedInteger(int value);
        public boolean isInteger();
        public Integer getInteger();
        public void setInteger(int value);
        public void add(NestedInteger ni);
        public List<NestedInteger> getList();

    }

}
