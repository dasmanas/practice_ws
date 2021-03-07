package com.practice.mediumalgo;


//Brute force
public class TrapRainWaterSolution {

    public static void main(String[] args){
        TrapRainWaterSolution sol = new TrapRainWaterSolution();
        System.out.println(sol.trap(new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}));

    }


    public int trap(int[] height) {
        int water = 0;
        int substract = 0;
        String dir = null; //LtoR or RtoL

        int len = height.length;
        int li = 0;
        int i = li + 1;
        int rj = len - 1;
        int j = rj - 1;

        if(len < 3){
            return water;
        }
        if(height[0] < height[len-1]){
            dir = "LtoR";
        }else{
            dir = "RtoL";
        }

        while(i<=rj && li<=j){
            if(dir.equals("LtoR")){
                System.out.printf("Direction: %s, li: %d, i: %d \n", dir, li, i);
                int multiplier = Math.min(height[li], height[i]);
                if(height[i] >= height[li]){
                    water = water + (multiplier * (i - li - 1)) - substract;
                    li = i;
                    substract = 0;
                    dir = "RtoL";
                    System.out.printf("water: %d \n", water);
                }else{
                    substract = substract + (height[i] * 1);
                    System.out.printf("substract: %d \n", substract);
                }
                i++;
            } else if(dir.equals("RtoL")){
                System.out.printf("Direction: %s, rj: %d, j: %d \n", dir, rj, j);
                int multiplier = Math.min(height[rj], height[j]);
                if(height[j] >= height[rj]){
                    water = water + (multiplier * (rj - j - 1)) - substract;
                    rj = j;
                    substract = 0;
                    dir = "LtoR";
                    System.out.printf("water: %d \n", water);
                }else{
                    substract = substract + (height[j] * 1);
                    System.out.printf("substract: %d \n", substract);
                }
                j--;
            }
        }

        return water;
    }
}
