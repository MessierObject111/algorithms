package com.java8;

import java.util.ArrayList;
import java.util.StringJoiner;

public class StringJoinerTest {
    public static void main(String[] args) {
        //Example 1:
        StringJoiner mystring = new StringJoiner("-");

        // Joining multiple strings by using add() method
        mystring.add("Logan");
        mystring.add("Magneto");
        mystring.add("Rogue");
        mystring.add("Storm");

        // Displaying the output String
        System.out.println("Example 1:");
        System.out.println(mystring);

        //Example 2:

        /* Passing comma(,) as delimiter and opening bracket
         * "(" as prefix and closing bracket ")" as suffix
         */
        StringJoiner mystring2 = new StringJoiner(",", "(", ")");

        // Joining multiple strings by using add() method
        mystring2.add("Negan");
        mystring2.add("Rick");
        mystring2.add("Maggie");
        mystring2.add("Daryl");

        // Displaying the output String
        System.out.println("Example 2:");
        System.out.println(mystring2);


        //Example 3:
        /* Passing comma(,) as delimiter and opening bracket
         * "(" as prefix and closing bracket ")" as suffix
         */

        System.out.println("Example 3:");
        StringJoiner mystring3 = new StringJoiner(",", "(", ")");

        mystring3.add("Negan");
        mystring3.add("Rick");
        mystring3.add("Maggie");
        mystring3.add("Daryl");

        System.out.println("First String: "+mystring3);

        /* Passing hyphen(-) as delimiter and string "pre"
         * as prefix and string "suff" as suffix
         */
        StringJoiner myanotherstring = new StringJoiner("-", "pre", "suff");

        myanotherstring.add("Sansa");
        myanotherstring.add("Imp");
        myanotherstring.add("Jon");
        myanotherstring.add("Ned");

        System.out.println("Second String: "+myanotherstring);

        /* Merging both the strings
         * The important point to note here is that the output string will be
         * having the delimiter prefix and suffix of the first string (the string
         * which is calling the merge method of StringJoiner)
         */
        StringJoiner mergedString = mystring3.merge(myanotherstring);
        System.out.println(mergedString);
    }
}
