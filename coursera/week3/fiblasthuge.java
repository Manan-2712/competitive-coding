package coursera.week3;

import java.util.Scanner;

public class fiblasthuge {
    public static long pisanoperiodcal(long m) {
        long previous = 0;
        long current = 1;
        long pisano = 0;
        for (int i = 0; i < m * m; i++) {
            long temp = 0;
            temp = current;
            current = (previous + current) % m;
            previous = temp;

            if (previous == 0 && current == 1) {
                pisano = i + 1;
            }
        }
        return pisano;
    }

    public static long fibonaccihugecal(long n, long m) {
        long pisanoperiod = pisanoperiodcal(m);
        n = n % pisanoperiod;

        if (n <= 1) {
            return n;
        }
        long prev = 0;
        long curr = 1;
        for (int i = 0; i < n-1; i++) {
            //long tempo = 0;
           long  tempo = curr;
            curr = (prev + curr) % m;
            prev = tempo;

        }
        return curr % m;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        // System.out.println(getFibonacciHugeNaive(n, m));
        // System.out.println(pisanoperiodcal(5));
        System.out.println(fibonaccihugecal(n, m));
}
}
