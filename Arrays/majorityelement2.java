package Arrays;
//https://leetcode.com/problems/majority-element-ii/description/
import java.util.*;

public class majorityelement2 {
    public List<Integer> majorityElement(int[] nums) {
        // Better Approach use hashmap as in majority element 1 and check frequency >
        // N/3.
        // OPTIMAL APPROACH using Boyer Moore Voting Algorithm for two majority
        // elements.
        int num1 = -1;
        int num2 = -1;
        int count1 = 0;
        int count2 = 0;
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            }
        }
        if (count1 > n / 3) {
            res.add(num1);
        }
        if (count2 > n / 3) {
            res.add(num2);
        }
        return res;

    }
}
