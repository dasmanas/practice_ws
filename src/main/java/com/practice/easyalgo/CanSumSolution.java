package com.practice.easyalgo;

import java.util.Arrays;

public class CanSumSolution {

    public boolean canSum(int target, int[] arr) {
        if (target == 0) {
            return true;
        } else {
            int arrLen = arr.length;
            if (arrLen > 0) {
                boolean solutionPossible = false;
                for (int i = 0; i < arrLen; i++) {
                    int rem = target - arr[i];
                    solutionPossible = canSum(rem, Arrays.copyOfRange(arr, i + 1, arrLen));
                    if(solutionPossible){
                        //at least one Solution found. Break here
                        break;
                    }else{
                        //Keep on checking
                        continue;
                    }
                }
                return solutionPossible;
            } else {
                //No more candidates left
                return false;
            }
        }
    }
}
