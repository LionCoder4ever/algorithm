package com.al.SerAndDeserBST;

import java.util.ArrayList;
import java.util.Arrays;

public class SerAndDeserBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public class Codec {

        StringBuilder serialhelper(TreeNode root, StringBuilder builder) {
            if (root == null){
                return builder.append("#,");
            }
            builder.append(root.val).append(',');
            builder = serialhelper(root.left,builder);
            builder = serialhelper(root.right,builder);
            return builder;
        }
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            serialhelper(root, builder);
            return builder.toString();
        }

        TreeNode deserialhelper(ArrayList al){
            if(al.get(0).equals("#")) {
                al.remove(0);
                return null;
            }
            TreeNode tn = new TreeNode(Integer.valueOf(al.remove(0).toString()));
            tn.left = deserialhelper(al);
            tn.right = deserialhelper(al);
            return tn;
        }
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return deserialhelper(new ArrayList(Arrays.asList(data.split(","))));
        }
    }
    public static void main(String[] args) {
        Codec sl = new SerAndDeserBST().new Codec();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.right.left = new TreeNode(4);
        t.right.right = new TreeNode(5);
        System.out.println(sl.serialize(t));
        TreeNode tn = sl.deserialize(sl.serialize(t));
    }
}
