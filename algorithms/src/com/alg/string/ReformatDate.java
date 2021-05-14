package com.alg.string;

import java.util.HashMap;
import java.util.Map;

public class ReformatDate {
    private static final Map<String, String> months = getMonths();
    public String reformatDate(String date) {

        String[] parts = date.split(" ");
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];

        String dayStr = day.length() == 3 ? "0" + day.substring(0, 1) : day.substring(0, 2);
        String monthStr = months.get(month);

        return year + "-" + monthStr + "-" + dayStr;
    }

    private static Map<String, String> getMonths(){
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");
        return months;
    }

    public static void main(String[] args) {
        ReformatDate sol = new ReformatDate();
        String date1 = "20th Oct 2052";
        System.out.println(sol.reformatDate(date1));
        String date2 = "3rd Jul 1988";
        System.out.println(sol.reformatDate(date2));
    }
}
