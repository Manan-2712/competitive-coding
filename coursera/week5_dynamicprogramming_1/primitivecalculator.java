package coursera.week5_dynamicprogramming_1;

import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class primitivecalculator {
    // STARTER FILE CODE:
    // private static List<Integer> optimal_sequence(int n) {
    // List<Integer> sequence = new ArrayList<Integer>();
    // while (n >= 1) {
    // sequence.add(n);
    // if (n % 3 == 0) {
    // n /= 3;
    // } else if (n % 2 == 0) {
    // n /= 2;
    // } else {
    // n -= 1;
    // }
    // }
    // Collections.reverse(sequence);
    // return sequence;
    // }
    public static List<Integer> minsteps(int n) {
        List<Integer> sequence = new ArrayList<>();
        int dp[] = new int[n + 1];
        // dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            int min = dp[i - 1];
            if (i % 2 == 0) {
                if (min >= dp[i / 2]) {
                    min = dp[i / 2];
                }
            }
            if (i % 3 == 0) {
                if (min >= dp[i / 3]) {
                    min = dp[i / 3];
                }
            }
            dp[i] = 1 + min;
        }
        System.out.println(dp[n]);
        // sequence.add(dp[n]);
        while (n >= 1) {
            sequence.add(n);
            int min = n - 1; // this is used for adding the that value of n which will take minimum number of
                             // steps to reach 1;
            if (n % 3 == 0 && dp[n] <= dp[min]) { // don't just blindly reduce the value of n by factor of 3 or by 2.
                n = n / 3; // first of all check that min is taking lesser number of steps to reduce value
                           // of n to 1 or n/3 orn/2
                min = n; // is taking lesser number of steps to reach to 1.Acc. to that update the value
                         // of n and min also .

            } else if (n % 2 == 0 && dp[n] <= dp[min]) {
                n = n / 2;
                min = n;
            } else {
                n -= 1;
                min = n;
            }
        }

        Collections.reverse(sequence);
        // return dp[n];
        return sequence;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // List<Integer> sequence = optimal_sequence(n);
        List<Integer> sequence = minsteps(n);
        // System.out.println(minsteps(n));
        // System.out.println(sequence.size()-1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
        // for(int i=0;i<sequence.size();i++){
        // System.out.print(sequence.get(i)+" ");
        // }
    }
}
