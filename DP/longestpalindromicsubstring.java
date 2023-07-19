package DP;

//https://leetcode.com/problems/longest-palindromic-substring/submissions/998603191/
public class longestpalindromicsubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        int si = 0;
        int ei = 0;
        int ans[] = new int[2];
        boolean dp[][] = new boolean[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < dp.length; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;

                    } else {
                        dp[i][j] = false;
                    }
                }
                if (dp[i][j]) {
                    si = i;
                    ei = j;
                }
            }
        }
        return s.substring(si, ei + 1);

    }
}
