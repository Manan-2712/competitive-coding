//https://leetcode.com/problems/minimum-size-subarray-sum/description/
public class minlengthsubarray {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int ep = 0, sp = 0; ep < nums.length; ep++) {
            sum += nums[ep];
            while (sum >= target) {
                int len = ep - sp + 1;
                if (len < min) {
                    min = len;
                }

                sum -= nums[sp];
                sp++;
            }

        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;

    }
}
