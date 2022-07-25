package coursera.week3_greedy_algorithms;

import java.util.*;

public class fractionalknapsack {

    static class item implements Comparable<item> {
        int value;
        int weight;
        double cost;

        item(int value, int weight, double cost) {
            this.value = value;
            this.weight = weight;
            this.cost = cost;

        }

        public int compareTo(item o1) {// comparison on the basis of fraction i.e cost(value/weight)
            if (this.cost > o1.cost) {
                return -1;

            } else if (this.cost < o1.cost) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static double fracknapsack(int n, int cap, int[] value, int[] weight) {
        item[] itemsarr = new item[weight.length];
        for (int i = 0; i < n; i++) {
            double cost = (value[i] * 1.0) / weight[i];
            // items[i] = new item(value[i], weight[i], cost);
            item items = new item(value[i], weight[i], cost);
            itemsarr[i] = items;
        }
        Arrays.sort(itemsarr);

        double profit = 0;
        int rc = cap;
        for (int i = 0; i < itemsarr.length; i++) {
            if (itemsarr[i].weight <= rc) {
                profit += itemsarr[i].value;
                rc -= itemsarr[i].weight;
            } else {
                profit += itemsarr[i].value * ((double) rc / itemsarr[i].weight);
                rc = 0;
                break;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cap = sc.nextInt();
        int value[] = new int[n];
        int weight[] = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }

        System.out.println(fracknapsack(n, cap, value, weight));

    }

}
