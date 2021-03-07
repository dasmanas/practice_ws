package com.practice.mediumalgo;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args){

        Subset subset = new Subset();
        subset.subsets(new int[]{1,2,3});

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());



        for(int num: nums){
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output){
                List<Integer> a = new ArrayList<Integer>(curr);
                a.add(num);
                newSubsets.add(a);
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }
}
