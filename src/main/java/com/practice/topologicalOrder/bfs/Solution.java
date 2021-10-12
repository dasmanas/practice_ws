package com.practice.topologicalOrder.bfs;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 */

import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adjListMap = new HashMap<Integer, List<Integer>>();

        /**
         * Calculate adjacency Map
         * &
         * inDegree by destination
         */
        for(int i=0; i < prerequisites.length; i++){
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];

            List<Integer> lst = adjListMap.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjListMap.put(src, lst);
            inDegree[dest] += 1;
        }
        System.out.println("adjListMap");
        System.out.println(adjListMap);


        Queue<Integer> q = new LinkedList<Integer>();
        //Start with 0 indegree node
        for(int i=0; i < numCourses; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        System.out.println("inDegree");
        System.out.println(Arrays.toString(inDegree));

        int[] topologicalOrder = new int[numCourses];

        int i=0;
        while(!q.isEmpty()){
            int node = q.poll();
            topologicalOrder[i++] = node;
            if(adjListMap.containsKey(node)){

                for(Integer neighbor : adjListMap.get(node)) {
                    inDegree[neighbor]--;
                    if(inDegree[neighbor] == 0){
                        q.offer(neighbor);
                    }
                }
            }

        }

        if(i == numCourses) {
            return topologicalOrder;
        }

        return new int[0];

    }
}