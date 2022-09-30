import java.util.ArrayList;
import java.util.Scanner;

public class negativecycle {

    private static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
        // System.out.println("length is"+adj.length);
        long dist[] = new long[adj.length];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[0] = 0;
        // for(int j:dist){
        // System.out.print(j+" ");
        // }
        // System.out.println();
        // int n = adj.length;
        // dist[0] = 0;
        for (int i = 0; i <= adj.length - 1; i++) {
            for (int u = 0; u < adj.length - 1; u++) {
                for (int v : adj[u]) {
                    int v_index = adj[u].indexOf(v);
                    if (dist[v] > dist[u] + cost[u].get(v_index)) {
                        dist[v] = dist[u] + cost[u].get(v_index);
                        // System.out.println("i "+i);
                        if (i == adj.length - 1) {
                            return 1;
                        }
                    }
                }
            }
        }
  
      

        return 0;
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
        System.out.println(negativeCycle(adj, cost));
    }
}
