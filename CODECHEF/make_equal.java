package CODECHEF;
//https://www.codechef.com/AUG221D/problems/EQUALISE
import java.util.*;
import java.lang.*;
import java.io.*;

public class make_equal {
    /* package codechef; // don't place package name! */

    /* Name of the class has to be "Main" only if the class is public. */
    public static boolean ispower2(int n) {
        boolean ispower = false;
        for (int i = 0; i < 50; i++) {
            if (Math.pow(2, i) == n) {
                ispower = true;
                break;
            }
        }
        return ispower;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            int quot = 0;
            if (A <= B && (B % A == 0)) {
                quot = B / A;// if quotient can be presented in form of power of 2,then
            } else if (A >= B && (A % B == 0)) {// print "yes",else print "No".
                quot = A / B;
            }

            boolean ispower = ispower2(quot);
            if (ispower) {
                System.out.println("YES");
            } else {
                System.out.println("No");
            }

        }
    }
}
