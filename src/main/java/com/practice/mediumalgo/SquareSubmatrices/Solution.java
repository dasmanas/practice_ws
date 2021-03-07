package com.practice.mediumalgo.SquareSubmatrices;

class Solution {
    public int countSquares(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] memo = new int[r][c];

        //initlialize memeoization calculation
        for(int i=0; i<memo.length; i++){
            for(int j=0; j<memo[i].length; j++){
                memo[i][j] = -1;
            }
        }
        int squareNum = 0;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                squareNum = squareNum + recurse(i, j, matrix, memo);
            }
        }
        return squareNum;
    }

    public int recurse(int i, int j, int[][] matrix, int[][] memo){

        int r = matrix.length;
        int c = matrix[0].length;

        if(i>=0 && i<r && j>=0 && j<c){
            if(memo[i][j]!=-1){ //calculation found in memoization
                System.out.printf("Using memoization: [%d][%d]\n", i, j);
                return memo[i][j];
            }else{
                if(matrix[i][j] == 1){
                    int e = recurse(i, j+1, matrix, memo);
                    int s = recurse(i+1, j, matrix, memo);
                    int se = recurse(i+1, j+1, matrix, memo);
                    int minCompletedepth = Math.min(e, Math.min(s, se));
                    memo[i][j] = minCompletedepth + 1;
                }else{
                    memo[i][j] = 0;
                }
            }
            return memo[i][j];
        }else{
            return 0;
        }
    }
}