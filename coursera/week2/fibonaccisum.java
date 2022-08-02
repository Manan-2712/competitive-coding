package coursera.week2;

import java.util.Scanner;

public class fibonaccisum {
    public static long pisanoperiodcal(long m) {
        long previous = 0;
        long current = 1;
        long pisano = 0;
        for (int i = 0; i <= m * m; i++) {
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
        long sum = 1;
        for (int i = 2; i <= n; i++) {
            // long tempo = 0;
            long tempo = curr;
            curr = (prev + curr) % m;
            prev = tempo;
            sum += curr;

        }
        // return curr % m;
        return sum % m;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = 10;
        // long s = getFibonacciSumNaive(n);
        System.out.println(fibonaccihugecal(n, m));
    }

}
