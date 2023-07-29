package Stacks;
//https://leetcode.com/problems/next-greater-element-i/description/
import java.util.HashMap;
import java.util.*;

public class nextgreaterelementop2 {
    public int[] helper(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (st.size() > 0 && st.peek() < nums[i]) {
                st.pop();
            }
            ans[i] = st.size() > 0 ? st.peek() : -1;
            st.push(nums[i]);

        }
        return ans;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[] = helper(nums2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ans.length; i++) {
            map.put(nums2[i], ans[i]);
        }
        int res[] = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;

    }
}
