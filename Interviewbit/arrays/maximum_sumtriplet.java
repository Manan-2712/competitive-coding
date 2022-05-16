//https://www.interviewbit.com/problems/maximum-sum-triplet/
package Interviewbit.arrays;

import java.util.TreeSet;

public class maximum_sumtriplet {

    public int solve(int[] A) {
        int n = A.length;
        int ans = 0;
        int b[] = new int[n + 1];
        b[n - 1] = 0;
        for (int i = n - 1; i >= 0; i--) {
            b[i] = Math.max(b[i + 1], A[i]);

        }
        // int ans=0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(Integer.MIN_VALUE);
        for (int i = 0; i < n - 1; i++) {
            if (b[i + 1] > A[i]) {
                ans = Math.max(ans, set.lower(A[i]) + A[i] + b[i + 1]);
                set.add(A[i]);
            }
        }
        return ans;
    }
}
