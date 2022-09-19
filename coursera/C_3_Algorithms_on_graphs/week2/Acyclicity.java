//https://www.youtube.com/watch?v=Tl5qbEmEQyY

package coursera.C_3_Algorithms_on_graphs.week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Acyclicity {

    private static int acyclic(ArrayList<Integer>[] adj) {
        boolean isvisited[] = new boolean[adj.length];
        boolean dfsvisited[] = new boolean[adj.length];
        int n = adj.length;
        for (int i = 0; i < n; i++) {
            if (!isvisited[i]) {
                boolean cycledetected = acyclichelper(adj, i, isvisited, dfsvisited);
                if (cycledetected) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private static boolean acyclichelper(ArrayList<Integer>[] adj, int src, boolean[] isvisited, boolean[] dfsvisited) {
        isvisited[src] = true;
        dfsvisited[src] = true;
        for (int elem : adj[src]) {
            if (!isvisited[elem]) {
                boolean checkcycle = acyclichelper(adj, elem, isvisited, dfsvisited);
                if (checkcycle) {
                    return true;// if node is present in a dfs cycle then there is a cycle
                }
            } else if (dfsvisited[elem]) {

                return true;// else mark that particular node false;

            }
        }
        dfsvisited[src] = false;
        return false;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic(adj));
        // for(int i=0;i<adj.length;i++){
        // System.out.print(i+"->");
        // for(int x:adj[i]){
        // System.out.print(x);
        // }
        // System.out.println();
        // }
    }
}
