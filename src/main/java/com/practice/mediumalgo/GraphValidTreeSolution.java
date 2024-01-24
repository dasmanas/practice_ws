package com.practice.mediumalgo;

import java.util.*;

public class GraphValidTreeSolution {

    //Adjacency Map from the edge information
    private Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
    private Set<Integer> seen = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {

        if (n == 0) return true;

        //convert the input into adjacency list
        for (int[] edge : edges) {
            adjacencyMap.computeIfAbsent(edge[0], key -> new ArrayList<Integer>()).add(edge[1]);
            adjacencyMap.computeIfAbsent(edge[1], key -> new ArrayList<Integer>()).add(edge[0]);
        }
        return dfs(0, -1) && seen.size() == n;

    }

    public boolean dfs(int node, int parent) {
        if (seen.contains(node)) return false;
        seen.add(node);
        for (int neighbour : adjacencyMap.getOrDefault(node, new ArrayList<>())) {
            if (neighbour != parent) {
                boolean result = dfs(neighbour, node);
                if (!result) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        GraphValidTreeSolution gvt = new GraphValidTreeSolution();
        System.out.println(gvt.validTree(3, new int[][]{{2, 3}, {1, 2}}));
    }
}
