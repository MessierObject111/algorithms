package com.alg.dp;

import java.util.*;
import java.util.stream.Collectors;

public class WordBreakII {
    private Map<Integer, List<String>> dpCache = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if(s.isEmpty()) return new ArrayList<>();
        Set<String> wordSet = new HashSet<>();
        for(int i = 0; i< wordDict.size(); i++) {
            wordSet.add(wordDict.get(i));
        }

        List<String> results = recurseBfs(s, wordSet);
        return results;
    }

    private List<String> recurseBfs(String s, Set<String> dict) {
        if(s.length() == 0) return new ArrayList<>();

        List<String> cached = dpCache.get(s.length());
        if(cached != null) return cached;

        List<String> possibleStarts = dict.stream().filter(str->{
            return s.startsWith(str);
        }).collect(Collectors.toList());

        List<String> results = new ArrayList<>();
        for(int i = 0; i < possibleStarts.size(); i++) {
            String start = possibleStarts.get(i);
            //If the start steps ro the end of given string
            if (start.equals(s)) {
                results.add(start);
            } else { // If start step does not reach end of given string, check if DP cache has result
                String remaining = s.substring(start.length());// I made a lucky mistake here. When only 1 param was provided, it will substring from param int to end.
                List<String> cachedResults = dpCache.get(remaining.length());
                if(cachedResults == null) {
                    //If no prior result was found for given step at i (remaining.length() steps to the end)
                    List<String> recurseResults = recurseBfs(remaining, dict);
                    cachedResults = recurseResults;
                }

                for(int j = 0; j < cachedResults.size(); j++) {
                    if(cachedResults.get(j).length() > 0){
                        String resultLine = start + " " + cachedResults.get(j);
                        results.add(resultLine);
                    }
                }
            }
        }
        dpCache.put(s.length(), results);
        return results;
    }

    public static void main(String[] args) {
        WordBreakII wordBreakII = new WordBreakII();
        long start = System.currentTimeMillis();

        String inputString = "catsanddog";
        String[] input = {"cat", "cats", "and", "sand", "dog"};
        List<String> animals = new ArrayList<>();
        for(int i = 0; i< input.length; i++) {
            animals.add(input[i]);
        }
        List<String> results = wordBreakII.wordBreak(inputString, animals);
        results.stream().forEach(str->System.out.println(str));
        System.out.println();
        wordBreakII.dpCache.clear();

        String inputString_2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String[] input_2 = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        List<String> inputList_2 = new ArrayList<>();
        for(int i = 0; i< input_2.length; i++) {
            inputList_2.add(input_2[i]);
        }
        List<String> results_2 = wordBreakII.wordBreak(inputString_2, inputList_2);
        results_2.stream().forEach(str->System.out.println(str));
        System.out.println();


        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
