package Arrays;

//https://www.codingninjas.com/codestudio/problems/873366?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class repeat_and_missing {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int xor = 0;
        int res[] = new int[2];
        for (Integer elem : arr) {
            xor ^= elem;
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        int rsbm = xor & -xor;
        int x = 0;
        int y = 0;
        for (Integer val : arr) {
            if ((val & rsbm) == 0) {
                x ^= val;
            } else {
                y ^= val;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & rsbm) == 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == x) {
                res[0] = y;
                res[1] = x;
                break;
            } else if (arr.get(i) == y) {
                res[0] = x;
                res[1] = y;
                break;
            }
        }
        return res;
    }
}
