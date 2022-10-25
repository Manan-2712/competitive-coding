package Graphs;
//https://leetcode.com/problems/coloring-a-border/
//https://www.youtube.com/watch?v=R3AJoOBVAlg&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=1(SOLN)
public class coloringaborder {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[row][col] == color) {
            return grid;

        }
        boolean isvisited[][] = new boolean[n][m];
        dfs(grid, row, col, grid[row][col], isvisited, color, n, m);
        return grid;

    }

    public void dfs(int[][] grid, int i, int j, int col, boolean[][] visited, int target, int n, int m) {
        if (i > n - 1 || i < 0 || j > m - 1 || j < 0 || visited[i][j] || grid[i][j] != col) {
            return;
        }
        visited[i][j] = true;
        boolean isborder = false;
        if (i == 0 || j == 0 || i == n - 1 || j == m - 1 || grid[i + 1][j] != col || grid[i - 1][j] != col
                || grid[i][j + 1] != col || grid[i][j - 1] != col) {
            isborder = true;
        }
        dfs(grid, i + 1, j, col, visited, target, n, m);// to mark connected components in all four directions
        dfs(grid, i - 1, j, col, visited, target, n, m);
        dfs(grid, i, j - 1, col, visited, target, n, m);
        dfs(grid, i, j + 1, col, visited, target, n, m);
        if (isborder) {
            grid[i][j] = target;
        }

    }
}
