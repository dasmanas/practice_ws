package com.practice.easyalgo.removeDuplicateSortedArray;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.remove(new int[]{2,3,3,3,6,9,9}));
        System.out.println(sol.remove(new int[]{2,2,3,3,3,6,9,9,10}));
    }

    public int remove(int[] arr){
        int nonDuplicate=0;

        for(int i=1; i<arr.length; i++){
            if(arr[i-1]!=arr[i]){
                nonDuplicate ++;
                arr[nonDuplicate] = arr[i];
            }
        }
        /*for(int i=0; i<=nonDuplicate; i++){
            System.out.print(arr[i]);
        }*/

        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, nonDuplicate+1)));

        return nonDuplicate;
    }
}
