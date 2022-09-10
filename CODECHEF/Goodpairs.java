//https://www.codechef.com/SEP221D/problems/EQPAIR
package CODECHEF;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Goodpairs {
    /* package codechef; // don't place package name! */

    /* Name of the class has to be "Main" only if the class is public. */
    public static void main(String[] args) throws java.lang.Exception {
        // lcm and gcd is same only when both no's are same.
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long res = 0;
            long arr[] = new long[n];
            HashMap<Long, Long> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0L) + 1);// store same no's with their frequency in map.
            }
            // int res=0;
            for (long key : map.keySet()) {
                long m = map.get(key);
                if (m > 1) {
                    res += m * (m - 1) / 2;// total possible pairs ,if a particular no has a frequency 3
                }                          // then total pairs possible is 3(3-1)/2=3.
            }
            System.out.println(res);
        }
    }
}
