package com.practice.hardalgo;

import java.util.*;

//https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/
public class MaximizeProfitInJobSchedulingSolution {


    //Job class to organize Job related parameters
    class Job {
        int start, end, profit;
        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    //Job Chain class to organize the Job Sequencing to identify maximum profit and end time
    class JobChain {
        int end, profit;
        public JobChain(int end, int profit) {
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        Job[] jobs = new Job[len];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, (j1, j2) -> Integer.compare(j1.start, j2.start));

        //Min Heap order by End Time of the Job
        Queue<JobChain> minHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.end, o2.end));

        //Iterate over all the jobs
        for (Job job : jobs) {
            int prevMaxProfit = 0;
            int prevMaxEnd = 0;
            //All the job chains (Job sequences) finished before the start of the current job
            //Find the maximum profit from 
            while (minHeap.peek() != null && minHeap.peek().end <= job.start) {
                prevMaxProfit = Math.max(minHeap.peek().profit, prevMaxProfit);
                prevMaxEnd = Math.max(minHeap.peek().end, prevMaxEnd);
                minHeap.poll();
            }


            if(prevMaxProfit>0){
                minHeap.offer(new JobChain(prevMaxEnd, prevMaxProfit));
            }
            minHeap.offer(new JobChain(job.end, prevMaxProfit + job.profit));
        }
        int maxProfit = 0;
        while (!minHeap.isEmpty()){
            maxProfit = Math.max(maxProfit, minHeap.poll().profit);
        }
        return maxProfit;
    }


}
