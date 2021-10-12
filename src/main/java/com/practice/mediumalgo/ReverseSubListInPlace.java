package com.practice.mediumalgo;

import java.util.*;


class ReverseSubListInPlace {

    private static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode reverse(ListNode head, int p, int q) {

        if(p >= 0 && p < q){
            int i=0;
            ListNode cur = head, prev = null;

            while(i < p && cur!=null){
                prev = cur;
                cur = cur.next;
                i++;
            }

            ListNode nxt = null, subStart = cur;
            while(cur!=null && i<=q){
                nxt = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nxt;
                i++;
            }

            if(subStart.next!=null){
                subStart.next.next = prev;
            }else{
                head = prev;
            }
            subStart.next = cur;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ReverseSubListInPlace.ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ReverseSubListInPlace reverseSubListInPlace = new ReverseSubListInPlace();

        ListNode result = reverseSubListInPlace.reverse(head, 0, 5);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}