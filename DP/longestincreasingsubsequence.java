package DP;
//https://leetcode.com/problems/longest-increasing-subsequence/description/
public class longestincreasingsubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int omax = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = 1 + max;
            if (dp[i] > omax) {
                omax = dp[i];
            }
        }
        return omax;
    }
}
