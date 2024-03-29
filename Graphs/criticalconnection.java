package Graphs;

import java.util.*;
import java.io.*;

// Explanation is same as articulation point 
class Main {
    static int parent[];
    static int disc[];
    static int low[];
    static int time;
    static boolean vis[];

    public static void bridges(int u, ArrayList<ArrayList<Integer>> graphs, List<List<Integer>> ans) {
        disc[u] = low[u] = time;
        time++;
        vis[u] = true;
        for (int i = 0; i < graphs.get(u).size(); i++) {
            int v = graphs.get(u).get(i);
            if (parent[u] == v) {
                continue;
            } else if (vis[v] == true) {
                low[u] = Math.min(low[u], disc[v]);
            } else {
                parent[v] = u;
                bridges(v, graphs, ans);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(u);
                    temp.add(v);
                    ans.add(temp);
                }
            }
        }
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> Edges) {
        ArrayList<ArrayList<Integer>> graphs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graphs.add(new ArrayList<>());
        }
        for (int i = 0; i < Edges.size(); i++) {
            int u = Edges.get(i).get(0);
            int v = Edges.get(i).get(1);
            graphs.get(u).add(v);
            graphs.get(v).add(u);
        }
        parent = new int[n];
        disc = new int[n];
        low = new int[n];
        vis = new boolean[n];
        time = 0;
        List<List<Integer>> ans = new ArrayList<>();
        bridges(0, graphs, ans);
        return ans;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int e = Integer.parseInt(st[1]);
        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            edges.add(new ArrayList<>());
            st = br.readLine().split(" ");
            edges.get(i).add(Integer.parseInt(st[0]));
            edges.get(i).add(Integer.parseInt(st[1]));
        }

        System.out.println(criticalConnections(n, edges));

    }

}