package coursera.C_3_Algorithms_on_graphs.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs {

    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        int distance[] = new int[adj.length];
        // ArrayList<Integer> prev = new ArrayList<>();
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        if (s == t) {
            return 0;
        }
        distance[s] = 0;
        // prev[s]=0;

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            // System.out.print(u+"->");
            for (int elem : adj[u]) {
                if (distance[elem] == Integer.MAX_VALUE) {
                    q.add(elem);
                    distance[elem] = distance[u] + 1;
                    // prev[elem]=u;

                }

            }
        }

        if (distance[t] != Integer.MAX_VALUE) {
            return distance[t];
        }

        return -1;
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
        System.out.println(distance(adj, x, y));
    }
}
