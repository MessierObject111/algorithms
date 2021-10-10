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

        String startWord4 = "cet";
        String endWord4 = "ism";
        String[] wordListArr4 = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val",
                "mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex",
                "jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui",
                "ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe",
                "box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry",
                "tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye",
                "lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan",
                "age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax",
                "tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag",
                "hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb",
                "fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis",
                "rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie",
                "nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup",
                "dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev",
                "axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may",
                "shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox",
                "ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw",
                "nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis",
                "hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem",
                "who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil",
                "mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog",
                "gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak",
                "bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo",
                "cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue",
                "dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end",
                "gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag",
                "mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov",
                "jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun",
                "fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism",
                "err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab",
                "ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han",
                "met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god",
                "duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz",
                "fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow",
                "jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale",
                "bud","gee","pin","dun","pat","ten","mob"};
        List<String> wordList4 = Arrays.asList(wordListArr4);

        List<List<String>> allPaths4 = sol.findLadders(startWord4, endWord4, wordList4);
        allPaths4.stream().forEach(e -> {
            e.forEach(i-> System.out.print(i + ","));
            System.out.println();
        });
    }
}
