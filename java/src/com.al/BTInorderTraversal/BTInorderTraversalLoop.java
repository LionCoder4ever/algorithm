package com.al.BTInorderTraversal;

import com.al.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTInorderTraversalLoop {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> al = new ArrayList<>();
            if (root == null) return al;
            Stack<TreeNode> st = new Stack<>();
            while (root != null || !st.isEmpty()) {
                while (root != null) {
                    st.add(root);
                    root = root.left;
                }
                root = st.pop();
                al.add(root.val);
                root = root.right;
            }
            return al;
        }
    }

    public static void main(String[] args) {
        Solution sl = new BTInorderTraversalLoop().new Solution();
        TreeNode t = TreeNode.deserialize("1,#,2,3,#,#,#");
        System.out.println(sl.inorderTraversal(t));
    }
}
