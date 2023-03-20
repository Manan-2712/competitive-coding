package Arrays;
import java.util.*;
public class subsets {
        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            List<List<Integer>> res= new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            generatesubsets(nums, 0,temp,res);
             return res;
            }
            public void generatesubsets(int nums[],int start,List<Integer> temp,List<List<Integer>> res){
                /* just for undderstanding
               // System.out.print(start+"->");
                // for(int i=0;i<temp.size();i++){
                //     System.out.print(temp.get(i)+" ");
                // }
    
                //  System.out.println();
                */
              
                 res.add(new ArrayList<>(temp));
                if(start >= nums.length){
                    return ;
                }
                for(int i= start;i<nums.length;i++){
                    System.out.println(nums[i]);
                    temp.add(nums[i]);
                    generatesubsets(nums,i+1,temp,res);
                    temp.remove(temp.size()-1);
                }
    
            }
            
        }

