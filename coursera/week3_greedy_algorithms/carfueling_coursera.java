package coursera.week3_greedy_algorithms;

import java.util.Scanner;

public class carfueling_coursera {

    public static int computeMinRefills(int dist, int tank, int stops[]) {
        int numrefills = 0;
        int currentposition = 0;
        int lastrefill = 0;
        int n = stops.length - 2;
        while (currentposition <= n) {
            lastrefill = currentposition;
            while (currentposition <= n && (stops[currentposition + 1] - stops[lastrefill]) <= tank) {
                currentposition = currentposition + 1;
            }
            if (currentposition == lastrefill) {
                return -1;
            }
            if (currentposition <= n) {
                numrefills += 1;
            }
        }
        return numrefills;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n + 2];
        stops[0] = 0;
        stops[n + 1] = dist;
        for (int i = 1; i <= n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
        scanner.close();
    }

}
