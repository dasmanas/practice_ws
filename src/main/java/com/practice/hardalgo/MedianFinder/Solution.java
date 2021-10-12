package com.practice.hardalgo.MedianFinder;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    private Queue<Integer> minHeap, maxHeap;

    public Solution() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    /**
     * max heap||min heap
     * 1,2,3   ||   4,5,6
     *
     */


    public void addNum(int num) {
        if (!minHeap.isEmpty() && num < minHeap.peek()) {
            maxHeap.offer(num);
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
        } else {
            minHeap.offer(num);
            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    public double getMedian() {
        double median;
        if (minHeap.size() > maxHeap.size()) {
            median = minHeap.peek();
        } else if (minHeap.size() < maxHeap.size()) {
            median = maxHeap.peek();
        } else {
            median = (double) (minHeap.peek() + maxHeap.peek()) / 2;
        }
        return median;
    }
}
