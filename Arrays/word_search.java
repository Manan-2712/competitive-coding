package Arrays;

import java.util.*;

class word_search {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && search(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }

        return false;

    }

    public boolean search(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(index)
                || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        // calling in four directions
        if (search(board, word, i + 1, j, index + 1, visited) ||
                search(board, word, i - 1, j, index + 1, visited) ||
                search(board, word, i, j + 1, index + 1, visited) ||
                search(board, word, i, j - 1, index + 1, visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;

    }
}