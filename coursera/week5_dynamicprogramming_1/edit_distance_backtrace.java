package coursera.week5_dynamicprogramming_1;

import java.util.Scanner;

public class edit_distance_backtrace {

    static char ptr[][];// ptr array for keeping account of insertion,deletion or substitution at each
                        // cell.

    public static int editdp(String a, String b) {
        int n = a.length();
        int m = b.length();
        int dp[][] = new int[n + 1][m + 1];
        ptr = new char[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
            ptr[i][0] = 'R';
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
            ptr[0][j] = 'L';
        }
        for (int j = 1; j <= m; j++) {
            for (int i = 1; i <= n; i++) {
                int op1 = dp[i][j - 1] + 1;// insertion
                int op2 = dp[i - 1][j] + 1;// deletion
                int op3 = dp[i - 1][j - 1];// for match
                int op4 = dp[i - 1][j - 1] + 1;// for mismatch;
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = Math.min(op1, Math.min(op2, op3));
                    if (dp[i][j] == op1) {
                        ptr[i][j] = 'L';
                    } else if (dp[i][j] == op2) {
                        ptr[i][j] = 'R';
                    } else {
                        ptr[i][j] = 'S';
                    }

                } else {
                    dp[i][j] = Math.min(op1, Math.min(op2, op4));
                    if (dp[i][j] == op1) {
                        ptr[i][j] = 'L';

                    } else if (dp[i][j] == op2) {
                        ptr[i][j] = 'R';

                    } else {
                        ptr[i][j] = 'S';

                    }

                }
            }
        }
        return dp[n][m];
    }

    public static void backtracedp(char ptr[][], int i, int j, String a, String b) {
        if (i == 0 && j == 0) {
            return;
        }

        if (ptr[i][j] == 'L') {
            backtracedp(ptr, i, j - 1, a, b);
            System.out.println("insertion of " + b.charAt(j - 1) + " + 1");
        } else if (ptr[i][j] == 'R') {
            backtracedp(ptr, i - 1, j, a, b);
            System.out.println("deletion of " + a.charAt(i - 1) + " + 1");
        } else {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                backtracedp(ptr, i - 1, j - 1, a, b);
                System.out.println("Match occurs " + a.charAt(i - 1) + " " + b.charAt(j - 1) + " + 0");
            } else {
                backtracedp(ptr, i - 1, j - 1, a, b);
                System.out.println("substitution of " + a.charAt(i - 1) + " with " + b.charAt(j - 1) + " + 1");
            }

        }
    }

    public static void main(String[] args) {
        // String a= "editing ";
        // String b ="distance";
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        System.out.println(editdp(A, B));
        backtracedp(ptr, A.length(), B.length(), A, B);
        // System.out.println(Math.min(4, 4));
        sc.close();
    }
}
