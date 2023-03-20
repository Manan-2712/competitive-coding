package Arrays;
import java.util.*;
public class subset2 {
    // class Solution {
    // // THIS SOLUTION WITH EXTRA SPACE.
    // public List<List<Integer>> subsetsWithDup(int[] nums) {
    // Arrays.sort(nums);
    // Set<List<Integer>> res = new HashSet<>();
    // List<Integer> temp = new ArrayList<>();
    // generatewithoutduplicate(nums,0,res,temp);
    // return (new ArrayList<>(res));
    // }
    // public void generatewithoutduplicate(int[]nums,int start,Set<List<Integer>>
    // res,List<Integer> temp){
    // res.add(new ArrayList<>(temp));
    // if(start >= nums.length){
    // return ;
    // }
    // for(int i= start;i<nums.length;i++){
    // temp.add(nums[i]);
    // generatewithoutduplicate(nums,i+1,res,temp);
    // temp.remove(temp.size()-1);
    // }

    // }
    // }

    // THIS SOLUTION WITHOUT EXTRA SPACE.
    void generatewithoutdup(int ind, int nums[], List<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            generatewithoutdup(i + 1, nums, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        generatewithoutdup(0, nums, new ArrayList<>(), ans);
        return ans;
    }
}
