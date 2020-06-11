package com.al;

class BST
{
    class Node
    {
        private Node left,right;
        private int val;
        Node(int n)
        {
            this.val = n;
        }
    }
    void inOrder(Node node){
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println("val:" + node.val);
        inOrder(node.right);
    }
    void preOrder(Node node){
        if (node == null)
            return;
        System.out.println("val:" + node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    void insert(Node node, int n){
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

    void delete(Node node,int data) throws Exception {
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
        // found two child
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
}
