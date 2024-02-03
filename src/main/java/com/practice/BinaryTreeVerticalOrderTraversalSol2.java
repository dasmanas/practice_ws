package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversalSol2 {

    int min = 0, max = 0;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Pair<K, V> {
        K k;
        V v;

        public Pair(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    // -3, -2, -1, 0, 1, 2, 3
    //  0,  1,  3, 4, 5, 6, 7
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        int[] range = dfsGetMinMaxRange(root, 0, new int[]{0, 0});
        for (int i = range[0]; i <= range[1]; i++) {
            result.add(new ArrayList<>());
        }
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        Queue<Pair<TreeNode, Integer>> nq = new LinkedList<>();

        int rootIndex = range[0] < 0 ? range[0] * -1 : range[0];
        q.offer(new Pair<>(root, rootIndex));
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> p = q.poll();
            TreeNode tn = p.k;
            int col = p.v;
            result.get(col).add(tn.val);
            if (tn.left != null) nq.offer(new Pair(tn.left, col-1));
            if (tn.right != null) nq.offer(new Pair(tn.right, col+1));
            if(q.isEmpty()){
                q = nq;
                nq = new LinkedList<>();
            };
        }
        return result;
    }


    public int[] dfsGetMinMaxRange(TreeNode node, int col, int[] range) {
        if (node == null) return range;
        int[] newRange = {Math.min(col, range[0]), Math.max(col, range[1])};
        int lRange[] = dfsGetMinMaxRange(node.left, col - 1, newRange);
        int rRange[] = dfsGetMinMaxRange(node.right, col + 1, newRange);
        return new int[]{Math.min(lRange[0], rRange[0]), Math.max(lRange[1], rRange[1])};
    }

    public static void main(String[] args) {
        BinaryTreeVerticalOrderTraversalSol2 sol = new BinaryTreeVerticalOrderTraversalSol2();
        TreeNode root = sol.setupTree();
        sol.verticalOrder(root);

    }

    TreeNode setupTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);
        return root;
    }


}
