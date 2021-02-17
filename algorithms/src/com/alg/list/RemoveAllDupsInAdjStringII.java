package com.alg.list;

public class RemoveAllDupsInAdjStringII {
    private boolean eligible = true; // The flag used to determine if another 'searchAndRemove' loop is needed

    public String removeDuplicates(String s, int k) {
        while(eligible) {
            String newString = searchAndRemove(s, k);
            s = newString;
        }
        return s;

    }

    private String searchAndRemove (String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        eligible = false;
        for(int i = 0, count = 0; i < s.length(); i++) {
            // When the count just started or adjacent chars do not equal to each other
            if(i == 0 || sb.charAt(i)!=sb.charAt(i - 1)){
                count = 1;//reset count to 1
            } // When the previous char is equal to current one and count reached k when including this one
            else if (sb.charAt(i)==sb.charAt(i - 1) && (count + 1) == k) {
                sb.delete(i + 1 - k, i + 1);// Delete the part where we found k duplicated adjacent chars.
                // Note here the start need to be i + 1 - k, end has to be i + 1
                eligible = true; // Mark for another searchAndRemove loop since we deleted portion of original string
                break; // Break the loop, start over again
            } // When the previous char is equal to current one and count didn't reached k yet when including this one
            else if (sb.charAt(i)==sb.charAt(i - 1)) {
                count++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input_1 = "abcccbbbc";
        RemoveAllDupsInAdjStringII solution = new RemoveAllDupsInAdjStringII();
        System.out.println(solution.removeDuplicates(input_1, 3));
    }
}
