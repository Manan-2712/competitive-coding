package Graphs;
//https://practice.geeksforgeeks.org/problems/topological-sort/1
import java.util.ArrayList;
import java.util.Stack;

public class topological_Sort_dfs {
    static void dfs(int node, int[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = 1;
        for (int it : adj.get(node)) {
            if (visited[it] == 0) {
                dfs(it, visited, st, adj);
            }
        }
        st.push(node);
    }

    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int visited[] = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, st, adj);
            }
        }
        int ans[] = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            ans[i] = node;
            i++;
            st.pop();
        }
        return ans;

    }
}
