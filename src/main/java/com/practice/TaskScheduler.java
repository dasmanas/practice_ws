package com.practice;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskScheduler {

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();

        if (ts.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2) != 8) throw new AssertionError();
        if (ts.leastInterval(new char[]{'A','A','A','B','B','B'}, 0) != 6) throw new AssertionError();
        if (ts.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2) != 16) throw new AssertionError();
    }

    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        int fMax = 0;
        int fMaxChars = 0;
        int fTotal = 0;
        for (char task : tasks) {
            arr[task - 'A']++;
        }
        for (int f: arr){
            if (f>fMax){
                fMax = f;
                fMaxChars = 1;
            } else if (f == fMax) {
                fMaxChars ++;
            }
            fTotal += f;
        }
        int openExecSlots = (n + 1 > fMaxChars) ? (n + 1 - fMaxChars) * (fMax - 1) : 0;
        int additionalTime = Math.max(fTotal - (fMax * fMaxChars) - openExecSlots, 0);
        return (Math.max(n + 1, fMaxChars) * (fMax - 1)) + fMaxChars + additionalTime;
    }
}
