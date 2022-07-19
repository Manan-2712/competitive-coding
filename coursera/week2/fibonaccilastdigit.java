package coursera.week2;
import java.util.*;
public class fibonaccilastdigit {

    public static long fibdp(int n) {

        long n1 = 0;
        long n2 = 1;
        long n3;
        for (int i = 2; i <= n; i++) {
            n3 = (n1 + n2) % 10;
            n1 = n2;
            n2 = n3;
        }

        if (n <= 1) {
            return ((long) n);
        } else {

            return ((long) n2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibdp(n));
    }

}
