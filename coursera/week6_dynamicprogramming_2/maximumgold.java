package coursera.week6_dynamicprogramming_2;
import java.util.Scanner;

public class maximumgold {
    
    public static int optimalweight(int W, int[] w) {
        int n = w.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int j = 0; j <=W; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <=n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j >= w[i - 1]) {
                    int op1 = dp[i - 1][j];
                    int op2 = dp[i - 1][j - w[i - 1]] + w[i - 1];
                    dp[i][j] = Math.max(op1, op2);  
                }
                else {
                    dp[i][j]= dp[i-1][j];
                }
            }
            
        }
    
        return dp[n][W];

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalweight(W, w));
    }
}
