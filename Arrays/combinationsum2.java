package Arrays;
import java.util.*;
public class combinationsum2 {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
           Arrays.sort(candidates);
            List<List<Integer>> res= new ArrayList<>();
            generatecombinations(0,candidates,new ArrayList(),res,target);
            return res;
            
        }
        void generatecombinations(int start,int []nums,List<Integer>temp,List<List<Integer>> res,int target){
            if(target==0){
                res.add(new ArrayList(temp));
            }
                if(target<0){
                    return ;
                }
            for(int i=start;i<nums.length;i++){
                if(i>start && nums[i]==nums[i-1]){
                    continue;
                }
                temp.add(nums[i]);
                generatecombinations(i+1,nums,temp,res,target-nums[i]);
                temp.remove(temp.size()-1);
            }
                
            }
        
    }

