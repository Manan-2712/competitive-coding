package coursera.week3_greedy_algorithms;

import java.util.Scanner;

public class coinchangegreedy {

    public static int coinchange(int money) {
        int numcoins = 0;
        while (money > 0) {
            if (money >= 10) {
                money = money - 10;
            } else if (money >= 5) {
                money = money - 5;
            } else {
                money = money - 1;
            }
            numcoins = numcoins + 1;
        }
        return numcoins;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        System.out.println(coinchange(money));

    }

}
