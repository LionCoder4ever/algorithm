package com.al.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
    static StringBuilder serialhelper(TreeNode root, StringBuilder builder) {
        if (root == null) {
            return builder.append("#,");
        }
        builder.append(root.val).append(',');
        builder = serialhelper(root.left, builder);
        builder = serialhelper(root.right, builder);
        return builder;
    }

    // Encodes a tree to a single string.
    static String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialhelper(root, builder);
        return builder.toString();
    }

    static TreeNode deserialhelper(ArrayList<String> al) {
        if (al.get(0).equals("#")) {
            al.remove(0);
            return null;
        }
        TreeNode tn = new TreeNode(Integer.valueOf(al.remove(0).toString()));
        tn.left = deserialhelper(al);
        tn.right = deserialhelper(al);
        return tn;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        return deserialhelper(new ArrayList<>(Arrays.asList(data.split(","))));
    }

    public static void preOrder(TreeNode t){
        if (t == null) return;
        System.out.println(t.val);
        preOrder(t.left);
        preOrder(t.right);
    }
}

