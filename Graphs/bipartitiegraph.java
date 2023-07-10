package Graphs;
//https://leetcode.com/problems/is-graph-bipartite/description/
import java.util.LinkedList;
import java.util.Queue;

public class bipartitiegraph {
    public boolean helper(int[][] graph, int src, int[] color) {
        color[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()) {
            int front = q.peek();
            q.remove();
            for (int x : graph[front]) {
                if (color[x] == -1) {
                    // System.out.print(color[x]+" ");
                    color[x] = 1 - color[front];
                    // System.out.println();
                    // System.out.print(x+"->"+color[x]+" ");
                    q.add(x);
                    // System.out.println();
                    // System.out.print("queue executed");
                } else if (color[x] == color[front]) {
                    return false;
                }
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
                if (helper(graph, i, color) == false) {
                    return false;
                }
            }
        }
        return true;

    }
}
