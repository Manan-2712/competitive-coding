package CODECHEF;

import java.util.Arrays;
import java.util.Scanner;

public class intresting_subarray {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            Arrays.sort(arr);
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;// sorting 
            max = Math.max(arr[0] * arr[0], arr[n - 1] * arr[n - 1]);// first two elements can be -ve(-10 * -10),for finding max
            if (arr[0] < 0 && arr[n - 1] > 0) {// for finding min
                min = arr[0] * arr[n - 1];// most min element ,if present 
            } else {
                for (int i = 0; i < n; i++) {
                    min = Math.min(min, arr[i] * arr[i]);// else this 
                }
            }

            System.out.println(min + " " + max);
        }
    }
}
