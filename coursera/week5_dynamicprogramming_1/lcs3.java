package coursera.week5_dynamicprogramming_1;

import java.util.Scanner;

public class lcs3 {
    public static int lcslength3(int[] a, int[] b, int c[]) {
        int m = a.length;
        int n = b.length;
        int p = c.length;
        int dp[][][] = new int[m + 1][n + 1][p + 1];
        // dp[0][0]=0;
        for (int j = 0; j <= n; j++) {
            dp[0][j][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0][0] = 0;
        }
        for (int k = 0; k <= p; k++) {
            dp[0][0][k] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= p; k++)
                    if (a[i - 1] == b[j - 1] && b[j - 1] == c[k - 1]) {
                        dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
                    } else {

                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max((dp[i][j - 1][k]), dp[i][j][k - 1]));
                    }
            }
        }
        // for(int i=0;i<dp.length;i++){
        // for(int j =0;j<dp[0].length;j++){
        // System.out.print(dp[i][j]+" ");
        // }
        // System.out.println();
        // }
        return dp[m][n][p];

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcslength3(a, b, c));
    }
}
