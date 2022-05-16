//https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
package Interviewbit.arrays;

public class max_sum_contigousarray {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {
        int cursum = 0;
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            cursum += A[i];
            if (cursum > maxsum) {
                maxsum = cursum;
            }
            if (cursum < 0) {
                cursum = 0;
            }
        }
        return maxsum;
    }

}
