package priorityqueue;
//https://practice.geeksforgeeks.org/problems/kth-largest-element-in-a-stream2220/1
import java.io.*;
import java.util.*;

public class kth_largest_instream {
    // { Driver Code Starts

    // public static void main(String args[]) throws IOException {
    // BufferedReader read =
    // new BufferedReader(new InputStreamReader(System.in));
    // int t = Integer.parseInt(read.readLine());
    // while (t-- > 0) {
    // String S[] = read.readLine().split(" ");

    // int k = Integer.parseInt(S[0]);
    // int n = Integer.parseInt(S[1]);

    // String S1[] = read.readLine().split(" ");

    // int[] arr = new int[n];

    // for(int i=0; i<n; i++)
    // arr[i] = Integer.parseInt(S1[i]);

    // Solution ob = new Solution();
    // int[] ptr = ob.kthLargest(k,arr,n);
    // for(int i=0; i<n; i++)
    // System.out.print(ptr[i] + " ");
    // System.out.println();
    // }
    // }
    // }
    // // } Driver Code Ends

    static int[] kthLargest(int k, int[] arr, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans[] = new int[n];
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = 0; i <= k - 2; i++) {
            ans[i] = -1;
        }
        ans[k - 1] = pq.peek();
        for (int i = k; i < n; i++) {
            if (arr[i] < pq.peek()) {
                ans[i] = pq.peek();
            } else {
                pq.poll();
                pq.add(arr[i]);
                ans[i] = pq.peek();
            }
        }
        return ans;
    }
};
