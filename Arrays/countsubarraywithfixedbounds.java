package Arrays;

public class countsubarraywithfixedbounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        boolean minf = false, maxf = false;
        int start = 0, minstart = 0, maxstart = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < minK || nums[i] > maxK) {
                minf = false;
                maxf = false;
                start = i + 1;
            }
            if (nums[i] == minK) {
                minf = true;
                minstart = i;
            }
            if (nums[i] == maxK) {
                maxf = true;
                maxstart = i;
            }
            if (minf && maxf) {
                res += Math.min(minstart, maxstart) - start + 1;
                // res+=1;
            }
        }
        return res;

    }
}
