package DP;

//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/zero-one-knapsack-official/ojquestion
import java.util.Scanner;

public class zero_oneknapsack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int wts[] = new int[n];
        int vals[] = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            wts[i] = sc.nextInt();
        }
        int cap = sc.nextInt();
        int dp[][] = new int[n + 1][cap + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j >= wts[i - 1]) {
                    int rcap = j - wts[i - 1];
                    if (dp[i - 1][rcap] + vals[i - 1] > dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][rcap] + vals[i - 1];// when current vals(i) participate .
                    } else {
                        dp[i][j] = dp[i - 1][j];// when current vals(i) doesn't take participate .
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n][cap]);

    }
}
