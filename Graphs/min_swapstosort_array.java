package Graphs;
//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/minimum-number-of-swaps-required-to-sort-an-array-official/ojquestion
//https://www.youtube.com/watch?v=m-8_yQao-lI&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=10
import java.io.*;
import java.util.*;

public class min_swapstosort_array {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] st = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }

        System.out.println(minSwaps(arr));
    }

    public static int minSwaps(int[] arr1) {
        int n = arr1.length;
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(arr1[i], i);
        }
        Arrays.sort(arr);// firstly sort the array , then check the index values from the sorted
        int ans = 0; // array if they are equal to ith value then continue,else go to ith Pair
                     // element
        boolean vis[] = new boolean[n];// index and if that Pair element index is same as that index from
        for (int i = 0; i < n; i++) {// where we have come then there is a cycle and add cycle len in ans because
            if (vis[i] == true || i == arr[i].idx) {// cycle length'th element automatically will get it's
                continue;// original position.
            }
            int clen = 0;
            int j = i;
            while (vis[j] == false) {// this while loop is used for the cycle detection part
                vis[j] = true; // cycle is a part of array where there is a need to swap the
                clen++; // elements of original array to get a sorted array;
                j = arr[j].idx;
            }
            ans += clen - 1;
        }
        return ans;
    }

    private static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }
}
