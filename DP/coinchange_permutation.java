package DP;
//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/coin-change-permutations-official/ojquestion
import java.io.*;
import java.util.*;

public class coinchange_permutation {

    public static int coins(int arr[], int target) {
        int dp[] = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] <= i) {
                    dp[i] += dp[i - arr[j]];
                }
            }
        }
        return dp[target];

    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(coins(arr, target));

    }
}
