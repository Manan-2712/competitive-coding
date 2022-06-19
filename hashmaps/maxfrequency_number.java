package hashmaps;

import java.util.*;
//https://www.codingninjas.com/codestudio/problems/maximum-frequency-number_920319?leftPanelTab=0

public class maxfrequency_number {

    public static int maxFrequencyNumber(int n, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int maximum_value = 0;
        int elem = Integer.MIN_VALUE;
        for (int i : arr) {
            if (map.get(i) > maximum_value) {
                maximum_value = map.get(i);// if array elements having same frequency then return that number that
                                           // appears first in array
                elem = i;
            }
        }
        return elem;
    }
}
