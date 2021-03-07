package com.practice.easyalgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSums {

    public int[] twoSum(int[] nums, int target) {
        int[] a = {-1};

        int len = nums.length;
        for(int i=0; i<len; i++){
            int check = target - nums[i];
            for(int j = i+1; j<len; j++){
                if(check == nums[j]){
                    a = new int[]{i,j};
                }
            }
        }
        return a;
    }
}
