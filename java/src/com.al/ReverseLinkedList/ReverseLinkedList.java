package com.al.ReverseLinkedList;

import com.al.linkedlist.ListNode;

public class ReverseLinkedList {
    class Solution {
        /**
         * reverse list by recur
         * @param root reverse start, after reverse the root will be the tail
         * @return
         */
        public ListNode reverseList(ListNode root) {
            if (root == null  || root.next == null)  return root;
            ListNode newHeader = reverseList(root.next);
            root.next.next = root;
            root.next = null;
            return newHeader;
        }
    }

    public static void main(String[] args) {
        Solution sl = new ReverseLinkedList().new Solution();
        ListNode l = ListNode.generate("1->2->3->4->5->null");
        System.out.println("---------");
        ListNode rev = sl.reverseList(l);
        ListNode.print(rev);

        l = ListNode.generate("1->2->null");
        System.out.println("---------");
        rev = sl.reverseList(l);
        ListNode.print(rev);
    }
}
