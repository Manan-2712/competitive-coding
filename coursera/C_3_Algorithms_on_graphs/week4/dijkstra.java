import java.beans.Visibility;
import java.util.*;

class pair implements Comparable<pair> {
    int node;
    int dist;

    public pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    public int compareTo(pair o) {
        return this.dist - o.dist;
    }

}

public class dijkstra {

    private static long distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        // pair p = new pair(0, 0);
        int dist[] = new int[adj.length];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;
        PriorityQueue<pair> q = new PriorityQueue<>();
        q.add(new pair(s, dist[s]));
        while (!q.isEmpty()) {
            pair rem = q.remove();
            int uindex = rem.node;
            for (int elem : adj[uindex]) {
                int vindex = adj[uindex].indexOf(elem);
                if (dist[elem] > dist[uindex] + cost[uindex].get(vindex)) {
                    dist[elem] = dist[uindex] + cost[uindex].get(vindex);
                    q.add(new pair(elem, dist[elem]));
                }

            }
        }
        if (dist[t] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[t];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        // System.out.println(adj[0].indexOf(2));
        // for(int i=0;i<n;i++){
        // System.out.print(i+"->");
        // for(int elem:adj[i]){
        // System.out.print(elem);
        // }
        // System.out.println();
        // }
        // for(int i=0;i<cost.length;i++){
        // System.out.print(i+"=");
        // for(int elem:cost[i]){
        // System.out.print(elem+" ");
        // }
        // System.out.println();
        // }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}
F