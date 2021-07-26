package com.alg.bfs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
 * beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences
 * from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list
 * of the words [beginWord, s1, s2, ..., sk].
 *
 *
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * Explanation: There are 2 shortest transformation sequences:
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: []
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 *
 *
 * Constraints:
 *
 * 1 <= beginWord.length <= 5
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 1000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 */
public class WordLadderII {
    private int MIN_STEPS = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<List<String>> allPaths = new HashSet<>();
        Set<String> visited = new LinkedHashSet<>();
        visited.add(beginWord);

        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return new ArrayList<>();
        findNextSteps(beginWord, endWord, wordList, visited, allPaths);
        if(allPaths.isEmpty()) return new ArrayList<>();
        int minLength = allPaths.stream()
                .mapToInt(e -> e.size()).min()
                .orElseThrow(NoSuchElementException::new);
        List<List<String>> pathsWithMinLength = allPaths.stream().filter(e -> e.size() == minLength)
                .collect(Collectors.toList());
        MIN_STEPS = Integer.MAX_VALUE;
        return pathsWithMinLength;
    }

    private void findNextSteps (String beginWord, String endWord, List<String> wordList, Set<String> visited, Set<List<String>> allPaths ) {
        if(visited.size() > MIN_STEPS) return;
        for(int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            Set<String> visited_cp = new LinkedHashSet<>(visited);
            if(!visited_cp.contains(word)) {

                if(checkValidStep(beginWord, endWord)) {
                    visited_cp.add(endWord);
                    List<String> currentPath = new ArrayList(visited_cp);
                    if(!allPaths.contains(currentPath)) {
                        if(MIN_STEPS >= currentPath.size()) {
                            MIN_STEPS = currentPath.size();
                            allPaths.add(currentPath);
//                            System.out.print("New End Word Found: ");
//                            currentPath.stream().forEach(p -> System.out.print(p + " "));
//                            System.out.println();
                        }
                    }
                }
                if(checkValidStep(beginWord, word)) {
                    visited_cp.add(word);
                    findNextSteps(word, endWord, wordList, visited_cp, allPaths);
                }
            }
        }
    }

    private boolean checkValidStep (String s1, String s2) {
        if(s1.length() == s2.length()) {
            int count = 0;
            for(int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i)) {
                    count++;
                }
            }
            if(count == 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        WordLadderII sol = new WordLadderII();
        String startWord = "hit";
        String endWord = "cog";
        String[] wordListArr = {"hot","dot","dog","lot","log","cog"};
        //[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
        List<String> wordList = Arrays.asList(wordListArr);

        List<List<String>> allPaths = sol.findLadders(startWord, endWord, wordList);
        allPaths.stream().forEach(e -> {
            e.forEach(i-> System.out.print(i + ","));
            System.out.println();
        });
//        sol.MIN_STEPS = Integer.MAX_VALUE;

        String startWord2 = "qa";
        String endWord2 = "sq";
        String[] wordListArr2 = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar",
                "ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn",
                "au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga",
                "li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc",
                "ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        List<String> wordList2 = Arrays.asList(wordListArr2);

        List<List<String>> allPaths2 = sol.findLadders(startWord2, endWord2, wordList2);
        allPaths2.stream().forEach(e -> {
            e.forEach(i-> System.out.print(i + ","));
            System.out.println();
        });
//        sol.MIN_STEPS = Integer.MAX_VALUE;

        String startWord3 = "hot";
        String endWord3 = "dog";
        String[] wordListArr3 = {"hot","dog"};
        List<String> wordList3 = Arrays.asList(wordListArr3);

        List<List<String>> allPaths3 = sol.findLadders(startWord3, endWord3, wordList3);
        allPaths3.stream().forEach(e -> {
            e.forEach(i-> System.out.print(i + ","));
            System.out.println();
        });
//        sol.MIN_STEPS = Integer.MAX_VALUE;
    }
}
