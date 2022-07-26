package coursera.week3_greedy_algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class maximum_advertisementrevenue {

    public static long maxproduct(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result += (long) a[a.length - 1 - i] * (long) b[b.length - 1 - i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int j = 0; j < n; j++) {
            b[j] = sc.nextInt();
        }
        System.out.println(maxproduct(a, b));
    }

}
