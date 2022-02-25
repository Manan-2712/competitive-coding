package CODECHEF;

import java.util.*;
import java.lang.*;
import java.io.*;

public class theProductMystery {

    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd((b % a), a);
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int B = sc.nextInt();
            int C = sc.nextInt();
            int res = C / gcd(B, C);
            System.out.println(res);

        }
    }
}
