package com.alg.pointers;

import com.alg.common.ListNode;

import java.util.List;

/**
 * Find the middle node of a linked list.
 *
 * Example
 * Example 1:
 *
 * Input:  1->2->3
 * Output: 2
 * Explanation: return the value of the middle node.
 * Example 2:
 *
 * Input:  1->2
 * Output: 1
 * Explanation: If the length of list is  even return the value of center left one.
 * Challenge
 * If the linked list is in a data stream, can you find the middle without iterating the linked list again?
 */
public class MiddleOfLinkedList {
    /**
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {
        // write your code here
        if(head == null) return head;
        ListNode p1 = head, p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n7;

        MiddleOfLinkedList ins = new MiddleOfLinkedList();
        ListNode mid = ins.middleNode(n1);
        System.out.println(mid.val);
    }
}
