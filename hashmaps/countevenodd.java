//https://www.codingninjas.com/codestudio/problems/count-even-odd_757508?leftPanelTab=1
package hashmaps;

import java.util.*;

public class countevenodd {

    public static int[] countEvenOdd(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int even = 0;
        int odd = 0;
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        }
        for (Integer key : map.keySet()) {
            if (map.get(key) % 2 == 0) {
                even++;
            } else {
                odd++;
            }

        }
        return new int[] { odd, even };

    }
}
