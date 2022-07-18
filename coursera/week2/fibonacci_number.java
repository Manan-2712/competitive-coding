package coursera.week2;

import java.util.Scanner;

public class fibonacci_number {
    public static long fibdp1(int n) {

        if (n <= 1) {
           return (long) n;
        } else {
  
           long dp[] = new long[n + 1]; // long array to avoid integer overflow.
           dp[0] = 0;
           dp[1] = 1;
           for (int i = 2; i <= n; i++) {
              dp[i] = dp[i - 1] + dp[i - 2];
           }
  
           return (long) dp[n];
        }
  
     }
  
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibdp1(n));
     }
    
}
