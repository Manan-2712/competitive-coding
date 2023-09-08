package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class pair {
    int row;
    int col;

    public pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class pathexistbfs {

    public boolean is_Possible(int[][] grid) {
        Queue<pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new pair(i, j));
                }
            }
        }
        int delrow[] = { 1, -1, 0, 0 };
        int delcol[] = { 0, 0, 1, -1 };
        while (!q.isEmpty()) {
            pair top = q.remove();
            int r = top.row;
            int c = top.col;
            for (int i = 0; i < 4; i++) {
                int newrow = r + delrow[i];
                int newcol = c + delcol[i];
                if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m) {
                    if (grid[newrow][newcol] == 2) {
                        return true;
                    }
                    if (grid[newrow][newcol] == 3) {
                        q.add(new pair(newrow, newcol));
                    }
                }

            }
        }
        return false;

    }
}
