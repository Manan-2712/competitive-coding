//https://www.interviewbit.com/problems/maximum-absolute-difference/
package Interviewbit.arrays;

public class maximum_absolute_difference {

    public int maxArr(int[] A) {
        int n = A.length;
        int min1 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            max1 = Math.max(max1, A[i] + i);
            min1 = Math.min(min1, A[i] + i);
            max2 = Math.max(max2, A[i] - i);
            min2 = Math.min(min2, A[i] - i);
        }
        ans = Math.max(max2 - min2, max1 - min1);
        return ans;

    }
}
