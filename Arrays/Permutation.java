
package Arrays;
//https://leetcode.com/problems/permutations/
import java.util.List;
import java.util.ArrayList;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        permute(nums, 0, res);
        return res;
    }

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void permute(int[] nums, int index, List<List<Integer>> res) {
        // List<Integer> curr= new ArrayList<>();
        if (index == nums.length) {
            List<Integer> curr = new ArrayList<>();
            for (int e : nums) {
                curr.add(e);
            }
            res.add(curr);
            return;
        }
        // curr.add(nums[index]);
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            permute(nums, index + 1, res);
            swap(nums, i, index);

        }
    }
}
