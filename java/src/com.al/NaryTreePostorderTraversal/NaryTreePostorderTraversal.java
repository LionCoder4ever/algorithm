package com.al.NaryTreePostorderTraversal;


import java.util.*;

/**
 * lc #590
 */
public class NaryTreePostorderTraversal {
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
        public List<Integer> postorder(Node root) {
            LinkedList<Integer> ll = new LinkedList<>();
            if (root == null) return ll;
            Deque<Node> de = new ArrayDeque<>();
            de.push(root);
            while (!de.isEmpty()) {
                Node cur = de.pop();
                // put the root val at the last position
                ll.addFirst(cur.val);
                for (int i = 0; i < cur.children.size(); i++) {
                    //  stack position left -> right , pop order: right -> left, list postion left -> right
                    de.push(cur.children.get(i));
                }
            }
            return ll;
        }
    }

    public static void main(String[] args) {
        Solution sl = new NaryTreePostorderTraversal().new Solution();
        Node root = new Node(1, null);
        root.children = new ArrayList<>();
        Node left1 = new Node(3, Arrays.asList(new Node[]{new Node(5, new ArrayList<>()), new Node(6, new ArrayList<>())}));
        root.children.add(left1);
        root.children.add(new Node(2, new ArrayList<>()));
        root.children.add(new Node(4, new ArrayList<>()));
        System.out.println(sl.postorder(root));
    }
}
