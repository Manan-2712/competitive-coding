package priorityqueue;

import java.util.PriorityQueue;

//https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1X
public class kthsmallest {
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        // First Approach

        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // for(int i=0;i<k;i++){
        // pq.add(arr[i]);
        // }
        // for(int i = k; i<=r; i++){
        // if(arr[i] < pq.peek()){
        // pq.remove();
        // pq.add(arr[i]);
        // }
        // }
        // return pq.peek();

        // SECOND APPROACH
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            pq.remove();
        }
        int res = pq.remove();
        return res;
    }
}
