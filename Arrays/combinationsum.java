package Arrays;

import java.util.*;
//https://leetcode.com/problems/combination-sum/

public class combinationsum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        generatecombinationsum(0, candidates, temp, result, target);
        return result;
    }

    public void generatecombinationsum(int start, int[] candidates, List<Integer> temp, List<List<Integer>> result,
            int target) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            generatecombinationsum(i, candidates, temp, result, target - candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }
}
