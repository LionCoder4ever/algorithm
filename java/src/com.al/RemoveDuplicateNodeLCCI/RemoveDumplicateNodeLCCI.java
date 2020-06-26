package com.al.RemoveDuplicateNodeLCCI;

import com.al.linkedlist.ListNode;

import java.util.HashSet;

public class RemoveDumplicateNodeLCCI {
    class Solution {
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null || head.next == null) return head;
            HashSet<Integer> hs = new HashSet<>();
            ListNode dummpy = new ListNode(-1);
            dummpy.next = head;
            ListNode cur = head, pre = dummpy;
            while (cur != null) {
                if (!hs.contains(cur.val)){
                    hs.add(cur.val);
                    pre.next = cur;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            pre.next = null;
            return dummpy.next;
        }
    }

    public static void main(String[] args) {
        Solution sl = new RemoveDumplicateNodeLCCI().new Solution();
        ListNode header = new ListNode(1);
        header.next = new ListNode(2);
        header.next.next = new ListNode(3);
        header.next.next.next = new ListNode(3);
        header.next.next.next.next = new ListNode(2);
        header.next.next.next.next.next = new ListNode(1);
        ListNode h = sl.removeDuplicateNodes(header);
        ListNode.print(h);
    }
}
