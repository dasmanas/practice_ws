package com.practice.easyalgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSums {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, List<Integer>> reverseIndex = new HashMap<Integer, List<Integer>>();
        for (int i=0; i<nums.length; i++){
            int num = nums[i];

            if(reverseIndex.containsKey(num)){
                reverseIndex.get(num).add(i);
            }else {
                reverseIndex.put(num, new ArrayList<>(i));
            }
        }

        

        return new int[]{0};
    }
}
