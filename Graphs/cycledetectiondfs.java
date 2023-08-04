package Graphs;

import java.util.ArrayList;

class pair {
    int node;
    int parent;

    public pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class cycledetectiondfs {

    public static boolean helper(ArrayList<ArrayList<Integer>> adj, int[] visited, int src, int parent) {
        visited[src] = 1;
        for (int adjnode : adj.get(src)) {
            if (visited[adjnode] == 0) {
                if (helper(adj, visited, adjnode, src) == true) {
                    return true;
                }
            } else {
                if (parent != adjnode) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String cycleDetection(int[][] edges, int n, int m) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][1]).add(edges[i][0]);
            adj.get(edges[i][0]).add(edges[i][1]);

        }
        int visited[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (visited[i] == 0) {
                if (helper(adj, visited, i, -1)) {
                    return "Yes";
                }
            }
        }
        return "No";

    }

}
