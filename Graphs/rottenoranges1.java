package Graphs;
//https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1
import java.util.*;
import java.lang.*;
import java.io.*;

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

}

public class rottenoranges1 {
    // { Driver Code Starts

    // } Driver Code Ends

    // public int orangesRotting(int[][] grid) {

    private static int[][] drs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public static int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int frshor = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    frshor++;
                }
            }
        }

        int time = -1;
        while (q.size() > 0) {
            int size = q.size();
            time++;
            // System.out.println("Time Increased" + time);
            while (size-- > 0) {
                Pair top = q.remove();
                for (int i = 0; i < drs.length; i++) {
                    int rdash = top.row + drs[i][0];
                    int coldash = top.col + drs[i][1];
                    if (rdash >= 0 && coldash >= 0 && rdash < grid.length && coldash < grid[0].length
                            && grid[rdash][coldash] == 1) {
                        grid[rdash][coldash] = 2;

                        q.add(new Pair(rdash, coldash));
                        frshor--;
                    }
                }
            }
        }
        if (time == -1) { // it means there is no rotten orange in the grid.
            return 0;
        }
        if (frshor == 0) {
            return time;
        } else {
            return -1;
        }
    }
}
