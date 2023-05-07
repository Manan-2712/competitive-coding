import java.util.*;
//https://www.codingninjas.com/codestudio/problems/759332?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
public class Nqueensop {
    public static void construct(int[][] board, int n, ArrayList<ArrayList<Integer>> res) {
        ArrayList<Integer> currentanswer = new ArrayList<>();
        for (int[] row : board) {
            for (int elem : row) {
                currentanswer.add(elem);
            }
        }
        res.add(currentanswer);

    }

    public static void solve(int col, int[][] board, int[] left, int[] upperrow, int[] lowerrow,
            ArrayList<ArrayList<Integer>> res, int n) {
        if (col == board.length) {
            construct(board, n, res);
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (left[row] == 0 && lowerrow[row + col] == 0 && upperrow[board.length - 1 + col - row] == 0) {
                board[row][col] = 1;
                left[row] = 1;
                lowerrow[row + col] = 1;
                upperrow[board.length - 1 + col - row] = 1;
                solve(col + 1, board, left, upperrow, lowerrow, res, n);
                board[row][col] = 0;
                left[row] = 0;
                lowerrow[row + col] = 0;
                upperrow[board.length - 1 + col - row] = 0;

            }
        }
    }

    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int left[] = new int[n];// for left direction
        int upperrow[] = new int[2 * n - 1];// for upper left diagonal
        int lowerrow[] = new int[2 * n - 1];// for lower left diagonal
        solve(0, board, left, upperrow, lowerrow, res, n);
        return res;
    }

}
