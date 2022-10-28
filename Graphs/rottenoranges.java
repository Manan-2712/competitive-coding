//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/rotting-oranges-official/ojquestion
//https://www.youtube.com/watch?v=Dq3dGS_0Z6o&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=5
package Graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class rottenoranges {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(orangesRotting(arr));

    }

    public static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

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
        int level = -1;
        while (q.size() > 0) {
            int size = q.size();
            level++;
            while (size-- > 0) {
                Pair top = q.remove();
                for (int i = 0; i < drs.length; i++) {
                    int rdash = top.row + drs[i][0];
                    int coldash = top.col + drs[i][1];
                    if (rdash >= 0 && coldash >= 0 && rdash < grid.length && coldash < grid[0].length
                            && grid[rdash][coldash] == 1) {
                        q.add(new Pair(rdash, coldash));
                        grid[rdash][coldash] = 0;
                        frshor--;
                    }
                }
            }
        }
        if (frshor == 0) {
            return level;
        } else {
            return -1;
        }

    }
}
