/*
package com.practice.design;

import java.util.Arrays;

enum Player
{RED, BLACK};

enum GameState
{
    IN_PROGRESS, GAME_WON, GAME_DRAWN
}

public class Connect4Game {

    private Player[][] board;
    private final int height;
    private final int width;
    private final int adjacentCells = 4;
    private int filledCells = 0;

    public Connect4Game(int height, int width){
        board = new Player[height][width];
        this.height = height;
        this.width = width;
    }

    public boolean drop(int col, Player p) throws Exception{
        int row = height - 1;
        while(board[row][col] != null){

            if(row < 0){
                throw new IllegalArgumentException("Column filled");
            }
            row--;
        }
        board[row][col] = p;
        filledCells ++;
        isGameOver(row, col);

        return true;
    }

    public GameState isGameOver(int row, int col) throws Exception {

        int [][] directions = {{1,0}, {0,1}, {1,1}, {1,-1}};

        for(int[] direction : directions){
            getMaxLength(row, col, direction);
        }

        if(filledCells == height * width){
            return GameState.GAME_DRAWN;
        }
    }

    public int getMaxLength(int row, int col, int[] direction) {

        Player player = board[row][col];

        int[] revDirection = { direction[0] * -1, direction[1] * -1 };

        for(int i=0; i<adjacentCells-1; i++){
            int pRow = direction[0]*i;
            int pCol = direction[1]*i;
            int pRevRow = revDirection[0]*i;
            int pRevCol = revDirection[1]*i;

            if(board[pRow][pCol]==player){

            }

            if(board[pRevRow][pRevCol]==player){

            }

        }

        if(row>=0 && row<height && col>=0 && col<width){

        }
    }






}

*/
