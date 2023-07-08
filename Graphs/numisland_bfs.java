package Graphs;

//https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class numisland_bfs {

    public void bfs(char[][] grid, int visited[][], int row, int col) {
        visited[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;
        while (!q.isEmpty()) {
            int nnrow = q.peek().first;
            int nncol = q.peek().second;
            q.remove();
            for (int delrow = -1; delrow <= 1; delrow++) {
                for (int delcol = -1; delcol <= 1; delcol++) {
                    int nrow = nnrow + delrow;
                    int ncol = nncol + delcol;
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0
                            && grid[nrow][ncol] == '1') {
                        visited[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }

    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (visited[row][col] == 0 && grid[row][col] == '1') {
                    count++;
                    bfs(grid, visited, row, col);
                }
            }
        }
        return count;
    }
}
