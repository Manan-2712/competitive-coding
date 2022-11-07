//https://leetcode.com/contest/weekly-contest-318/problems/maximum-sum-of-distinct-subarrays-with-length-k/
package Arrays;
import java.util.HashSet;

public class maximumsumdistinctsubarray_klength{
public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        int i=0;
        int j=0;
        int n = nums.length;
        long ans =0;
        long sum=0;
        // Set is created to handle duplicacy,if j-i==k we should calculate the answer and then remove the leftmost element from the sum as well as from the set and increment the i;
// other two else if is to handle the actual duplicacy ,if the element is distinct, add it to sum ,add it to set and increment j,
        // else if element is duplicate , remove the ith element from the set till we get the distinct element or duplicate element with occurence 1.
        while(i< n- k + 1){
            if(j-i == k){
                ans = Math.max(ans,sum);
                sum -=nums[i];
                set.remove(nums[i]);
                i++;
            }
            else if(!set.contains(nums[j])){
                sum+=nums[j];
                set.add(nums[j]);
                j++;
            }
            else{
                sum-=nums[i];
                set.remove(nums[i]);
                i++;
            }
        }
        return ans;
        
        
    }
}