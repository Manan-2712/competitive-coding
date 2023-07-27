package priorityqueue;

//https://www.codingninjas.com/studio/problems/merge-k-sorted-arrays_975379?leftPanelTab=0
import java.util.ArrayList;
import java.util.*;

class Pair implements Comparable<Pair> {
    int li;
    int di;
    int val;

    public Pair(int li, int di, int val) {
        this.li = li;
        this.di = di;
        this.val = val;
    }

    public int compareTo(Pair o) {
        return this.val - o.val;
    }
}

public class mergeksortedarrays {

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < kArrays.size(); i++) {
            Pair p = new Pair(i, 0, kArrays.get(i).get(0));
            pq.add(p);
        }
        while (pq.size() > 0) {
            Pair p = pq.remove();
            res.add(p.val);
            p.di++;

            if (p.di < kArrays.get(p.li).size()) {
                p.val = kArrays.get(p.li).get(p.di);
                pq.add(p);
            }

        }
        return res;
    }
}
