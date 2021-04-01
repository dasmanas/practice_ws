package com.practice.easyalgo;


public class MaxSumSubArrayOfSizeK {

    public int findMaxSumSubArray(int k, int[] arr){
        int maxSum = 0;
        int len = arr.length;
        int start=0, end=0;
        int sum = 0;
        for(end=0; end<len; end++){
            if((end - start) < k ){
                sum = sum + arr[end];
            }else{
                sum = sum + arr[end] - arr[start];
                maxSum = (sum > maxSum) ? sum : maxSum;
                start ++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args){
        MaxSumSubArrayOfSizeK sol = new MaxSumSubArrayOfSizeK();

        System.out.printf("maxSum: %d\n", sol.findMaxSumSubArray(3, new int[] {2, 1, 5, 1, 3, 2}));
        System.out.printf("maxSum: %d\n", sol.findMaxSumSubArray(2, new int[] {2, 3, 4, 1, 5}));
    }
}
