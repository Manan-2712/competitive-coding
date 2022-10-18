//https://leetcode.com/contest/weekly-contest-315/problems/largest-positive-integer-that-exists-with-its-negative/
package Arrays;

import java.util.*;

public class largestpositive_withnegative {
    public int findMaxK(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(i, nums[i]);
        }
        int res = -1;
        for (int p : nums) {
            if (map.containsValue(-p)) {
                res = Math.max(res, p);
            }
        }

        return res;
    }
}
