//https://leetcode.com/contest/weekly-contest-316/problems/minimum-cost-to-make-array-equal/
package Arrays;

import java.util.*;

class pair {
    int nums;
    int cost;

    public pair(int nums, int cost) {
        this.nums = nums;
        this.cost = cost;
    }
}

public class mincosttomakearrayequal {

    public long calci(int[] nums, int[] cost, long median) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += Math.abs(1L * nums[i] - median) * (1L * cost[i]);
        }
        return ans;
    }

    public long minCost(int[] nums, int[] cost) {
        ArrayList<pair> arr = new ArrayList<>();
        int n = cost.length;
        for (int i = 0; i < n; i++) {
            arr.add(new pair(nums[i], cost[i])); // stores as pair of nums[i] with its cost[i]value
        }
        Collections.sort(arr, (a, b) -> {// sort on the basis of nums;
            return a.nums - b.nums;
        });
        long sum = 0;
        long tot = 0;
        for (int i = 0; i < cost.length; i++) {
            sum += 1L * (arr.get(i).cost);// calculating the sum of frequency i.e sum of cost array ,which helps
        }                                 // us to find median element ;
        long median = 0;
        int i = 0;
        while (tot < (sum + 1) / 2 && i < n) {
            tot += 1L * (arr.get(i).cost); // while tot is less than median,mark the ith element as median.And when
            median = arr.get(i).nums;// when loop breaks the last marked element is the actual median of the sorted array
            i++;
        }
        return calci(nums, cost, median);// return the minimum cost to make array equal;
    }
}
