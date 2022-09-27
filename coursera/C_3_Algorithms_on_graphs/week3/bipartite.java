package coursera.C_3_Algorithms_on_graphs.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bipartite {

    private static int bipartite(ArrayList<Integer>[] adj) {
        int n = adj.length;
        int colour[] = new int[n];
        for (int i = 0; i < n; i++) {
            colour[i] = -1;

        }
        for (int i = 0; i < n; i++) {
            if (colour[i] == -1) {
                boolean checkbipartite = bipartitehelper(adj, i, colour);
                if (checkbipartite == false) {
                    return 0;
                }
            }
        }

        return 1;
    }

    public static boolean bipartitehelper(ArrayList<Integer>[] adj, int node, int[] colour) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        colour[node] = 1;
        while (!q.isEmpty()) {
            int rem = q.poll();
            for (int it : adj[rem]) {
                if (colour[it] == -1) {
                    colour[it] = 1 - colour[rem];
                    q.add(it);
                } else if (colour[it] == colour[rem]) {
                    return false;
                }
            }
        }
        return true;
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
        System.out.println(bipartite(adj));
    }
}
