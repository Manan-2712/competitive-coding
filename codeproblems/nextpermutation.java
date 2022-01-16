//https://leetcode.com/problems/next-permutation/submissions/
package codeproblems;
public class nextpermutation {
        public void nextPermutation(int[] nums) {
            int index=-1;
            int minindex=0;
            int n= nums.length;
            for(int i=n-2;i>=0;i-- )
            {
                if(nums[i]<nums[i+1])
                {
                    index=i;
                    break;
                }
                
            }
            int temp;
            if(index<0 || n==1){
            for(int i=0;i<n/2;i++)
            {
                temp=nums[i];
                nums[i]=nums[(n-1)-i];
                nums[(n-1)-i]=temp;
            }
              
           
            }
        
            else{
            
            for(int j= index+1;j<n;j++)
            {
                if(nums[j]>nums[index])
                {
                     minindex=j;
                }
            }
            temp=nums[minindex];
            nums[minindex]=nums[index];
            nums[index]=temp;
                
            int low=index+1;
                int last= n-1;
                while(low<last)
                {
                    temp= nums[low];
                    nums[low]=nums[last];
                    nums[last]=temp;
                    low++;
                    last--;
                }
            }
        
            
            
        }
    }
