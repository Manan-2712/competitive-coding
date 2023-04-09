package Arrays;
//https://leetcode.com/problems/rotate-image/description//
  // SOLUTION VIDEO LINK -> https://www.youtube.com/watch?v=_FkR5zMwHQ0
import java.util.*;

public class mergeintervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                return a[0] - b[0];
            });
            // LIST of 1-D arrays
            List<int[]> list = new ArrayList<>();
            // ACCESSING each 1- D array from 2 -d array
            for (int[] interval : intervals) {
                if (list.size() == 0) {
                    list.add(interval);
                } else {
                    int previnterval[] = list.get(list.size() - 1);
                    if (interval[0] <= previnterval[1]) {
                        previnterval[1] = Math.max(previnterval[1], interval[1]);
                    } else {
                        list.add(interval);
                    }
                }

            }
            return list.toArray(new int[list.size()][]);
        }
    }
}
