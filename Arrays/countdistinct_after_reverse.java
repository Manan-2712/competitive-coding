//https://leetcode.com/contest/weekly-contest-315/problems/count-number-of-distinct-integers-after-reverse-operations/
package Arrays;

import java.util.*;

public class countdistinct_after_reverse {
    public static int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            int rem = num % 10;
            rev = rev * 10 + rem;
            num = num / 10;
        }
        return rev;
    }

    public int countDistinctIntegers(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
            int rev_in = reverse(nums[i]);
            arr.add(rev_in);
        }
        HashSet<Integer> set = new HashSet<>(arr);
        return set.size();

    }
}
