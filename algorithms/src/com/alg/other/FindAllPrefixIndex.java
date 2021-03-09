package com.alg.other;

import java.util.ArrayList;
import java.util.List;

public class FindAllPrefixIndex {
    public List findAllPrefixes(String paragraph, String prefix) {
        List list = new ArrayList();
        if(paragraph.length() < prefix.length()) return list;
        for (int i = 0; i < paragraph.length() - prefix.length(); i++) {
            String sub = paragraph.substring(i, i + prefix.length()).toLowerCase();
            if(sub.equalsIgnoreCase(prefix)) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String paragraph_1 = "The oldest classical Greek and Latin writing had little or no space between words and " +
                "could be written in boustrophedon (alternating directions). Over time, text direction (left to right) " +
                "became standardized, and word dividers and terminal punctuation became common. The first way to divide" +
                " sentences into groups was the original parágraphos, similar to an underscore at the beginning of " +
                "the new group.[2] The Greek parágraphos evolved into the pilcrow (¶), which in English manuscripts in" +
                " the Middle Ages can be seen inserted inline between sentences. The hedera leaf (e.g. ☙) has also " +
                "been used in the same way.\n" +
                "Indented paragraphs demonstrated in the US Constitution\n" +
                "In ancient manuscripts, another means to divide sentences into paragraphs was a line break (newline)" +
                " followed by an initial at the beginning of the next paragraph. An initial is an oversized capital " +
                "letter, sometimes outdented beyond the margin of the text. This style can be seen, for example, in the " +
                "original Old English manuscript of Beowulf. Outdenting is still used in English typography, though" +
                " not commonly.[3] Modern English typography usually indicates a new paragraph by indenting the first " +
                "line. This style can be seen in the (handwritten) United States Constitution from 1787. For" +
                " additional ornamentation, a hedera leaf or other symbol can be added to the inter-paragraph " +
                "white space, or put in the indentation space.\n" +
                "A second common modern English style is to use no indenting, but add vertical white space to create " +
                "\"block paragraphs.\" On a typewriter, a double carriage return produces a blank line for this " +
                "purpose; professional typesetters (or word processing software) may put in an arbitrary vertical " +
                "space by adjusting leading. This style is very common in electronic formats, such as on the World" +
                " Wide Web and email. Wikipedia itself employs this forma";
        FindAllPrefixIndex solution = new FindAllPrefixIndex();
        List occurrences = solution.findAllPrefixes(paragraph_1, "the");
        occurrences.stream().forEach(n -> {System.out.println(n);});

    }
}
