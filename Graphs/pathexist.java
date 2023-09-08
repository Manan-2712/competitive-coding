package Graphs;
//https://practice.geeksforgeeks.org/problems/find-whether-path-exist5238/1
public class pathexist {
    public boolean dfs(int[][] grid, boolean[][] visited, int sr, int sc) {
        int n = grid.length;
        int m = grid[0].length;
        if (sr < 0 || sr >= n || sc < 0 || sc >= m || grid[sr][sc] == 0) {
            return false;
        }
        if (visited[sr][sc]) {
            return false;
        }
        if (grid[sr][sc] == 2) {
            return true;
        }
        visited[sr][sc] = true;
        boolean ispath = dfs(grid, visited, sr + 1, sc) || dfs(grid, visited, sr - 1, sc) ||
                dfs(grid, visited, sr, sc + 1) || dfs(grid, visited, sr, sc - 1);

        return ispath;

    }

    // Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid) {
        boolean haspath = false;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    haspath = dfs(grid, visited, i, j);
                }
            }
        }

        return haspath;

    }
}
