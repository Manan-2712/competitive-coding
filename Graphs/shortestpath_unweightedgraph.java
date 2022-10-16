//https://www.codingninjas.com/codestudio/problems/shortest-path-in-an-unweighted-graph_981297?leftPanelTab=0

package Graphs;
import java.util.*;

public class shortestpath_unweightedgraph {

    public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int s, int t) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n + 1);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = edges[i][0];
            y = edges[i][1];
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        int visited[] = new int[n + 1];
        int parent[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            visited[i] = 0;
            parent[i] = -1;
        }
        LinkedList<Integer> ll = new LinkedList<Integer>();
        visited[s] = 1;
        parent[s] = -1;
        ll.add(s);
        while (!ll.isEmpty()) {
            int rem = ll.remove();
            for (int i = 0; i < adj.get(rem).size(); i++) {
                if (visited[adj.get(rem).get(i)] == 0) {
                    visited[adj.get(rem).get(i)] = 1;
                    ll.add(adj.get(rem).get(i));
                    parent[adj.get(rem).get(i)] = rem;

                }
            }
        }
        LinkedList<Integer> path = new LinkedList<>();
        int currentnode = t;
        path.add(currentnode);
        while (parent[currentnode] != -1) {
            currentnode = parent[currentnode];
            path.add(currentnode);
        }
        Collections.reverse(path);
        return path;

    }

}
