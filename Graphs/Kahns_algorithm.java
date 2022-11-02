package Graphs;
import java.io.*;
import java.util.*;

public class Kahns_algorithm {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        int prerequisites[][] = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            prerequisites[i][0] = Integer.parseInt(st[0]);
            prerequisites[i][1] = Integer.parseInt(st[1]);

        }
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());

        }

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            graph.get(v).add(u);
        }
        int ans[] = findorder(n, graph);
        for (int val : ans) {
            System.out.print(val + " ");
        }

    }

    public static int[] findorder(int n, ArrayList<ArrayList<Integer>> graph) {
        int indegree[] = new int[n];
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int nbrs : graph.get(i)) {
                indegree[nbrs]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int index = 0;
        while (!q.isEmpty()) {
            int rem = q.remove();
            ans[index] = rem;
            index++;
            for (int nbrs : graph.get(rem)) {
                indegree[nbrs]--;
                if (indegree[nbrs] == 0) {
                    q.add(nbrs);
                }
            }
        }
        if (index == n) {
            return ans;
        } else {
            return new int[] { -1 };
        }
    }
}
