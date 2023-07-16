//https://leetcode.com/problems/maximum-product-subarray/submissions/
public class maximumproductsubarray {
    class Solution {
        // Brute Force
        // public int maxProduct(int nums[]) {
        // int result = Integer.MIN_VALUE;
        // for(int i=0;i<nums.length;i++)
        // for(int j=i;j<nums.length;j++) {
        // int prod = 1;
        // for(int k=i;k<=j;k++)
        // prod *= nums[k];
        // //System.out.println(prod);
        // result = Math.max(result,prod);
        // }
        // return result;
        // }
        // }

        // second brute force;
        // public int maxProduct(int[] nums) {

        // int max = Integer.MIN_VALUE;

        // for(int i = 0; i < nums.length; i++) {
        // int temp = 1;
        // for(int j = i; j < nums.length; j++) {
        // temp *= nums[j];

        // max = Math.max(max, temp);
        // }
        // }

        // return max;
        // }

        // OPTIMAL APPROACH
        public int maxProduct(int nums[]) {
            int prefix = 1;
            int suffix = 1;
            int ans = Integer.MIN_VALUE;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (prefix == 0) {
                    prefix = 1;
                }
                if (suffix == 0) {
                    suffix = 1;
                }
                prefix = prefix * nums[i];
                suffix = suffix * nums[n - i - 1];
                ans = Math.max(ans, Math.max(prefix, suffix));
            }
            return ans;

        }
    }
}
