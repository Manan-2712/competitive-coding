package DP;
//https://leetcode.com/problems/edit-distance/description/
public class editdistance {
    public int minDistance(String word1, String word2) {
        // RECURSIVE APPROACH

        // if(word1.length() == 0){
        // return word2.length();
        // }
        // if(word2.length() == 0){
        // return word1.length();
        // }
        // if(word1.charAt(0) == word2.charAt(0)){
        // return minDistance(word1.substring(1),word2.substring(1));
        // }
        // else{
        // int op1 = minDistance(word1,word2.substring(1)); // INSERT
        // int op2 = minDistance(word1.substring(1),word2); // DELETE
        // int op3 = minDistance(word1.substring(1),word2.substring(1));// SUBSTITUTE
        // return 1+Math.min(op1,Math.min(op2,op3));
        // }

        // DP APPROACH

        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(n - i) == word2.charAt(m - j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[n][m];

    }
}