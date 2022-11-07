package Graphs;

import java.io.*;
import java.util.*;

public class mincosttoconnectallcitites {

    static class Edge implements Comparable<Edge> {
        int v;
        int wt;

        Edge(int nbr, int wt) {
            this.v = nbr;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge o) {
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // APPLICATION OF MST
        // firstly sort the pair on the basis of weight , to get the minimum cost.
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < vtces; i++) {
            graph.add(new ArrayList<>());
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph.get(v1).add(new Edge(v2, wt));
            graph.get(v2).add(new Edge(v1, wt));
        }
        int ans = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[vtces];
        pq.add(new Edge(0, 0));
        while (!pq.isEmpty()) {
            Edge rem = pq.remove();
            if (vis[rem.v] == true) {
                continue;
            }
            vis[rem.v] = true;
            ans += rem.wt;
            ArrayList<Edge> nbr = graph.get(rem.v);
            for (Edge nbrs : nbr) {
                if (vis[nbrs.v] == false) {
                    pq.add(nbrs);
                }
            }

        }
        System.out.println(ans);

    }

}
