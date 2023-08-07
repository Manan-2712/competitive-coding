//https://leetcode.com/problems/max-consecutive-ones/description/
public class maxconsecutiveones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int len = 0;
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 1) {
                count = 0;

            } else {
                count++;
            }

            res = Math.max(res, count);

        }
        return res;

    }
}
