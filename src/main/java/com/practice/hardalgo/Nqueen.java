package com.practice.hardalgo;

import java.util.ArrayList;
import java.util.List;

public class Nqueen {

    public static void main(String[] args) {
        int queens = 4;
        Nqueen nq = new Nqueen();
        List<int[]> r = nq.findPlacement(0, 0, queens, new boolean[4], new boolean[4], new boolean[7], new boolean[7], new int[4]);

        r.forEach(x -> {
            System.out.println("===");
            for (int i = 0; i < x.length; i++) {
                for (int j = 0; j < queens; j++) {
                    if (x[i] == j) {
                        System.out.print("1");
                    } else {
                        System.out.print("0");
                    }
                }
                System.out.println("");
            }
        });
    }

    public List<int[]> findPlacement(int r, int prevCol, int numQs, boolean[] row, boolean[] col,
                                     boolean[] diagonalUp, boolean[] diagonalDown, int[] pos) {
        int prevRow = r - 1;
        if (prevRow >= 0) {
            row[prevRow] = true;
            col[prevCol] = true;
            diagonalUp[prevRow + prevCol] = true;
            diagonalDown[prevRow - prevCol + 3] = true;
            pos[prevRow] = prevCol;
        }
        List<int[]> result = new ArrayList<>();
        if (r == numQs) {
            result.add(pos);
            return result;
        }
        for (int c = 0; c < numQs; c++) {
            System.out.println("row: " + r + ", col: " + c);
            if (!row[r] && !col[c] && !diagonalUp[r + c] && !diagonalDown[r - c + 3]) {
                System.out.println("Good");
                int newRow = r + 1;
                result.addAll(findPlacement(newRow, c, numQs, row.clone(), col.clone(), diagonalUp.clone(), diagonalDown.clone(), pos.clone()));
            }
        }
        return result;
    }


}
