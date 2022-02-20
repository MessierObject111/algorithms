package com.alg.highFrequency.goldman;

import com.alg.common.SinglyLinkedListNode;

import java.util.HashSet;

public class CondensedLinkedList {

    public static SinglyLinkedListNode condense(SinglyLinkedListNode head) {
        if(head == null) return null;
        SinglyLinkedListNode p1 = head;
        SinglyLinkedListNode p2 = p1.next;
        HashSet<Integer> knownValues = new HashSet<>();
        knownValues.add(p1.data);
        while(p2 != null) {
            if(knownValues.contains(p2.data)) {
                p1.next = p2.next;
            } else {
                knownValues.add(p2.data);
            }
            p1 = p1.next;
            p2 = p1.next;
        }
        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedListNode n1 = new SinglyLinkedListNode(1);

    }
}
