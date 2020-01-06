package com.practice.easyalgo;

/*
You are climbing a stair case. It takes n steps to reach to the top.

        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

        Note: Given n will be a positive integer.

        Example 1:

        Input: 2
        Output: 2
        Explanation: There are two ways to climb to the top.
        1. 1 step + 1 step
        2. 2 steps
        Example 2:

        Input: 3
        Output: 3
        Explanation: There are three ways to climb to the top.
        1. 1 step + 1 step + 1 step
        2. 1 step + 2 steps
        3. 2 steps + 1 step
*/


import java.lang.reflect.Array;

public class ClimbingStairs {

    public int climb(int steps, int stepsToClimb){

        if(steps > stepsToClimb){
            return 0;
        } else if(steps == stepsToClimb){
            return 1;
        } else {
            return climb(steps+1, stepsToClimb) + climb(steps+2, stepsToClimb);
        }
    }


    public long climbMemoization(int steps, int stepsToClimb, long memo[]){

        if(steps > stepsToClimb){
            return 0;
        } else if(steps == stepsToClimb){
            return 1;
        } else {
            if(memo[steps] > 0){
                return memo[steps];
            }else {
                memo[steps] = climbMemoization(steps + 1, stepsToClimb, memo) + climbMemoization(steps + 2, stepsToClimb, memo);
                return memo[steps];
            }
        }
    }




    public static void main(String args[]){

        ClimbingStairs climbingStairs = new ClimbingStairs();
        int stepsToClimb = 100;

//        System.out.println(climbingStairs.climb(0, stepsToClimb));

        System.out.println(climbingStairs.climbMemoization(0, stepsToClimb, new long[stepsToClimb+1]));

    }

}
