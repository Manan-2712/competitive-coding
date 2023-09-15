package Graphs;
//https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-spanning-tree
import java.util.*;
import java.io.*;
import java.lang.*;

public class kruskal_algo {
    // { Driver Code Starts
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            int edges[][] = new int[E][3];
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }
            ot.println(new Solution().spanningTree(V, E, edges));
        }
        ot.close();
    }
}
// } Driver Code Ends

// User function Template for Java
class disjoint_set {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();

    public disjoint_set(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(0);
        }
    }

    public int findparent(int vtx) {
        if (vtx == parent.get(vtx)) {
            return vtx;
        }
        int ulp = findparent(parent.get(vtx));
        parent.set(vtx, ulp);
        return parent.get(vtx);

    }

    // union by rank attach small rank with big one.
    public void unionbyrank(int u, int v) {
        int ulp_u = findparent(u);
        int ulp_v = findparent(v);
        if (ulp_u == ulp_v) {
            return;
        }
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_u) > rank.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int ranku = rank.get(ulp_u);
            rank.set(ulp_u, ranku + 1);
        }
    }

}

class edge implements Comparable<edge> {
    int src;
    int dest;
    int wt;

    public edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }

    public int compareTo(edge compareedge) {
        return this.wt - compareedge.wt;
    }
};

class Solution {
    static int spanningTree(int V, int E, int edges[][]) {
        List<edge> list = new ArrayList<edge>();
        for (int i = 0; i < E; i++) {
            int src = edges[i][0];
            int adjnode = edges[i][1];
            int edgewt = edges[i][2];

            edge temp = new edge(src, adjnode, edgewt);
            list.add(temp);
        }

        disjoint_set ds = new disjoint_set(V);
        Collections.sort(list);
        int mstwt = 0;

        for (int i = 0; i < list.size(); i++) {
            int wght = list.get(i).wt;
            int u = list.get(i).src;
            int v = list.get(i).dest;
            if (ds.findparent(u) != ds.findparent(v)) {
                mstwt += wght;
                ds.unionbyrank(u, v);
            }
        }
        return mstwt;
    }
}
