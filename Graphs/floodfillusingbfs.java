package Graphs;
//https://leetcode.com/problems/flood-fill/description/
import java.util.LinkedList;
import java.util.Queue;

public class floodfillusingbfs {
    class Pair {
        int sr;
        int sc;

        public Pair(int sr, int sc) {
            this.sr = sr;
            this.sc = sc;
        }
    }

    public void bfs(int[][] image, boolean[][] visited, int sr, int sc, int color, int inicolor, int delrow[],
            int delcol[]) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        image[sr][sc] = color;
        visited[sr][sc] = true;
        int n = image.length;
        int m = image[0].length;
        while (!q.isEmpty()) {
            Pair front = q.poll();
            // ans[front.sr][front.sc] = color;
            int row = front.sr;
            int col = front.sc;
            for (int i = 0; i < 4; i++) {
                int newrow = row + delrow[i];
                int newcol = col + delcol[i];
                if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m &&
                        image[newrow][newcol] == inicolor && !visited[newrow][newcol]) {
                    image[newrow][newcol] = color;
                    visited[newrow][newcol] = true;
                    q.add(new Pair(newrow, newcol));
                }
            }

        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean visited[][] = new boolean[n][m];
        int delrow[] = { -1, 0, +1, 0 };
        int delcol[] = { 0, +1, 0, -1 };
        int inicolor = image[sr][sc];
        bfs(image, visited, sr, sc, color, inicolor, delrow, delcol);
        return image;

    }
}
