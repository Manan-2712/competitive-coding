package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class as_far_from_landaspossible {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(maxDistance(arr));

    }

    public static class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int dirs[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static int maxDistance(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                }

            }
        }
        if (q.size() == 0 || q.size() == grid.length * grid[0].length) {
            return -1;
        }
        int level = -1;
        while (!q.isEmpty()) { // this loop is for updating level
            int size = q.size();
            level++;
            while (size-- > 0) {// this loop is doing actually bfs.
                Pair rem = q.remove();
                for (int i = 0; i < dirs.length; i++) {
                    int rowdash = rem.row + dirs[i][0];
                    int coldash = rem.col + dirs[i][1];
                    if (rowdash < 0 || coldash < 0 || rowdash >= n || coldash >= m || grid[rowdash][coldash] == 1) {
                        continue;
                    }
                    q.add(new Pair(rowdash, coldash));
                    grid[rowdash][coldash] = 1;
                }
            }
        }
        return level;

    }
}
