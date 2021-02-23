package com.alg.string;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int L1 = num1.length() - 1;// Will be used as pointers to get value from num
        int L2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(L1 >= 0 || L2 >= 0) {
            int x1 = 0;
            int x2 = 0;
            if(L1 >= 0) {
                x1 = num1.charAt(L1) - '0';// This operation transforms char to int
            }
            if(L2 >= 0) {
                x2 = num2.charAt(L2) - '0';
            }
            L1--; L2--;
            int sum = x1 + x2 + carry;
            if(sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(sum);
        }
        // DON't FORGET TO ADD CARRY!!
        if(carry != 0) sb.append(carry);
        String result = sb.reverse().toString();// StringBuilder had been appending in reversed order like 987...321
        return result;
    }

    public static void main(String[] args) {
        AddStrings s = new AddStrings();

        String num1 = "924";
        String num2 = "96";
        System.out.println(s.addStrings(num1, num2));
    }
}
