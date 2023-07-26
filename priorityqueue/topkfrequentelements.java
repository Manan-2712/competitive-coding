package priorityqueue;
//https://www.codingninjas.com/studio/problems/k-most-frequent-elements_3167808?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=1
import java.util.*;
import java.io.*;

public class topkfrequentelements {

    public static int[] KMostFrequent(int n, int k, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int nums : map.keySet()) {
            pq.add(nums);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        int result[] = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            result[i] = pq.remove();
            i++;
        }
        return result;
    }
}
