package com.jun.blog;


/**
 * Created by jun on 7/21/2017.
 */
public class Main {

    static int[] values = {20,15,25,10,18,30,12};

    static public class BinarySearchTreeNode {
        public int value = 0;
        public BinarySearchTreeNode parent = null;
        public BinarySearchTreeNode left = null;
        public BinarySearchTreeNode right = null;
        public BinarySearchTreeNode(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeNode root = null;
        for(int i=0; i<values.length; i++) {
            root = add(values[i], root, null);
        }
        printBST(root);

        System.out.println("search 18 = " + (search(root, 18)==null?"failure":"success"));
        System.out.println("search 22 = " + (search(root, 22)==null?"failure":"success"));

        System.out.println("it will delete 15");
        BinarySearchTreeNode deleteNode15 = search(root, 15);
        if(deleteNode15 != null && deleteNode15.parent != null) {
            System.out.println("delete 15 = " + (delete(deleteNode15) == null ? "failure" : "success"));
        }else{
            root = null;
            System.out.println("There is no any node.");
        }
        printBST(root);
    }

    static public BinarySearchTreeNode add(int value, BinarySearchTreeNode node, BinarySearchTreeNode parent){
        if(node == null) {
            node = new BinarySearchTreeNode(value);
            node.parent = parent;
        }else {
            if (value < node.value) {
                node.left = add(value, node.left, node);
            } else {
                node.right = add(value, node.right, node);
            }
        }
        return node;
    }

    static public BinarySearchTreeNode search(BinarySearchTreeNode node, int value){
        if(node != null) {
            if(value == node.value){
                return node;
            }else if (value < node.value) {
                return search(node.left, value);
            } else {
                return search(node.right, value);
            }
        }else{
            return null;
        }
    }

    static public BinarySearchTreeNode delete(BinarySearchTreeNode node){
        if(node != null){
            if (node.left == null && node.right == null) {
                if(node.parent == null){
                    node = null;
                    return node;
                } else if (node.parent.left != null && node.parent.left.value == node.value) {
                    node.parent.left = null;
                } else if (node.parent.right != null && node.parent.right.value == node.value) {
                    node.parent.right = null;
                }
                return node.parent;
            } else if (node.left != null && node.right != null) {
                node.value = node.right.value;
                node = delete(node.right);
            } else {
                BinarySearchTreeNode parent = node.parent;
                BinarySearchTreeNode n = node.left == null ? node.right : node.left;
                n.parent = parent;
                if (node.parent.left != null && node.parent.left.value == node.value) {
                    node.parent.left = n;
                } else if (node.parent.right != null && node.parent.right.value == node.value) {
                    node.parent.right = n;
                }
                node = n;
            }
        }
        return node;
    }

    static public void printBST(BinarySearchTreeNode node){
        System.out.print("node = " + node.value);
        System.out.print(", node.parent = " + (node.parent==null?"null":node.parent.value));
        System.out.print(", left=" + (node.left==null?"null":node.left.value));
        System.out.print(", right=" + (node.right==null?"null":node.right.value));
        System.out.println("");
        if(node.left != null){
            printBST(node.left);
        }
        if(node.right != null){
            printBST(node.right);
        }
    }

}
