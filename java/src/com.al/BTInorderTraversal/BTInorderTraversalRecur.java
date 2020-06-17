package com.al.BTInorderTraversal;

import com.al.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BTInorderTraversalRecur {
    class Solution {
        void inorder(TreeNode root,ArrayList<Integer> al){
            if (root == null) return;
            inorder(root.left, al);
            al.add(root.val);
            inorder(root.right, al);
        }
        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> al = new ArrayList<>();
            if (root == null) return al;
            inorder(root, al);
            return al;
        }
    }

    public static void main(String[] args) {
        Solution sl = new BTInorderTraversalRecur().new Solution();
        TreeNode t = TreeNode.deserialize("1,#,2,3,#,#,#");
        System.out.println(sl.inorderTraversal(t));
    }
}
