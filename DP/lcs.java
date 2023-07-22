package DP;
//https://leetcode.com/problems/longest-common-subsequence/submissions/
public class lcs {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int storage[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            storage[i][0] = 0;
        }
        for (int j = 0; j < n + 1; j++) {
            storage[0][j] = 0;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(m - i) == text2.charAt(n - j)) {
                    storage[i][j] = 1 + storage[i - 1][j - 1];
                } else {
                    storage[i][j] = Math.max(storage[i - 1][j], storage[i][j - 1]);
                }
            }
        }
        return storage[m][n];
    }
}
