package DP;
/*
Problem:
	Coin change
	Given an unlimited supply of coins of given denominations,
	find the total number of ways to make a change of size n, by
	using no more than t coins.
*/
//https://www.youtube.com/watch?v=fdPcf3m7Ehw&list=PLVrpF4r7WIhTT1hJqZmjP10nxsmrbRvlf&index=13
public class coinchangenomorethan_t {

    public static int coinchangenomoreTcoins(int n, int k, int coins[]) {
        int dp[][] = new int[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0 && j > 0) {
                    dp[i][j] = 1;// key condition in this problem
                                 // this is condition which differs this problem from coinchange exactly one
                    continue;
                }
                for (int m = 0; m < coins.length; m++) {
                    if (i - coins[m] >= 0) {
                        dp[i][j] += dp[i - coins[m]][j - 1];
                    }
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int coins[] = { 1, 2, 3, 5 };
        System.out.println(coinchangenomoreTcoins(n, k, coins));
    }

}
