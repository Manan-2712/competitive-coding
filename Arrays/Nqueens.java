
//https://leetcode.com/problems/n-queens/description/
// Leetcode 51.
import java.util.*;

public class Nqueens {
    public boolean validate(char[][] board, int row, int col) {
        // check the queens in all left directions before placing a queen in new
        // coloumn,
        // in left because-> in left directions queens are already placed ,in right
        // directions
        // there are no queens because we start putting queens from left to right.That
        // is why
        // before placing queen in new coloumn we have to check all the left side
        // directions.
        int duprow = row;
        int dupcol = col;
        // for upward left
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }
        row = duprow;
        col = dupcol;
        // for left
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }
        row = duprow;
        col = dupcol;
        // for downward left
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
            row++;
        }
        return true;
    }

    public void dfs(int col, char[][] board, List<List<String>> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q';
                dfs(col + 1, board, res);
                board[row][col] = '.';
            }
        }
    }

    public List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(0, board, res);
        return res;

    }
}
