package Graphs;

import java.io.*;
import java.util.*;

public class mothervertex {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            int u = Integer.parseInt(st[0]) - 1;
            int v = Integer.parseInt(st[1]) - 1;
            graph.get(u).add(v);
        }

        System.out.println(findMotherVertex(n, graph));
    }

    // Simple application of DFS, we will use stack just like in topological sort
    // idea is that
    // the top element of stack (after backtrack while doing dfs) obvious the
    // element which is accesible
    // from all other vertices and other dfs we use just to count the vertices
    // accesible from the top of // the stack ,if the count ==N , it means that top
    // of element is a mother vertex;
    public static int findMotherVertex(int N, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[N];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (vis[i] == false) {
                dfs(adj, vis, i, st);
            }
        }
        int ans = st.pop();
        vis = new boolean[N];
        count = 0;
        dfs(adj, vis, ans);
        if (count == N) {
            return ans + 1;
        } else {
            return -1;
        }

    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] isvis, int curr, Stack<Integer> st) {
        isvis[curr] = true;
        for (int nbrs : graph.get(curr)) {
            if (isvis[nbrs] == false) {
                dfs(graph, isvis, nbrs, st);
            }
        }
        st.push(curr);
    }

    static int count = 0;

    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] isvis, int curr) {
        isvis[curr] = true;
        count++;
        for (int nbrs : graph.get(curr)) {
            if (isvis[nbrs] == false) {
                dfs(graph, isvis, nbrs);
            }
        }
    }

}
