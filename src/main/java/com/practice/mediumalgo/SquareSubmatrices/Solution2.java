package com.practice.mediumalgo.SquareSubmatrices;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public int countSquares(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        Map<String, Integer> memo = new HashMap();

        int squareNum = 0;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                squareNum = squareNum + recurse(i, j, matrix, memo);
            }
        }
        return squareNum;
    }

    public int recurse(int i, int j, int[][] matrix, Map<String, Integer> memo){

        int r = matrix.length;
        int c = matrix[0].length;
        String key = i+"-"+j;

        if(i>=0 && i<r && j>=0 && j<c){
            Integer completeDepth = memo.get(key);
            if(completeDepth!=null){
                return completeDepth;
            } else{
                if(matrix[i][j] == 1){
                    int e = recurse(i, j+1, matrix, memo);
                    int s = recurse(i+1, j, matrix, memo);
                    int se = recurse(i+1, j+1, matrix, memo);
                    int minCompletedepth = Math.min(e, Math.min(s, se));
                    completeDepth = minCompletedepth + 1;
                    memo.put(key, completeDepth);
                }else{
                    completeDepth = 0;
                    memo.put(key, completeDepth);
                }
            }
            return completeDepth;
        }else{
            return 0;
        }
    }
}