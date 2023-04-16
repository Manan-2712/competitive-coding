package Arrays;
//https://leetcode.com/problems/two-sum/description/
import java.util.*;

public class twosum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int newtarget = target - nums[i];
            if (map.containsKey(newtarget)) {
                return new int[] { map.get(newtarget), i };
            }
            map.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }
}
