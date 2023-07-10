package Graphs;
//https://leetcode.com/problems/is-graph-bipartite/description/
public class bipartitedfs {
    public boolean helperdfs(int[][] graph, int src, int color[], int col) {
        color[src] = col;
        for (int x : graph[src]) {
            if (color[x] == -1) {
                if (helperdfs(graph, x, color, 1 - col) == false) {
                    return false;
                }
            } else if (color[x] == col) {
                return false;
            }

        }
        return true;

    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (helperdfs(graph, i, color, 0) == false) {
                    return false;
                }
            }
        }
        return true;

    }

}
