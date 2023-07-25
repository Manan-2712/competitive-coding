package hashmaps;

import java.util.*;

//https://leetcode.com/problems/top-k-frequent-elements/description/
public class topKfrequentelements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int ans[] = new int[k];
        int j = 0;
        for (int i = 0; i < k; i++) {
            int freq = 0;
            int max = 0;

            for (Map.Entry<Integer, Integer> elem : map.entrySet()) {
                if (elem.getValue() >= freq) {
                    freq = elem.getValue();
                    max = elem.getKey();
                }
            }
            map.put(max, 0);
            ans[j] = max;
            j++;
        }
        return ans;
    }
}
