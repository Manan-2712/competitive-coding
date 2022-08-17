package coursera.week5_dynamicprogramming_1;

import java.util.Scanner;

public class lcs2 {

    // TC = O(MN),where m and n are lengths arrays a and b .

    public static int lcslength(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int dp[][] = new int[m + 1][n + 1];
        // dp[0][0]=0;
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // for(int i=0;i<dp.length;i++){
        // for(int j =0;j<dp[0].length;j++){
        // System.out.print(dp[i][j]+" ");
        // }
        // System.out.println();
        // }
        return dp[m][n];

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcslength(a, b));
    }
}
