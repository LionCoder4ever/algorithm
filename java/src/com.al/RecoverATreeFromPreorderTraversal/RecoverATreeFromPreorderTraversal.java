package com.al.RecoverATreeFromPreorderTraversal;

import com.al.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecoverATreeFromPreorderTraversal {
    class Solution {
        public TreeNode recoverFromPreorder(String S) {
            if (S.isEmpty()) return null;
            // use stack
            Deque<TreeNode> deque = new ArrayDeque<>();
            int pos = 0;
            while (pos < S.length()) {
                int level = 0;
                // get node level
                while (pos < S.length() && S.charAt(pos) == '-') {
                       pos++;
                       level++;
                }
                // get node val
                int value = 0;
                while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
                    value = value * 10 + S.charAt(pos) - '0';
                    pos++;
                }
                TreeNode t = new TreeNode(value);
                //   S--T,  T is the S left node, or one of the root->T's node's right node
                if (level == deque.size())  {
                   if (!deque.isEmpty()) deque.peek().left = t;
                } else {
                    while (level != deque.size()) {
                        deque.pop();
                    }
                    deque.peek().right = t;
                }
                deque.push(t);
            }
            while (deque.size() > 1){
                deque.pop();
            }
            return deque.pop();
        }
    }

    public static void main(String[] args) {
        Solution sl = new RecoverATreeFromPreorderTraversal().new Solution();
        TreeNode.preOrder(sl.recoverFromPreorder("1-2--3--4-5--6--7"));
        System.out.println("---");
        TreeNode.preOrder(sl.recoverFromPreorder("1-2--3---4-5--6---7"));
        System.out.println("---");
        TreeNode.preOrder(sl.recoverFromPreorder("1-401--349---90--88"));
    }
}
