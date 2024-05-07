package maths;

import java.util.*;

public class minimumtomake_kperiodic {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> map = new HashMap<>();
        int len = word.length();
        int j = 0;
        for (int i = 0; i < len; i++) {
            if ((i + 1) % k == 0) {
                map.put(word.substring(j, i + 1), map.getOrDefault(word.substring(j, i + 1), 0) + 1);
                j = i + 1;
            }

        }
        System.out.println(map);
        String toCompare = "";
        int minop = 0;
        int maxval = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> it : map.entrySet()) {
            String key = it.getKey();
            int val = it.getValue();
            maxval = Math.max(maxval, val);
            if (val >= maxval) {
                toCompare = key;
            }
        }

        for (Map.Entry<String, Integer> mp : map.entrySet()) {
            if (mp.getKey().equals(toCompare)) {
                minop += 0;
            } else {

                minop += mp.getValue();
            }
        }
        return minop;

    }
}
