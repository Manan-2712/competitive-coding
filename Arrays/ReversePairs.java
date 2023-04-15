package Arrays;
import java.util.*;
//https://leetcode.com/problems/reverse-pairs/description/
//https://www.youtube.com/watch?v=S6rsAlj_iB4&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=19
public class ReversePairs {
    public int merge(int[] nums, int low, int mid, int high) {
        int count = 0;
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > (2 * (long) nums[j])) {
                j++;
            }
            count += (j - (mid + 1));
        }
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (nums[left] < nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }
        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }
        for (int i = 0; i < temp.size(); i++) {
            nums[low + i] = temp.get(i);
        }
        return count;
    }

    public int mergesort(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }
        int mid = (low + high) / 2;
        int inv = mergesort(nums, low, mid);
        inv += mergesort(nums, mid + 1, high);
        inv += merge(nums, low, mid, high);
        return inv;
    }

    public int reversePairs(int[] nums) {
        return mergesort(nums, 0, nums.length - 1);

    }
}
