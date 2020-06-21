package com.al.NaryTreePreorderTraversal;

import java.util.*;

/**
 *  lc #589
 */
public class NaryTreePreorderTraversal {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    class Solution {
        public List<Integer> preorder(Node root) {
            ArrayList<Integer> al = new ArrayList<>();
            Deque<Node> de = new ArrayDeque();
            if (root == null) return al;
            de.push(root);
            while (!de.isEmpty()) {
                Node cur = de.pop();
                al.add(cur.val);
                for (int i = cur.children.size() - 1; i >= 0; i--) {
                    de.push(cur.children.get(i));
                }
            }
            return al;
        }
    }

    public static void main(String[] args) {
        Solution sl = new NaryTreePreorderTraversal().new Solution();
        Node root = new Node(1, null);
        root.children = new ArrayList<>();
        Node left1 = new Node(3, Arrays.asList(new Node[]{new Node(5, new ArrayList<>()), new Node(6, new ArrayList<>())}));
        root.children.add(left1);
        root.children.add(new Node(2, new ArrayList<>()));
        root.children.add(new Node(4, new ArrayList<>()));
        System.out.println(sl.preorder(root));
    }
}
