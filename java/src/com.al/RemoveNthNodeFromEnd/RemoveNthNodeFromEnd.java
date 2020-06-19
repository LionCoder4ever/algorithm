package com.al.RemoveNthNodeFromEnd;

import com.al.linkedlist.ListNode;

public class RemoveNthNodeFromEnd {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (n < 1) return head;
            int p = 0;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            // fast ,slow pointer
            ListNode fast = dummy, slow = dummy;
            while (fast.next != null) {
                if (p < n) {
                    fast = fast.next;
                    p++;
                    continue;
                }
                if (p == n) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            // if n > list.length, return head
            if (p < n) {
                return head;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        Solution sl = new RemoveNthNodeFromEnd().new Solution();
        ListNode t = sl.removeNthFromEnd(ListNode.generate("1->2->3->4->5->null"), 4);
        ListNode.print(t);
    }
}
