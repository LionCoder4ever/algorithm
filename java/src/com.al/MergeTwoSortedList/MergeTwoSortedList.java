package com.al.MergeTwoSortedList;

import com.al.linkedlist.ListNode;

public class MergeTwoSortedList {
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dh = new ListNode(-1);
            ListNode cur = dh;
            while (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    cur.next = l2;
                    l2 = l2.next;
                } else {
                    cur.next = l1;
                    l1 = l1.next;
                }
                cur = cur.next;
            }
            if (l1 == null && l2 != null) {
                cur.next = l2;
            }
            if (l2 == null && l1 != null) {
                cur.next = l1;
            }
            return dh.next;
        }
    }

    public static void main(String[] args) {
        Solution sl = new MergeTwoSortedList().new Solution();
        ListNode l = sl.mergeTwoLists(ListNode.generate("1->2->4->null"), ListNode.generate("1->3->4->null"));
        ListNode.print(l);
        System.out.println("-----");

        l = sl.mergeTwoLists(ListNode.generate("1->6->null"), ListNode.generate("1->3->4->null"));
        ListNode.print(l);
        System.out.println("-----");
    }
}
