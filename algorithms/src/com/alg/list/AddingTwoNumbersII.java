package com.alg.list;


import java.util.Stack;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class AddingTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();

        while(l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode current = new ListNode();

        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            int num1 = stack1.pop();
            int num2 = stack2.pop();
            int sum = num1 + num2 + carry;
            ListNode node = new ListNode();
            current.val = sum % 10;
            node.next = current;
            current = node;

            if(sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            // System.out.println("current val: " + current.val);
            // System.out.println("num1: "+ num1+ " num2: "+ num2);
        }

        while(stack1.isEmpty() && !stack2.isEmpty()) {
            int num = stack2.pop();
            int sum = num + carry;
            ListNode node = new ListNode();
            current.val = sum % 10;
            node.next = current;
            current = node;

            if(sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
        }

        while(!stack1.isEmpty() && stack2.isEmpty()) {
            int num = stack1.pop();
            int sum = num + carry;
            ListNode node = new ListNode();
            current.val = sum % 10;
            node.next = current;
            current = node;

            if(sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
        }

        if(carry != 0) {
            current.val = carry;
            return current;
        }
        return current.next;
    }
}
