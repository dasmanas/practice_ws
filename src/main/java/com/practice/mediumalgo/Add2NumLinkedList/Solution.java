package com.practice.mediumalgo.Add2NumLinkedList;

public class Solution {

    public static void main(String args[]){

        /*
        [2,4,3]
        [5,6,4]
        */
        ListNode l11 = new ListNode(2,null);
        ListNode l12 = new ListNode(4,null);
        ListNode l13 = new ListNode(3,null);

        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(5,null);
        ListNode l22 = new ListNode(6,null);
        ListNode l23 = new ListNode(4,null);
        l21.next = l22;
        l22.next = l23;

        Solution sol = new Solution();

        System.out.println(sol.addTwoNumbers(l11, l21));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r = new ListNode(0); //Space complexity O(max(m,n)+1) -> O(n)
        ListNode r_h = r;
        int carry = 0;

        while(l1!=null || l2!=null){
            int val1, val2;
            val1 = val2 = 0;
            if(l1!=null){
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = val1 + val2 + carry;
            carry = sum > 9 ? 1 : 0;
            sum = sum % 10;

            r.next = new ListNode(sum);
            r = r.next;
        }
        if(carry>0){
            r.next = new ListNode(carry);
        }
        return r_h.next;
    }
}
