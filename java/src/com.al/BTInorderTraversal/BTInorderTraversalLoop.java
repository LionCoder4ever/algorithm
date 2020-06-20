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
            TreeNode cur = root;
            while (cur != null || !st.isEmpty()) {
                while (cur != null) {
                    st.add(cur);
                    cur = cur.left;
                }
                cur = st.pop();
                al.add(cur.val);
                cur = cur.right;
            }
            return al;
        }
    }

    public static void main(String[] args) {
        Solution sl = new BTInorderTraversalLoop().new Solution();
        TreeNode t = TreeNode.deserialize("1,2,3,#,#,4,5,#,#,#,6,7,#,#,#");
        System.out.println(sl.inorderTraversal(t));
    }
}
