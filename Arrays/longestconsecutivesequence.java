package Arrays;

import java.util.*;

//https://leetcode.com/problems/longest-consecutive-sequence/description/
//https://www.youtube.com/watch?v=oO5uLE7EUlM&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=29
public class longestconsecutivesequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashset = new HashSet<Integer>();
        for (int n : nums) {
            hashset.add(n);
        }
        int longestseq = 0;
        for (int num : nums) {
            // search for num -1 is because to reach at the start of the longest sequence.
            if (!hashset.contains(num - 1)) {
                int currentnum = num;
                int currlength = 1;

                // after getting a start point of longest sequence we will increment a count
                // till we get a currentnum+1 value in set.
                while (hashset.contains(currentnum + 1)) {
                    currentnum += 1;
                    currlength += 1;
                }
                longestseq = Math.max(longestseq, currlength);
            }
        }

        return longestseq;

    }
}
