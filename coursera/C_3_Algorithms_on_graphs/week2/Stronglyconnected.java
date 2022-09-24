import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Stronglyconnected {

    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {
        // STEP1. DFS using stack.
        boolean[] isvisited = new boolean[adj.length];
        Stack<Integer> stack = new Stack<>();
        int n = adj.length;
        for (int i = 0; i < n; i++) {
            if (!isvisited[i]) {
                dfs1(adj, i, isvisited, stack);
            }
        }
        // int n = adj.length;

        // STEP 2.Graph reversal
        ArrayList<Integer>[] adj2 = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj2[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> nbr = adj[i];
            for (int elem : nbr)
                adj2[elem].add(i);
        }
        // STEP 3. Apply dfs on elements in stack order.
        int ans = 0;
        isvisited = new boolean[n];
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (isvisited[top] == false) {
                dfs2(adj2, top, isvisited);
                ans++;
            }
        }

        return ans;
    }

    public static void dfs1(ArrayList<Integer>[] adj, int src, boolean[] isvisited, Stack<Integer> stack) {
        isvisited[src] = true;
        for (int elem : adj[src]) {
            if (isvisited[elem] == false) {
                dfs1(adj, elem, isvisited, stack);
            }
        }
        stack.push(src);
    }

    public static void dfs2(ArrayList<Integer>[] adj, int src, boolean[] isvisited) {
        isvisited[src] = true;
        for (int elem : adj[src]) {
            if (isvisited[elem] == false)
                dfs2(adj, elem, isvisited);
        }
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
        System.out.println(numberOfStronglyConnectedComponents(adj));
    }
}
