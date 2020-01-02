package com.practice.tree.avltree;

public class AvlTreeNode {
    int data;
    int height;
    AvlTreeNode left;
    AvlTreeNode right;

    public AvlTreeNode(int data) {
        this.data = data;
        this.height = 1;
    }
}
