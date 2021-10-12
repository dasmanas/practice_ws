package com.practice.easyalgo;

public class Add2NumLinkedList {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
            ListNode cur = head;

        while (l1 != null || l2 != null) {
            int lv1, lv2, r;

            if (l1.next != null) {
                l1 = l1.next;
                lv1 = l1.val;
            } else {
                lv1 = 0;
            }

            if (l2.next != null) {
                l2 = l2.next;
                lv2 = l2.val;
            } else {
                lv2 = 0;
            }
            r = lv1 + lv2;
            ListNode rln = new ListNode(r);
            cur.next = rln;
            cur = rln;
        }
        return (head.next==null) ? head : head.next;

    }



}
