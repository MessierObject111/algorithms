package com.alg.bfs;

import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find the shortest transformation sequence from start to end, output the length of the sequence.
 * Transformation rule such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary. (Start and end words do not need to appear in the dictionary )
 * Example
 * Example 1:
 *
 * Input：start = "a"，end = "c"，dict =["a","b","c"]
 * Output：2
 * Explanation：
 * "a"->"c"
 * Example 2:
 *
 * Input：start ="hit"，end = "cog"，dict =["hot","dot","dog","lot","log"]
 * Output：5
 * Explanation：
 * "hit"->"hot"->"dot"->"dog"->"cog"
 *
 * Notice
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 */
public class WordLadder {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // Use BFS since it is a graph search in essential (not obvious, but it is graph search)
        // Find next word with 1 edit distance
        // Mark those words that has been iterated as 'already passed' and do not iterate in next round
        // recurse until the target word is found or everything has been iterated
        if(dict == null) return 0;
        if(start.equals(end)) return 1;
        dict.add(end);

        Set<String> passed = new HashSet<>();
        Queue<String> queue = new LinkedList<String>();
        passed.add(start);
        queue.add(start);
        int length = 1;
        while(!queue.isEmpty()) {
            length++;//The length only increase by breadth, so it should only increase per while loop layer
            int size = queue.size();
            for(int i = 0; i<size; i++) {
                String currentWord = queue.poll();
                for(String word : findNextWord(currentWord, dict)) {
                    if(passed.contains(word)) {
                        continue;
                    }
                    if (word.equals(end)) {
                        return length;
                    }
                    passed.add(word);
                    queue.offer(word);

                }
            }

        }
        return 0;
    }

    public ArrayList<String> findNextWord(String word, Set<String> dict) {
        ArrayList<String> neigbhours = new ArrayList<>();
        for(char c = 'a'; c < 'z'; c++) {
            for(int i = 0; i < word.length(); i++) {
                if(c == word.charAt(i)) {
                    continue;
                }
                String constructedWord = replaceChar(word, i, c);
                if (dict.contains(constructedWord)) {
                    neigbhours.add(constructedWord);
                }
            }
        }

        return neigbhours;
    }

    private String replaceChar (String word, int index, char c) {
        char[] charArray = word.toCharArray();
        charArray[index] = c;
        String result = new String(charArray);
        return result;
    }

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("hut");
        dict.add("dot");
        dict.add("but");
        dict.add("dut");
        dict.add("dog");
//        dict.add("dun");


        int result = wl.ladderLength(start, end, dict);
        System.out.println(result);
    }
}
