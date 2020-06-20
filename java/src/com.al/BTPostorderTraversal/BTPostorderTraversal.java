package com.al.BTPostorderTraversal;

import com.al.tree.TreeNode;

import java.util.*;

public class BTPostorderTraversal {
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> ll = new LinkedList();
            if (root == null)  return ll;
            Deque<TreeNode> de = new ArrayDeque<>();
            de.add(root);
            while (!de.isEmpty()) {
                TreeNode cur = de.pop();
                //  FILO
                ll.addFirst(cur.val);
                if (cur.left != null) de.push(cur.left);
                if (cur.right != null) de.push(cur.right);
            }
            return ll;
        }
    }

    public static void main(String[] args) {
        Solution sl = new BTPostorderTraversal().new Solution();
        TreeNode t = TreeNode.deserialize("1,2,3,#,#,4,5,#,#,#,6,7,#,#,#");
        List<Integer> al = sl.postorderTraversal(t);
        System.out.println(al);
    }
}
