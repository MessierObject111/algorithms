package com.alg.dp;

public class MinEditDistance {

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        EditDisInnerClass ic = new EditDisInnerClass();

        System.out.println(ic.minDistance(str1, str2));
        System.out.println();
    }

    static class EditDisInnerClass {
        public int minDistance(String word1, String word2) {
            return editDistHelper(word1, word2, word1.length(), word2.length());
        }
        public int editDistHelper(String str1, String str2, int m, int n) {
            // If first string is empty, the only option is to
            // insert all characters of second string into first
            if (m == 0) {
                return n;
            }

            // If second string is empty, the only option is to
            // remove all characters of first string
            if (n == 0) {
                return m;
            }

            // If last characters of two strings are same, nothing
            // much to do. Ignore last characters and get count for
            // remaining strings.
            if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
                return editDistHelper(str1, str2, m - 1, n - 1);
            }

            // If last characters are not same, consider all three
            // operations on last character of first string, recursively
            // compute minimum cost for all three operations and take
            // minimum of three values.
            return min(editDistHelper(str1, str2, m - 1, n),
                    editDistHelper(str1, str2, m, n - 1),
                    editDistHelper(str1, str2, m - 1, n - 1))
                    + 1;
        }

        /**
         * return the minimum value among all 3 entries
         * @param x
         * @param y
         * @param z
         * @return
         */
        public int min(int x, int y, int z) {
            if (x <= y && x <= z)
                return x;
            if (y <= x && y <= z)
                return y;
            else
                return z;
        }
    }

}
