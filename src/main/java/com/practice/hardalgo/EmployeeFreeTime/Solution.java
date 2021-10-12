package com.practice.hardalgo.EmployeeFreeTime;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };

    class EmployeeInterval {
        public int empIndex;
        public int intervalIndex;
        public Interval interval;

        public EmployeeInterval(int empIndex, int intervalIndex, Interval interval){
            this.empIndex = empIndex;
            this.intervalIndex = intervalIndex;
            this.interval = interval;
        }

    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        List<Interval> gapIntervals = new ArrayList<>();
        int empSize = schedule.size();

        PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.interval.start, b.interval.start));

        //inserting the first interval of all employees
        for(int i=0; i<empSize; i++){
            minHeap.offer(new EmployeeInterval(i,0, schedule.get(i).get(0)));
        }

        Interval mergeInterval = null;
        Interval gapInterval = null;

        EmployeeInterval ei = minHeap.poll();

        while (ei!=null){
            if(mergeInterval==null){
                mergeInterval = new Interval(ei.interval.start, ei.interval.end);
                if(gapInterval!=null){
                    gapInterval.end = mergeInterval.start;
                    gapIntervals.add(gapInterval);
                    gapInterval = null;
                }
            } else {
                if(mergeInterval.end>=ei.interval.start){
                    mergeInterval.end = Math.max(mergeInterval.end, ei.interval.end);
                } else{
                    gapInterval = new Interval();
                    gapInterval.start = mergeInterval.end;
                    mergeInterval = null;
                }
            }

            int empIndex = ei.empIndex;
            int nextIntervalIndex = ei.intervalIndex + 1;

            Interval nextInterval = (schedule.get(empIndex).size()>nextIntervalIndex) ? schedule.get(empIndex).get(nextIntervalIndex) : null;
            if(nextInterval!=null){
                minHeap.offer(new EmployeeInterval(empIndex, nextIntervalIndex, nextInterval));
            }

            ei = minHeap.poll();
        }

        return gapIntervals;
    }


}
