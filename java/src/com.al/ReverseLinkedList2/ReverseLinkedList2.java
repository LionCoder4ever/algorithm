package com.al.ReverseLinkedList2;

import com.al.linkedlist.ListNode;

public class ReverseLinkedList2 {
    class Solution {
        /**
         * reverse list by recur
         * @param root reverse start, after reverse the root will be the tail
         * @param end the new header return
         * @return
         */
        ListNode reverse(ListNode root, ListNode end) {
            if (root.next == end)  return root;
            ListNode newHeader = reverse(root.next, end);
            root.next.next = root;
            root.next = end;
            return newHeader;
        }

        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m<1 ||  n<=m) return head;
            // add dummy head
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode startPre = dummyHead;
            ListNode end = null;
            ListNode cur = dummyHead;
            int count =  0;
            while (cur != null) {
                if (count == m-1) {
                    startPre = cur;
                }
                if (count == n + 1) {
                    end = cur;
                    break;
                }
                cur = cur.next;
                count++;
            }
            startPre.next = reverse(startPre.next,end);
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        Solution sl = new ReverseLinkedList2().new Solution();
        ListNode l = ListNode.generate("1->2->3->4->5->null");
        System.out.println("---------");
        ListNode rev = sl.reverseBetween(l,2,4);
        ListNode.print(rev);

        l = ListNode.generate("1->2->3->4->5->null");
        System.out.println("---------");
        rev = sl.reverseBetween(l,1,5);
        ListNode.print(rev);
    }
}
