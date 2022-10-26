//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/zero-one-matrix-official/ojquestion
//https://www.youtube.com/watch?v=BJbaUH9dN24&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&
package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static class zeroonematrix {

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

            int[][] ans = updateMatrix(arr);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }

        }

        public static int[][] updateMatrix(int[][] matrix) {
            Queue<Pair> q = new LinkedList<>();
            int n = matrix.length;
            int m = matrix[0].length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        q.add(new Pair(i, j));
                    } else {
                        matrix[i][j] = -1;
                    }
                }
            }
            while (!q.isEmpty()) {
                Pair rem = q.remove();
                for (int i = 0; i < dirs.length; i++) {
                    int rowdash = rem.x + dirs[i][0];
                    int coldash = rem.y + dirs[i][1];
                    if (rowdash >= 0 && coldash >= 0 && rowdash < matrix.length && coldash < matrix[0].length
                            && matrix[rowdash][coldash] < 0) {
                        q.add(new Pair(rowdash, coldash));
                        matrix[rowdash][coldash] = matrix[rem.x][rem.y] + 1;
                    }
                }
            }
            return matrix;

        }
    }
}
