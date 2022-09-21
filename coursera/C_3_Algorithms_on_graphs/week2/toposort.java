import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class toposort {

    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        int used[] = new int[adj.length];
        ArrayList<Integer> order = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<>();
        int n = adj.length;
        for (int i = 0; i < n; i++) {
            if (used[i] == 0) {
                dfs(adj, used, order, i, stack);
            }
        }
        while (!stack.isEmpty()) {
            order.add(stack.peek());
            stack.pop();
        }

        return order;
    }

    private static void dfs(ArrayList<Integer>[] adj, int[] used, ArrayList<Integer> order, int s,
            Stack<Integer> stack) {
        used[s] = 1;
        for (int elem : adj[s]) {
            if (used[elem] == 0) {
                dfs(adj, used, order, elem, stack);

            }
        }
        stack.push(s);
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
        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}
