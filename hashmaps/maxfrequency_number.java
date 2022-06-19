package hashmaps;

import java.util.*;

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
                maximum_value = map.get(i);
                elem = i;
            }
        }
        return elem;
    }
}
