//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/number-of-distinct-island-official/ojquestion
//https://www.youtube.com/watch?v=4vY_ZPi9jTs&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=3
package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class numberofdistinctisland {

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

        System.out.println(numDistinctIslands(arr));

    }

    public static StringBuilder psf = new StringBuilder();

    public static int numDistinctIslands(int[][] arr) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    psf = new StringBuilder();
                    psf.append("x");// starting point of every distinct island;
                    dfs(arr, i, j);// call dfs for all the four directions;
                    set.add(psf.toString());// add path to set by converting stringBuilder to string

                }
            }
        }
        return set.size();
    }

    public static void dfs(int[][] arr, int row, int col) {
        arr[row][col] = 0;
        if (row - 1 >= 0 && arr[row - 1][col] == 1) {
            psf.append("u");
            dfs(arr, row - 1, col);
        }
        if (row + 1 < arr.length && arr[row + 1][col] == 1) {
            psf.append("d");
            dfs(arr, row + 1, col);
        }
        if (col + 1 < arr[0].length && arr[row][col + 1] == 1) {
            psf.append("r");
            dfs(arr, row, col + 1);
        }
        if (col - 1 >= 0 && arr[row][col - 1] == 1) {
            psf.append("l");
            dfs(arr, row, col - 1);
        }
        psf.append("z");// for backtrack reflection otherwise two different structures can have same
                        // traversal string.
    }
}
