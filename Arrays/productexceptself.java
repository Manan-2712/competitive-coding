package Arrays;
//https://leetcode.com/problems/product-of-array-except-self/description/
public class productexceptself {
    public int[] productExceptSelf(int[] nums) {
             // NOT IN PLACE 
             //   _______________
            // int n = nums.length;
            // int prepr[]= new int[n];
            // int suffpr[]= new int[n];
            // prepr[0] = nums[0];
            // for(int i =1;i<n;i++){
            //     prepr[i] = prepr[i-1]*nums[i];
            // }
            // suffpr[n-1]= nums[n-1];
            // for(int i = n-2;i>=0;i--){
            //     suffpr[i]= suffpr[i+1] * nums[i];
            // }
            // int ans []= new int[n];
            // ans[0]= suffpr[1];
            // ans[n-1]= prepr[n-2];
            // for(int i=1;i<n-1;i++){
            //  ans[i] = prepr[i-1] * suffpr[i+1];
            // }
            // return ans;
     
    
          // IN PLACE APPROACH ;
        //  ________________________
          int product =1;
          int n = nums.length;
          int ans[]= new int[n];
           //ans[n-1]=
           ans[0]= nums[0];  
          for(int i=1;i<n;i++){
              ans[i]= ans[i-1]*nums[i];
          }
          ans[n-1]= ans[n-2];
          product*=nums[n-1];
          for(int i= n-2;i>0;i--){
             ans[i]= ans[i-1]*product;
             product*= nums[i];          
          }
          ans[0]= product;
    
    return ans;
    
        }
}
