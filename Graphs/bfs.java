package Graphs;
//https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {

    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V + 1];
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = 1;
        while (!q.isEmpty()) {
            int front = q.poll();
            arr.add(front);
            vis[front] = 1;
            for (Integer it : adj.get(front)) {
                if (vis[it] == 0) {
                    q.add(it);
                    vis[it] = 1;

                }
            }

        }
        return arr;

    }
}
