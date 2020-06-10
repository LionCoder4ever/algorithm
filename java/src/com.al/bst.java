package com.al;

class BST
{
    public static class Node
    {
        private Node left,right;
        private int val;
        public Node(int n)
        {
            this.val = n;
        }
    }
    public static void preOrder(Node node){
        if (node == null)
            return;
        System.out.println("val:" + node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void insert(Node node, int n){
        if (node ==null)
            return;
        if (n < node.val){
            if(node.left == null){
               node.left = new Node(n);
            } else {
                insert(node.left,n);
            }
        } else {
            if(node.right == null){
                node.right = new Node(n);
            } else {
                insert(node.right,n);
            }
        }
    }

    static void delete(Node node,int data) throws Exception {
        // find node p
        Node p = node, pp = null;
        while (p != null && p.val != data){
            pp = p;
            if (data > p.val) p = p.right;
            else p = p.left;
        }
        // not found
        if (p == null) return;
        System.out.println("=====find: "+ data);
        // found
        // two child
        if (p.left != null && p.right != null) {
            Node minP = p.right, minPP = p;
            while(minP.left != null){
               minPP = minP;
               minP = minP.left;
            }
            p.val = minP.val;
            p =  minP;
            pp =  minPP;
        }
        // single child or null child
        Node child;
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        if (pp == null) throw new Exception("del root node");
        else if (pp.left == p) pp.left = child;
        else pp.right = child;
    }
    public static void main(String[] args) {
        Node root = new Node(33);
        int[] arr = {16,50,13,18,34,58,15,17,25,51,66,19,27,55};
        for (int i1 : arr) {
            insert(root, i1);
        }
        preOrder(root);
        System.out.println("delete nodes ===========");
        try {
            delete(root, 13);
            delete(root, 18);
            delete(root, 55);
        } catch (Exception e) {
            e.printStackTrace();
        }
        preOrder(root);
    }
}
