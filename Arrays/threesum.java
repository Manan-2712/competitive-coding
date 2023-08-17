package Arrays;
import java.util.*;
//https://leetcode.com/problems/3sum/description/

public class threesum {
        public List<List<Integer>> twosum(int[]nums,int si,int ei,int target){
           // Arrays.sort(nums);
            int n = nums.length;
        
            int i = si;
            int j = ei;
            List<List<Integer>> ans = new ArrayList<>();
            if(n < 2){
                return ans;
            }
            while(i < j){
                if(i != si && nums[i]==nums[i-1]){
                    i++;
                    continue;
                }
                if(nums[i] + nums[j] == target){
                    List<Integer> temp= new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    ans.add(temp);
                    i++;
                    j--;
                }
                else if(nums[i] + nums[j] < target){
                    i++;
                }
                else{
                    j--;
                }
            
            }
            return ans;
    
    
        }
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> res = new ArrayList<>();
             if(n < 3){
                return res;
            }
            for(int i=0;i<=n-3;i++){
                if( i >0 && nums[i] == nums[i-1]){
                    continue;// to overcome repetition
                }
                int val = nums[i];
                int newtarget =  0 - val;
                List<List<Integer>> ans = twosum(nums,i+1,n-1,newtarget);
                for(List<Integer> list :ans){
                    list.add(val);
                    res.add(list);
                }
            }
            return res;
    
            
        }
    }
