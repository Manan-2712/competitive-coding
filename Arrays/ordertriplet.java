//https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/
public class ordertriplet {
    // similar to rain water trapping concept with little variation of
    // multiplication step.
    public long maximumTripletValue(int[] nums) {
        int maxleft[] = new int[nums.length];
        int maxright[] = new int[nums.length];
        int n = nums.length;
        maxleft[0] = nums[0];
        maxright[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            maxleft[i] = Math.max(maxleft[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            maxright[i] = Math.max(maxright[i + 1], nums[i]);
        }
        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            long curr = (long) (maxleft[i] - nums[i]) * maxright[i + 1];
            if (curr > ans) {
                ans = curr;
            }
        }

        return ans;
    }
}
