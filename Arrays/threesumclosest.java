package Arrays;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-closest/description/
public class threesumclosest {
        public int threeSumClosest(int[] nums, int target) {
            int mindiff = Integer.MAX_VALUE;
            int csum =0;
            Arrays.sort(nums);
            int n = nums.length;
            for(int i=0;i<n-2;i++){
                int start = i+1;
                int end = n-1;
                while(start < end){
                    int sum = nums[i]+nums[start]+nums[end];
                    int diff = Math.abs(sum - target);
                    if(diff < mindiff){
                        mindiff = diff;
                        csum = sum;
                    }
                    if(sum == target){
                        csum = sum;
                        break;
                    }
                    else if(sum < target){
                        start++;
                    }
                    else{
                        end--;
                    }
                    
                }
               // return csum;
            }
            return csum;
        }
    }

