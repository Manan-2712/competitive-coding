package DP;
//
public class goldmineproblem {

    public static int maxGoldCollected(int[][] arr, int n, int m) {
        // USING DP APPROACH
        // DIVIDE PROBLEM INTO THREE SECTIONS
        // 1. FILL ONLY LAST COLOUMN
        // 2. FILL ONLY FIRST ROW WITH ALL VALID OPTIONS.
        // 3. FILL ONLY LAST ROW WITH ALL VALID OPTIONS.
        int dp[][] = new int[n][m];
        for (int j = m - 1; j >= 0; j--) {// FIRST COLOUMN AND THEN ROW
            for (int i = n - 1; i >= 0; i--) { // BECAUSE ROW TRAVERSAL IS NOT GOING TO MAKE ANY DIFFERENCE,OUR MAIN
                                               // FOCUS SHOULD BE ON COLOUMN ;
                if (j == m - 1) { // FOR LAST COLOUMN
                    dp[i][j] = arr[i][j];
                } else if (i == 0) { // FOR FIRST ROW
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else if (i == n - 1) { // FOR LAST ROW
                    dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j + 1], dp[i][j + 1]);
                } else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j + 1], Math.max(dp[i][j + 1], dp[i + 1][j + 1]));
                }
            }
        }

        int max = dp[0][0]; // OUR ANS WILL ALWAYS BE IN FIRST COLOUMN
        for (int i = 1; i < n; i++) {// TRAVERSAL OF FIRST TO FIND THE MAXIMUM ONE .
            if (dp[i][0] > max) {
                max = dp[i][0];
            }
        }
        return max;
    }
}
