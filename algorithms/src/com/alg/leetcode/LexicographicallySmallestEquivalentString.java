package com.alg.leetcode;

import java.util.*;

public class LexicographicallySmallestEquivalentString {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character, SortedSet<Character>> dict = new HashMap<>();
        char[] array1 = s1.toCharArray();
        for(int i = 0; i < array1.length; i++) {
            char c1 = array1[i];
            char c2 = s2.charAt(i);
            if(c1!=c2) {
                SortedSet<Character> sortedSet;
                if(!dict.containsKey(c1) && !dict.containsKey(c2)){
                    //Dictionary doesn't contain c1 nor c2
                    sortedSet = new TreeSet<>();

                } else {
                    //Dictionary contains c1 or c2
//                    sortedSet = dict.get(c1) == null || dict.get(c1).size() == 0 ?
//                            dict.get(c2) : dict.get(c1);
                    //TODO: Can you see the bug here? This logic above is omitting some common situations
                    sortedSet = mergeSets(dict.get(c1), dict.get(c2));
                }
                sortedSet.add(c1);
                sortedSet.add(c2);
//                dict.put(c1, sortedSet);
//                dict.put(c2, sortedSet);
                //TODO: Can you see the bug here? This logic above is omitting some common situations again
                for(Character c: sortedSet) {
                    dict.put(c, sortedSet);
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < baseStr.length(); i++){
            Character c = baseStr.charAt(i);
            SortedSet<Character> sortedSet = dict.get(c);
            Character s = sortedSet == null ? c : sortedSet.first();
            sb.append(s);
        }
        return sb.toString();
    }

    private SortedSet<Character> mergeSets(SortedSet<Character> set1, SortedSet<Character> set2) {
        if(set1 != null && set2 != null) {
            for(Character c : set2) {
                set1.add(c);
            }
            return set1;
        }
        return set1 != null ? set1 : set2;
    }

    private String appendComma(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append(',');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LexicographicallySmallestEquivalentString sol = new LexicographicallySmallestEquivalentString();
        try {
            //Test case 1
//        String s1 =
//                "leetcode";
//        String s2 =
//                "programs";
//        String baseStr =
//                "sourcecode";
//
//        System.out.println(sol.smallestEquivalentString(s1, s2, baseStr));

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Test case 2
        try {

            String s1 =
                    "dccaccbdafgeabeeghbigbhicggfbhiccfgbechdicbhdcgahi";
            String s2 =
                    "igfcigeciahdafgegfbeddhgbacaeehcdiehiifgbhhehhccde";
            String baseStr =
                    "sanfbzzwblekirguignnfkpzgqjmjmfokrdfuqbgyflpsfpzbo";

            //Output
            //"sanbazzwalakarauaannbkpzaqjmjmbokrabuqaayblpsbpzao"
            //Expected
            //"sanaazzwalakarauaannakpzaqjmjmaokraauqaayalpsapzao"
            //"sanaazzwalakarauaannakpzaqjmjmaokraauqaayalpsapzao"

//        System.out.println(sol.appendComma(s1));
//        System.out.println(sol.appendComma(s2));
//        System.out.println(sol.appendComma(baseStr));
//            System.out.println(sol.smallestEquivalentString(s1, s2, baseStr));

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Test case 3
        try {
            String s1 =
                    "opecenadojbodihfgmpijpfocomhcncicefpohkibjckijghii";
            String s2 =
                    "ndlbhpaeppgekfhnjnmmplmdoifdhbglmedpjgleofgnahglbe";
            String baseStr =
                    "ttusuhhrabgsswpaapxoxdanchyccmpjitwwmfioedtbiggfru";
            String Output =
                    "ttusuaaraaasswaaaaxbxbabaayaaaaaatwwaaababtaaaaaru";
            String Expected =
                    "ttusuaaraaasswaaaaxaxaaaaayaaaaaatwwaaaaaataaaaaru";

            System.out.println(sol.smallestEquivalentString(s1, s2, baseStr));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
