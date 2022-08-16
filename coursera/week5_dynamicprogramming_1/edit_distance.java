package coursera.week5_dynamicprogramming_1;

import java.util.Scanner;

public class edit_distance {

    // static char ptr[][];// ptr array for keeping account of insertion,deletion or
    // substitution at each
    // cell.

    public static int editdp(String a, String b) {
        int n = a.length();
        int m = b.length();
        int dp[][] = new int[n + 1][m + 1];
        // ptr = new char[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
            // ptr[i][0] = 'R';
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
            // ptr[0][j] = 'L';
        }
        for (int j = 1; j <= m; j++) {
            for (int i = 1; i <= n; i++) {
                int op1 = dp[i][j - 1] + 1;// insertion
                int op2 = dp[i - 1][j] + 1;// deletion
                int op3 = dp[i - 1][j - 1];// for match
                int op4 = dp[i - 1][j - 1] + 1;// for mismatch;
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = Math.min(op1, Math.min(op2, op3));
                    // if (dp[i][j] == op1) {
                    // // ptr[i][j] = 'L';
                    // } else if (dp[i][j] == op2) {
                    // // ptr[i][j] = 'R';
                    // } else {
                    // // ptr[i][j] = 'S';
                    // }

                } else {
                    dp[i][j] = Math.min(op1, Math.min(op2, op4));
                    // if (dp[i][j] == op1) {
                    // // ptr[i][j] = 'L';

                    // } else if (dp[i][j] == op2) {
                    // // ptr[i][j] = 'R';

                    // } else {
                    // // ptr[i][j] = 'S';

                    // }

                }
            }
        }
        return dp[n][m];
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(editdp(s, t));
        scan.close();
    }

}
