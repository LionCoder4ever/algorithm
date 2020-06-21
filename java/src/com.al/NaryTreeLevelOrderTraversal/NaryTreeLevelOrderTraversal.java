package com.al.NaryTreeLevelOrderTraversal;

import java.util.*;

/**
 *  lc #429 n-ary tree level order traversal
 */
public class NaryTreeLevelOrderTraversal {
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

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> al = new ArrayList<>();
            if (root == null) return al;
            Queue<Node> qe = new LinkedList<>();
            qe.add(root);
            while (!qe.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = qe.size();
                for (int i = 0; i < size; i++) {
                    Node cur = qe.poll();
                    level.add(cur.val);
                    qe.addAll(cur.children);
                }
                al.add(level);
            }
            return  al;
        }
    }

    public static void main(String[] args) {
        Solution sl = new NaryTreeLevelOrderTraversal().new Solution();
        // [1,null,3,2,4,null,5,6]
        Node root = new Node(1, null);
        root.children = new ArrayList<>();
        Node left1 = new Node(3, Arrays.asList(new Node[]{new Node(5,new ArrayList<>()), new Node(6,new ArrayList<>())}));
        root.children.add(left1);
        root.children.add(new Node(2, new ArrayList<>()));
        root.children.add(new Node(4,new ArrayList<>()));
        System.out.println(sl.levelOrder(root));
    }
}
