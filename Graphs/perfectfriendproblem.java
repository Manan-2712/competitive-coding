package Graphs;
import java.io.*;
import java.util.*;

public class perfectfriendproblem {
    public static class Edge {
        int v;
        int n;

        Edge(int v, int n) {
            this.v = v;
            this.n = n;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int v = 0; v < n; v++) {
            graph[v] = new ArrayList<>();
        }
        for (int e = 0; e < k; e++) {
            String line = br.readLine();
            int v1 = Integer.parseInt(line.split(" ")[0]);
            int v2 = Integer.parseInt(line.split(" ")[1]);
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }
        boolean visited[] = new boolean[n];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for (int v = 0; v < n; v++) {
            if (visited[v] == false) {
                ArrayList<Integer> comp = new ArrayList<>();
                drawtree(graph, comp, v, visited);
                comps.add(comp);
            }
        }
        int pairs = 0;
        for (int i = 0; i < comps.size(); i++) {// these loops are used for calculating no.of ways(components combination)
            for (int j = i + 1; j < comps.size(); j++) { // if three components c1 c2 =2*2
                int count = comps.get(i).size() * comps.get(j).size();// c1 c3        =2*3
                pairs += count;                                       //c2 c3         =2*3
            }
        }
        System.out.println(pairs);

    }
// for getting connected components;
    public static void drawtree(ArrayList<Edge>[] graphs, ArrayList<Integer> comp, int v, boolean[] visited) {
        visited[v] = true;
        comp.add(v);
        for (Edge e : graphs[v]) {
            if (visited[e.n] == false) {
                drawtree(graphs, comp, e.n, visited);
            }

        }

    }
}
