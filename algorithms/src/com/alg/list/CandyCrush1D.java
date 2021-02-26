package com.alg.list;

/**
 * 2020-02-25: Bloomberg
 * This is the same question like RemoveAllDupsInAdjStringII. I got interviewed with this question today and I didn't
 * finish it in 30 min bug free, meanwhile made a lot of trivial bugs like boundary check/ delete() start and end index
 * .etc, making a bad impression to interviewer. The fact that I can do this problem alone without time limit with IDE
 * does not mean I can finish this on a whiteboard in 30 min bug free with constant interviewer interactions and
 * psychological pressures when I make mistakes and someone is watching. Actually, this kind of problems were exposed in
 * earlier mock interviews with my friends, but it is not easy to overcome in a few days. Lesson learnt the hard way.
 *
 * The code was done on Hacker Rank editor, and I need to construct my own test cases then execute it. It has some type
 * checking with highlighting texts, but it has zero variable name or method name checking before compile. If you made
 * typo like MapEntry (Map.Entry) or .toStrung() (.toString()), it won't highlight anything for you.
 */
public class CandyCrush1D {
    boolean e = true;
    public String crushCandy (String s) {
        while (e) {
            String crushed = crush (s);
            s = crushed;
        }
        return s;
    }

    private String crush (String s) {
        StringBuilder sb = new StringBuilder(s);
        e = false;
        if (s.length() < 3) return s;
        int start = 0;
        int count = 1;
        for(int i = 1; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else if(s.charAt(i) != s.charAt(i - 1)) {
                if(count < 3) {
                    count = 1;
                    start = i + 1;
                } else {
                    sb.delete(start, i + 1);
                    e = true;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CandyCrush1D solution = new CandyCrush1D();

        String input_1 = "abcccbbbc";
        System.out.println(solution.crushCandy(input_1));
    }
}
