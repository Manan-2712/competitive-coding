package Arrays;

import java.util.*;

public class mincosttomakearrayequal2 {
    public int minMoves2(int[] nums) {
        // In these types of questions always find the median element by sorting the array,
        // and then make all elements equal to that median element with the help of given operations.
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length; 
        int m = n / 2;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(nums[i] - nums[m]);
        }
        return ans;

    }
}
