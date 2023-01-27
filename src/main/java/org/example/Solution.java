package org.example;

public class Solution {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     * <p>
     * Input: l1 = [9,9,9,9,9,9,9],
     * l2 = [9,9,9,9]
     * Output:     [8,9,9,9,0,0,0,1]
     */

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
//        ListNode l1 = new ListNode(0);
//        ListNode l2 = new ListNode(0);
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        display(l2);
        ListNode listNode = addTwoNumbers(l1, l2);
        display(listNode);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode l1Next = l1 == null ? null : l1.next;
        ListNode l2Next = l2 == null ? null : l2.next;
        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l2 == null ? 0 : l2.val;
        int res = val1 + val2;
        if (res > 9) {
            res = res % 10;
            if (l1Next != null) {
                l1Next.val += 1;
            } else if (l2Next != null) {
                l2Next.val += 1;
            } else {
                l1Next = new ListNode(1);
            }
        }
        if (l1Next == null && l2Next == null) {
            result.val = res;
            return result;
        }
        return new ListNode(res, addTwoNumbers(l1Next, l2Next));
    }

    public static void display(ListNode n) {
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }
}

