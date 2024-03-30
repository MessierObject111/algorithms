package com.alg.dfs;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if(s.length() < 1) return result;
        for(int i = 0; i < s.length(); i++) list.add(String.valueOf(s.charAt(i)));
        result.add(list);

        return result;
    }
}