//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
// Leetcode 26.
public class Removeduplicatefromsorted {
    class Solution {
        public int removeDuplicates(int[] nums) {
            // OPTIMAL APPROACH
            int i = 0;
            int n = nums.length;
            for (int j = 1; j < n; j++) {
                if (nums[i] != nums[j]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1;
        }

        // BETTER APPROACH
        // Set<Integer> set = new TreeSet<>();
        // int n = nums.length;
        // for(int i=0;i<n;i++){
        // set.add(nums[i]);
        // }
        // int size = set.size();
        // int j =0;
        // for(int x:set){
        // nums[j]= x;
        // j++;
        // }
        // return set.size();
    }

}
