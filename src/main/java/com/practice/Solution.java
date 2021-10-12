package com.practice;

import java.util.List;

public class Solution {

    public static void main(String[] args){

        Solution solution = new Solution();
        //solution.carParkingRoof();
    }

    public int countAnalogousArrays(List<Integer> consecutiveDifference, int lowerBound, int upperBound) {

        int runningDiff = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        for (int i=0; i<consecutiveDifference.size(); i++){
            runningDiff = runningDiff - consecutiveDifference.get(i);
            min = Math.min(min,runningDiff);
            max = Math.max(max,runningDiff);
        }
        return (upperBound - lowerBound) - (max-min);

    }



}
