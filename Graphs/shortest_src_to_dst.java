package Graphs;

//https://practice.geeksforgeeks.org/problems/shortest-source-to-destination-path3544/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
import java.util.*;

class pair {
    int row;
    int col;
    int wt;

    public pair(int row, int col, int wt) {
        this.row = row;
        this.col = col;
        this.wt = wt;
    }
}

public class shortest_src_to_dst {

    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        Queue<pair> q = new LinkedList<>();
        if (A[0][0] == 0) {
            return -1;
        }
        boolean visited[][] = new boolean[N][M];
        q.add(new pair(0, 0, 0));
        visited[0][0] = true;
        int delrow[] = { 1, -1, 0, 0 };
        int delcol[] = { 0, 0, 1, -1 };
        while (!q.isEmpty()) {
            pair p = q.remove();
            if (p.row == X && p.col == Y) {
                return p.wt;
            }
            for (int i = 0; i < 4; i++) {
                int newrow = p.row + delrow[i];
                int newcol = p.col + delcol[i];
                if (newrow >= 0 && newrow < N && newcol >= 0 && newcol < M && A[newrow][newcol] == 1
                        && visited[newrow][newcol] == false) {
                    q.add(new pair(newrow, newcol, p.wt + 1));
                    visited[newrow][newcol] = true;
                }
            }
        }
        return -1;
    }
};
