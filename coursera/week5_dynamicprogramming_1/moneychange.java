package coursera.week5_dynamicprogramming_1;

import java.util.Scanner;

public class moneychange {
    public static int coinchange(int money[], int amt) {
        int dp[] = new int[amt + 1];
        dp[0] = 0;
        // dp[1]=1;
        for (int i = 1; i < dp.length; i++) {// used to fill dp array ;
            dp[i] = Integer.MAX_VALUE;// initial fill the dp[i] with max coins i.e with value of i.
            for (int j = 0; j < money.length; j++) {// for traversal on given money array (which contains coins
                                                    // denominations)
                if (i >= money[j]) {
                    int numcoins = (dp[i - money[j]]) + 1;// calculate the minimum number of ways to change that
                                                          // dp[i](current amount).
                    if (numcoins < dp[i]) {// if less than initail one update that with numcoins;
                        dp[i] = numcoins;
                    }
                }
            }
        }
        return dp[amt];
    }

    public static int coinchangefinal(int m) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int money[]=new int [n];
        // for(int i=0;i<n;i++){
        // money[i]= sc.nextInt();
        // }
        int money[] = { 1, 3, 4 };
        return coinchange(money, m);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        System.out.println(coinchangefinal(m));
    }

}
