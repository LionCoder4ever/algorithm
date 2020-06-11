package com.al;

public class BSTTest {
    public static void main(String[] args) {
        BST bst = new BST();
        BST.Node root = bst.new Node(33);
        int[] arr = {16,50,13,18,34,58,15,17,25,51,66,19,27,55};
        for (int i1 : arr) {
            bst.insert(root, i1);
        }
        bst.preOrder(root);
        System.out.println("delete nodes ===========");
        try {
            bst.delete(root, 13);
            bst.delete(root, 18);
            bst.delete(root, 55);
        } catch (Exception e) {
            e.printStackTrace();
        }
        bst.inOrder(root);
    }
}
