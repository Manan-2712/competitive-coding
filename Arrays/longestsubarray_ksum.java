package Arrays;
//https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
//https://www.youtube.com/watch?v=-TmXl8zo7mA
import java.util.*;

class GfG {
    int maxLen(int arr[], int n) {
        // NAIVE APPROACH
        // int len=0;
        // for(int i=0;i<n;i++){
        // int sum =0;
        // for(int j = i;j<n;j++){
        // sum +=arr[j];
        // if(sum == 0){
        // len = Math.max(len,j-i+1);
        // }
        // }
        // }
        // return len;

        // OPTIMAL APPROACH USING HASHING
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = 0;
        int sum = 0;
        int k = 0;// This is generalized approach k can by anything,in this case k=0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) {
                len = i + 1;
            } else if (map.containsKey(sum - k)) {
                len = Math.max(len, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;

    }
}