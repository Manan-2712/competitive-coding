//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/articulation-point-official/ojquestion
//https://www.youtube.com/watch?v=sAk4W8q0Rmw&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=23
package Graphs;

import java.util.*;
import java.io.*;

public class articulationpoint {

    static int low[];
    static int disc[];
    static int parent[];
    static int time;
    static boolean vis[];
    static boolean ap[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            int u = sc.nextInt() - 1;
            int vtx = sc.nextInt() - 1;
            graph.get(u).add(vtx);
            graph.get(vtx).add(u);
        }
        parent = new int[v]; // for parent of each vertex;
        low = new int[v];// for maximum possible lowest value a vertex can reach from any other path
                         // ,except it's original one
        disc = new int[v];// to fetch discovery time of each vertex;
        time = 0;
        vis = new boolean[v];
        ap = new boolean[v];// array is used to calculate articulation points,because if we do it with
                            // variable,then one vertex will
        parent[0] = -1;// get counted multiple times i.e for each neighbour one vertex will get counted
        dfs(0, graph);
        int ans = 0;
        for (int i = 0; i < v; i++) {
            if (ap[i] == true) {
                ans++;
            }
        }
        System.out.println(ans);

    }

    public static void dfs(int u, ArrayList<ArrayList<Integer>> graph) {
        disc[u] = low[u] = time;
        time++;
        int count = 0;
        vis[u] = true;
        ArrayList<Integer> nbr = graph.get(u);
        for (int i = 0; i < nbr.size(); i++) {
            int v = nbr.get(i);
            if (parent[u] == v) {
                continue;
            } else if (vis[v] == true) {// it means nbr is visited but it is not our parent,so it means our vertex have
                                        // a path to connect this nbr
                low[u] = Math.min(low[u], disc[v]);// other than it's original path, so we update our low value;
            } else {
                // this is used when our nbr is neither visited nor parent(vertex parent);
                parent[v] = u;
                count++;
                dfs(v, graph);
                low[u] = Math.min(low[u], low[v]);// while backtracking update low ,because if our nbr low is less than
                                                  // our low ,then our low can
                if (parent[u] == -1) {// get updated because we can reach our nbr very easily
                    if (count >= 2) {
                        ap[u] = true;
                    }

                } else {
                    if (low[v] >= disc[u]) {// condition for articulation ,nbr low is greater than our discovery than
                                            // condition is true;
                        ap[u] = true;
                    }
                }

            }
        }
    }

}
