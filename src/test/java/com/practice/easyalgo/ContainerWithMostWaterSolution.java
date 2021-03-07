package com.practice.easyalgo;

public class ContainerWithMostWaterSolution {

    public int maxArea(int[] height) {

        int maxArea = 0;
        int sp = 0;
        int ep = height.length - 1;

        while(sp < ep){
            int multiplier = Math.min(height[sp], height[ep]);
            int tempArea = multiplier * (ep - sp);
            if(tempArea > maxArea){
                maxArea = tempArea;
            }
            if(height[sp] > height[ep]){
                ep --;
            }else{
                sp ++;
            }
        }
        return maxArea;
    }
}
