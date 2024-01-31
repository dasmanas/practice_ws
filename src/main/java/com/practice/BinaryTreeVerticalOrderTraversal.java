package com.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinaryTreeVerticalOrderTraversal {

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

    /**
     *
     */
    Map<Integer, Map<Integer, List<Integer>>> tableMap = new LinkedHashMap<>();

    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();


        Stream<Map.Entry<Integer, Map<Integer, List<Integer>>>> sorted = tableMap.entrySet().stream().sorted((o1, o2) -> Integer.compare(o1.getKey(), o2.getKey()));
        sorted.flatMap(e -> e.getValue().)

        for (Map.Entry<Integer, Map<Integer, List<Integer>>> entry : tableMap.entrySet()) {
            Map<Integer, List<Integer>> rowMap = entry.getValue();

            List<Integer> collectedRowValues = rowMap.entrySet().stream().sorted((o1, o2) -> Integer.compare(o1.getKey(), o2.getKey()))
                    .flatMap(e -> e.getValue().stream()).collect(Collectors.toList());

            result.add(collectedRowValues);
        }
        return result;
    }

    public void dfs(TreeNode node, int row, int col) {
        if (node == null) return;

        tableMap.computeIfAbsent(col, colKey -> new HashMap<Integer, List<Integer>>())
                .computeIfAbsent(row, rowKey -> new ArrayList<Integer>())
                .add(node.val);

        dfs(node.left, row + 1, col - 1);
        dfs(node.right, row + 1, col + 1);
    }

    public static void main(String[] args) {
        BinaryTreeVerticalOrderTraversal sol = new BinaryTreeVerticalOrderTraversal();

        TreeNode root = sol.setupTree();

        sol.verticalOrder(root);

    }

    public TreeNode setupTree() {

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
