package Graphs;

//https://leetcode.com/problems/number-of-islands/description/
class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class numisland_dfs {

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    dfs(grid, vis, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int[][] vis, int row, int col) {
        vis[row][col] = 1;
        int delrow[] = { -1, 0, 1, 0 };
        int delcol[] = { 0, 1, 0, -1 };
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                // vis[nrow][ncol]=1
                dfs(grid, vis, nrow, ncol);
            }
        }
    }

}