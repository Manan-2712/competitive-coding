package DP;

/*
Problem:
	Coin change
	Given an unlimited supply of coins of given denominations,
	find the total number of ways to make a change of size n, by
	using excatly t coins.
	f(i,t) = f(i-1, t-1) + f(i-2, t-1) + f(i-3, t-1) + f(i-5, t-1)
*/
//https://www.youtube.com/watch?v=fdPcf3m7Ehw&list=PLVrpF4r7WIhTT1hJqZmjP10nxsmrbRvlf&index=13
public class coinchange_exactly_t {
    public static int coinexactly(int n, int t, int coins[]) {
        int dp[][] = new int[n + 1][t + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= t; j++) {
                if (i > 0 && j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                for (int k = 0; k < coins.length; k++) {
                    if (i - coins[k] >= 0) {
                        dp[i][j] += dp[i - coins[k]][j - 1];
                    }
                }
            }
        }
        return dp[n][t];
    }

    public static void main(String[] args) {
        int n = 7;
        int t = 3;
        int coins[] = { 1, 2, 3, 5 };
        System.out.println(coinexactly(n, t, coins));
    }

}
