package coursera.week2;

import java.util.Scanner;

public class gcd {

    public static long gcdcal(int a, int b) {
        if (b == 0) {
            return (long) a;
        } else {
            return gcdcal(b, a % b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(gcdcal(a, b));
    }
}
