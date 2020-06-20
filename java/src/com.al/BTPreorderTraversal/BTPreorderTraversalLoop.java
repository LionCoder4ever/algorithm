package com.al.BTPreorderTraversal;

import com.al.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BTPreorderTraversalLoop {
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            ArrayList<Integer> al = new ArrayList<>();
            if (root == null) return al;
            Deque<TreeNode> de = new ArrayDeque<>();
            de.add(root);
            while (!de.isEmpty()) {
                TreeNode cur = de.pop();
                al.add(cur.val);
                if (cur.right != null) de.push(cur.right);
                if (cur.left != null) de.push(cur.left);
            }
            return al;
        }
    }
    public static void main(String[] args){
        Solution sl = new BTPreorderTraversalLoop().new Solution();
        TreeNode t = TreeNode.deserialize("1,2,3,#,#,4,5,#,#,#,6,7,#,#,#");
        List<Integer> al = sl.preorderTraversal(t);
        System.out.println(al);
    }
}
