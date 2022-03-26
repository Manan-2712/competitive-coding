package hashmaps;

import java.util.ArrayList;
import java.util.*;

class longest_subarrayzerosum {

    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxlen = 0;
        int i = -1;
        map.put(sum, i);
        while (i < arr.size() - 1) {
            i++;
            sum += arr.get(i);
            if (map.containsKey(sum) == false) {
                map.put(sum, i);
            } else {
                int len = i - map.get(sum);
                if (len > maxlen) {
                    maxlen = len;
                }
            }
        }
        return maxlen;

    }
}
