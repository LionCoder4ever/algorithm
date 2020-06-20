package com.al.BTPreorderTraversal;
import com.al.tree.*;
import java.util.*;

public class BTPreorderTraversalRecur {
	class Solution {
	    void preorder(TreeNode root, ArrayList<Integer> al){
		    if (root == null) return;
		    al.add(root.val);
		    preorder(root.left, al);
		    preorder(root.right, al);
	    }
	    public List<Integer> preorderTraversal(TreeNode root) {
		   if (root == null) return new ArrayList();
		   ArrayList al = new ArrayList();
		   preorder(root, al);
		   return al;
	    }
	}
	public static void main(String[] args){
		Solution sl = new BTPreorderTraversalRecur().new Solution();
		TreeNode t = TreeNode.deserialize("1,2,3,#,#,4,5,#,#,#,6,7,#,#,#");
		List<Integer> al = sl.preorderTraversal(t);
		System.out.println(al);
	}
    
}
