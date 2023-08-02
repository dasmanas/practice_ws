package com.practice.ds.heap;

import java.util.*;

//https://leetcode.com/problems/ipo/
public class MaximizeCapital {

    class Project implements Comparable<Project> {
        int capital;
        int profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        @Override
        public int compareTo(Project o) {
            return capital - o.capital;
        }
    }

    public int maximumCapital(int k, int w, int[] profits, int[] capital) {
        if (k == 0) {
            return w;
        }
        if (capital.length == 0 || capital.length != profits.length) {
            return w;
        }
        int projectsLen = capital.length;
        Project[] projects = new Project[projectsLen];

        for (int i = 0; i < projectsLen; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }
        Arrays.sort(projects);
        int projectSelectionPointer = 0;
        int projectDone = 0;
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        while (projectSelectionPointer < projectsLen && w >= projects[projectSelectionPointer].capital) {
            maxHeap.offer(projects[projectSelectionPointer++].profit);
        }

        while (!maxHeap.isEmpty() && projectDone < k) {
            w = w + maxHeap.poll();
            projectDone++;
            while (projectSelectionPointer < projectsLen && projectDone < k && w >= projects[projectSelectionPointer].capital) {
                maxHeap.offer(projects[projectSelectionPointer++].profit);
            }
        }
        return w;
    }


    public static void main(String[] args) {
        MaximizeCapital maximizeCapital = new MaximizeCapital();

        int i = maximizeCapital.maximumCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});
        System.out.println(i);
    }
}

