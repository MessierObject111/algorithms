package com.alg.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Note: Leading zeros are not allowed, e.g: 01.002.003.4 is not allowed. Two or more consecutive zeros between two dots
 * like 1.00.000.1 are also not allowed. 1.0.0.1 is allowed as comparison.
 */
public class RestoreIPAddresses {
    private List<String> resultsList;

    public List<String> restoreIpAddresses(String s) {
        resultsList = new ArrayList<String>();
        List<String> existingList = new ArrayList<String>();
        recurseBackTracing(resultsList, s, existingList);
        //String[] resultsArray = resultsList.toArray(new String[0]);
        return resultsList;
    }

    private void recurseBackTracing(List<String> resultsList, String remaining, List<String> existingList){
        if(existingList.size() < 3) {
//            System.out.println("backtracing lv " + existingList.size() + ": remaining:" + remaining);
            // Checking if the iteration exceeded remaining string's length first, then check if it is < 3 to avoid out of bound exception.
            for(int i = 1; i < remaining.length() && i <= 3; i++) {
                String subStr = remaining.substring(0, i);
                int segment = Integer.valueOf(subStr);
                if(hasLeadingZeros(subStr, segment)) return;
//                System.out.println("backtracing lv " + existingList.size() + " existingList:"+ transformListToString(existingList) + ": sub segment:" + segment);
                if(segment <= 255) {
                    List<String> subList = new ArrayList<String>(existingList);
                    subList.add(subStr);
                    recurseBackTracing(resultsList, remaining.substring(i, remaining.length()), subList);
                }

            }
        } else if(existingList.size() == 3) {
            if(remaining.length() > 3) return;
            int lastInteger = Integer.valueOf(remaining);
            if(hasLeadingZeros(remaining, lastInteger)) return;
            if(lastInteger <= 255) {
                //Match criteria, adding this combination to result list
//                System.out.println("backtracing lv " + existingList.size() + " existingList:"+ transformListToString(existingList) + ": final segment:" + lastInteger);
                List<String> subList = new ArrayList<String>(existingList);
                subList.add(remaining);
                addListOfStringToResult(resultsList, subList);
            }

        } else {
            return;
        }
    }

    private void addListOfStringToResult(List<String> resultsList, List<String> existingList) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < existingList.size(); i++) {
            String s = existingList.get(i);
            sb.append(s);
            if(i < 3) {
                sb.append(".");
            }
        }
        resultsList.add(sb.toString());
    }

    private boolean hasLeadingZeros(String s, int i) {
        int sl = s.length();
        int il = String.valueOf(i).length();
        return sl != il;
    }

    private String transformListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stringList.size(); i++) {
            String s = stringList.get(i);
            sb.append(s);
            if(i < stringList.size()) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RestoreIPAddresses sol = new RestoreIPAddresses();
//        String s = "25525511135";
//        String s = "010010";
        String s = "0279245587303";
        List<String> resultsList = sol.restoreIpAddresses(s);
        for(int i = 0; i < resultsList.size(); i++) {
            System.out.println(resultsList.get(i));
        }
    }
}
