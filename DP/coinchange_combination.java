package DP;

public class coinchange_combination {

    public static void coinchange(int arr[], int tar, int sum, String ans, int index) {

        if (index == arr.length) {
            if (sum == tar) {
                System.out.println(ans);

            }
            return;
        }
        for (int j = tar / arr[index]; j >= 1; j--) {
            String part = "";
            for (int i = 0; i < j; i++) {
                part += arr[index] + " ";
            }
            coinchange(arr, tar, sum + (arr[index] * j), ans + part, index + 1);
        }
        coinchange(arr, tar, sum, ans, index + 1);

    }

    public static int coinchangeDP(int arr[], int tar) {
        int dp[] = new int[tar + 1];
        dp[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j < dp.length; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        return dp[tar];
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 5 };
        int tar = 8;
        // coinchange(arr, tar, 0, " ", 0);
        System.out.println(coinchangeDP(arr, tar));
    }

}
