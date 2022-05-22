package Interviewbit.arrays;

import java.util.ArrayList;

public class flips {
    public class Solution {
        public ArrayList<Integer> flip(String A) {
            ArrayList<Integer> ans= new ArrayList<>();
             ans.add(0);
             ans.add(0);
    
            ArrayList<Integer> res= new ArrayList<>();
            boolean nozero = true;
            int n = A.length();
            ArrayList<Integer> arr= new ArrayList<>();
            for(int i=0;i<n;i++){
                if(A.charAt(i)=='0'){
                    arr.add(1);
                    nozero= false;
                }
                else {
                    arr.add(-1);
                }
            }
            if(nozero==true){
                return res;
            }
            int left= 0;
            int right= 0;
            int currsum =0;
            int maxsum =0;
            for(int i=0;i<n;i++){
                currsum+=arr.get(i);
                if(currsum>maxsum){
                    maxsum= currsum;
                    right=i;
                    ans.set(0,left+1);
                    ans.set(1,right+1);
                }
                if(currsum < 0 ){
                    currsum = 0;
                    left = i+1;
                }
            }
            return ans;
        }
    }
    
}
