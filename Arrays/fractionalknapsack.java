import java.util.*;
import java.io.*;
//https://www.codingninjas.com/codestudio/problems/975286?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
//Following is the class structure of the Pair class:

class Pair {
    int weight;
    int value;

    Pair(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

}

class Paircomparator implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        double itema = (double) a.value / (double) a.weight;
        double itemb = (double) b.value / (double) b.weight;
        if (itema < itemb) {
            return 1;
        } else if (itema > itemb) {
            return -1;
        } else {
            return 0;
        }
    }

}

public class fractionalknapsack {

    public static double maximumValue(Pair[] items, int n, int w) {
        Paircomparator pc = new Paircomparator();
        // sorting on basis of per unit value;
        Arrays.sort(items, pc);
        int currweight = 0;
        double profit = 0.0;
        for (int i = 0; i < n; i++) {
            if (currweight + items[i].weight <= w) {
                currweight += items[i].weight;
                profit += items[i].value;
            } else {
                int remain = w - currweight;
                profit += ((double) items[i].value / (double) items[i].weight) * (double) remain;
                break;
            }
        }
        return profit;
    }
}
