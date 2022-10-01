package coursera.C_3_Algorithms_on_graphs.week5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class node {
    int x;
    int y;
    int parent;
    int rank;

    public node(int a, int b, int c) {
        x = a;
        y = b;
        parent = c;
        rank = 0;
    }
}

class edge {
    int src;
    int dest;
    double weight;

    public edge(int src, int dest, double c) {
        this.src = src;
        this.dest = dest;
        this.weight = c;
    }
    // public int compareTo(edge o){
    // return (int) (this.weight- o.weight);
    // }
}

public class kruskalalgo {

    public static void makeset(int i, node[] nodesarr, int[] x, int[] y) {
        nodesarr[i] = new node(x[i], y[i], i);
    }

    public static double weight(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public static int find(int i, node[] nodesarr) {
        if (i != nodesarr[i].parent) {
            nodesarr[i].parent = find(nodesarr[i].parent, nodesarr);
        }
        return nodesarr[i].parent;
    }

    public static void union(int src, int dest, node[] nodesarr) {
        int src_id = find(src, nodesarr);
        int dest_id = find(dest, nodesarr);
        if (src_id == dest_id) {
            return;
        }
        if (src_id != dest_id) {
            if (nodesarr[src_id].rank > nodesarr[dest_id].rank) {
                nodesarr[dest_id].parent = src_id;
            }

            else {
                nodesarr[src_id].parent = dest_id;
                if (nodesarr[src_id].rank == nodesarr[dest_id].rank) {
                    nodesarr[dest_id].rank += 1;
                }
            }
        }
    }

    private static double minimumDistance(int[] x, int[] y) {
        double result = 0.;
        int n = x.length;
        node[] nodesarr = new node[n];
        for (int i = 0; i < n; i++) {
            makeset(i, nodesarr, x, y);
        }
        PriorityQueue<edge> edges = new PriorityQueue<>(new Comparator<edge>() {

            @Override
            public int compare(edge o1, edge o2) {

                return o1.weight < o2.weight ? -1 : 1;
            }
        });
        // ArrayList<edge>edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.offer(new edge(i, j, weight(x[i], y[i], x[j], y[j])));
            }
        }
        while (!edges.isEmpty()) {
            edge curedge = edges.poll();
            int u = curedge.src;
            int v = curedge.dest;
            int src_id = find(u, nodesarr);
            int dest_id = find(v, nodesarr);
            if (src_id != dest_id) {
                // union(u,v, nodesarr);
                result += curedge.weight;
                union(u, v, nodesarr);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        System.out.println(minimumDistance(x, y));
    }
}
