package com.al;

import org.junit.jupiter.api.Test;

public class PartitionList {
    @Test
    public void test() {
        Solution s = new Solution();
        ListNode l = new ListNode(1);
        l.next = new ListNode(4);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(2);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(2);

        ListNode ans = s.partition(l, 3);
        System.out.println("----------------");
        while (ans!=null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode partition(ListNode head, int x) {
            // add head node

            ListNode firstPartHead = new ListNode(-1), secondPartHead = new ListNode(-1);
            ListNode firstLoop = firstPartHead, secondLoop = secondPartHead;
            ListNode tmp = new ListNode(-1);
            while (head != null) {
                tmp = head.next;
                if (head.val < x) {
                    firstLoop.next = head;
                    firstLoop = firstLoop.next;
                    firstLoop.next = null;
                } else {
                    secondLoop.next = head;
                    secondLoop = secondLoop.next;
                    secondLoop.next = null;
                }
                head = tmp;
            }
            secondLoop.next = null;
            firstLoop.next = secondPartHead.next;
            return firstPartHead.next;
        }
    }

}
