package maths;

//https://leetcode.com/problems/non-overlapping-intervals/description/
import java.util.Arrays;

public class nonoverlappingintervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        int k = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start >= k) {
                k = end;
            } else {
                ans++;
            }
        }
        return ans;
    }

}
