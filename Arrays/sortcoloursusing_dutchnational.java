package Arrays;

//https://leetcode.com/problems/sort-colors/description/
public class sortcoloursusing_dutchnational {
    public void sortColors(int[] nums) {

        // int count0=0;
        // int count1=0;
        // int count2=0;
        // for(int i=0;i<nums.length;i++){
        // if(nums[i]==0){
        // count0++;
        // }
        // if(nums[i]==1){
        // count1++;
        // }
        // if(nums[i]==2){
        // count2++;
        // }
        // }
        // // System.out.println(count0);
        // // System.out.println(count1);
        // // System.out.println(count2);
        // for(int i=0;i<count0;i++){
        // nums[i]=0;
        // }
        // int fill1= count0+count1;
        // for(int i=count0;i<fill1;i++){
        // nums[i]=1;
        // }
        // int fill2= count0+count1+count2;
        // for(int i=fill1;i<fill2;i++){
        // nums[i]=2;
        // }


        

        // USING DUTCH NATIONAL FLAG ALGORITHM
        // using three pointers low,mid,high and swapping these variable values to get
        // the whole sorted array;
        int low = 0;
        int mid = low;
        int high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}