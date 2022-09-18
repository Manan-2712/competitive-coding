package coursera.C_3_Algorithms_on_graphs.week1;

import java.util.ArrayList;
import java.util.Scanner;

public class finding_exit_from_maze {

    private static boolean reach(ArrayList<Integer>[] adj, int x, int y, boolean[] visited) {
        if (x == y) {
            return true;
        }
        visited[x] = true;
        for (Integer elem : adj[x]) {
            if (visited[elem] == false) {
                boolean isvisited = reach(adj, elem, y, visited);
                if (isvisited == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int solve(ArrayList<Integer>[] adj, int x, int y, boolean[] visited) {
        boolean ispath = reach(adj, x, y, visited);
        if (ispath == true) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        boolean visited[] = new boolean[n];

        System.out.println(solve(adj, x, y, visited));
    }
}
