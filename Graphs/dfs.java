package Graphs;

import java.util.*;
//https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
public class dfs {
    public static void dfs(int start, int visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> lst) {
        visited[start] = 1;
        lst.add(start);
        for (Integer it : adj.get(start)) {
            if (visited[it] == 0) {
                dfs(it, visited, adj, lst);
            }
        }
    }

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        int visited[] = new int[V + 1];
        visited[0] = 1;
        ArrayList<Integer> lst = new ArrayList<>();
        dfs(0, visited, adj, lst);
        return lst;

        // Code here
    }
}
