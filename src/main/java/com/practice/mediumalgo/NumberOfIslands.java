package com.practice.mediumalgo;

public class NumberOfIslands {

    class Solution {
        public int numIslands(char[][] grid) {
            int numberOfIslands = 0;
            int row = grid.length;
            int col = grid[0].length;

            for(int y=0; y<grid.length; y++){
                for(int x=0; x< grid[y].length; x++){
                    if(grid[y][x] == '1' && isIsland(grid, y, x, row, col)){
                        numberOfIslands++;
                    }else{
                        continue;
                    }
                }
            }
            return numberOfIslands;
        }


        public boolean isIsland(char[][] grid, int y, int x, int row, int col) {
            boolean island = false;
            if(x>=0 && x<col && y>=0 && y<row && grid[y][x] == '1') {
                grid[y][x] = '0';
                island = true;

                boolean n = isIsland(grid, y-1, x, row, col);
                boolean e = isIsland(grid, y, x+1, row, col);
                boolean w = isIsland(grid, y, x-1, row, col);
                boolean s = isIsland(grid, y+1, x, row, col);

                island = (island || n || e || w || s);
            }
            return island;
        }
    }
}