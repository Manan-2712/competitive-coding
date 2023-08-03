package Graphs;
import java.util.*;

class pair {
    int node;
    int parent;

    public pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class courseschedule {

    public boolean helper(int numcourses, ArrayList<ArrayList<Integer>> adj, int visited[], int src) {
        visited[src] = 1;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(src, -1));
        while (!q.isEmpty()) {
            pair front = q.poll();
            int parent = front.parent;
            int node = front.node;
            for (Integer it : adj.get(node)) {
                if (visited[it] == 0) {
                    visited[it] = 1;
                    q.add(new pair(it, node));
                } else if (parent != it) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        int visited[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (helper(numCourses, adj, visited, i)) {
                    return true;
                }
            }
        }

        return false;

    }
}
