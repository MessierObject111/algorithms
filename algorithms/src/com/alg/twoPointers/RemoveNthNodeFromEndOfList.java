package com.alg.twoPointers;

import com.alg.common.ListNode;

public class RemoveNthNodeFromEndOfList {
    /**
     * For questions involves removing some nodes from linked list, it usually involved a pseudo head that points to head
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //I thought it is not making sense to have a psuedo head at first, but this is the hidden common knowledge over
        // this kind of questions
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode vanguard = dummy;
        ListNode rear = dummy;

        for(int i = 0; i < n; i++) {
            vanguard = vanguard.next;
        }

        while(vanguard != null && vanguard.next != null) {
            rear = rear.next;
            vanguard = vanguard.next;
        }
        rear.next = rear.next.next;
        return dummy.next;
    }
}
