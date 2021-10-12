package com.practice.tree.traversal.zigzag;

import com.practice.tree.traversal.dfs.DfsNeighbourListUsingStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagTraversal {

    private static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(){}

        TreeNode(int data){
            this.data = data;
        }

        TreeNode(int data, TreeNode left, TreeNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> traverseZigzagLevelOrder(TreeNode root){

        Stack<TreeNode> curStack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();
        curStack.push(root);

        boolean l2r = true;
        List<List<Integer>> fullList = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();


        while(!curStack.isEmpty()){
            TreeNode tn = curStack.pop();
            levelList.add(tn.data);
            if(l2r){
                if(tn.left!=null){
                    nextStack.push(tn.left);
                }
                if(tn.right!=null){
                    nextStack.push(tn.right);
                }
            }else{
                if(tn.right!=null){
                    nextStack.push(tn.right);
                }
                if(tn.left!=null){
                    nextStack.push(tn.left);
                }
            }

            if(curStack.isEmpty()){
                fullList.add(levelList);
                levelList = new ArrayList<>();
                if(!nextStack.isEmpty()){
                    curStack = nextStack;
                    nextStack = new Stack<>();
                    l2r = !l2r;
                }
            }
        }
        return fullList;
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right .right = new TreeNode(7);

        ZigZagTraversal zt = new ZigZagTraversal();
        System.out.println(zt.traverseZigzagLevelOrder(root));
    }


}
