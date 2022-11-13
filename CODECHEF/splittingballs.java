//https://www.codechef.com/NOV221D/problems/SPBALL
package CODECHEF;

import java.util.*;
import java.lang.*;
import java.io.*;

public class splittingballs {
    /* package codechef; // don't place package name! */
    // package com;

    /* Name of the class has to be "Main" only if the class is public. */

    public static void main(String[] args) throws java.lang.Exception {
        // fact array is used to store the factorial of each number to minimize the time
        // complexity;
        long mod = 1000000007L;
        long size = (long) Math.pow(10, 6) + 1;
        long fact[] = new long[1000001];
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i < size; i++) {
            fact[i] = i * fact[i - 1];
            fact[i] = fact[i] % mod;
        }
        // idea is to count the sum of factorial of each number of array;
        while (t-- > 0) {
            long n = sc.nextLong();
            long ar[] = new long[(int) n];
            for (int i = 0; i < n; i++) {
                ar[i] = sc.nextLong();
            }
            long res = 0;
            for (int i = 0; i < n; i++) {
                res = (res + fact[(int) ar[i]]);
                res = res % mod;
            }
            System.out.println(res % mod);
        }
    }
}
