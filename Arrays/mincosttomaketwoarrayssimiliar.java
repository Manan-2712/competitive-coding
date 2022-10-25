//https://leetcode.com/contest/weekly-contest-316/problems/minimum-number-of-operations-to-make-arrays-si
package Arrays;
import java.util.*;
public class mincosttomaketwoarrayssimiliar {
    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);
        // we made these arraylists because if nums[i]=2 and target[i]=3,in this case we
        // cannot convert 2 to 3 according to the given
        ArrayList<Integer> odd = new ArrayList<>();// problem ,so in order to solve these test cases ,these arraylists
                                                   // are used
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> oddtarget = new ArrayList<>();
        ArrayList<Integer> eventarget = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
            if (target[i] % 2 == 0) {
                eventarget.add(target[i]);
            } else {
                oddtarget.add(target[i]);
            }
        }

        long count = 0;
        for (int i = 0; i < even.size(); i++) {
            count += Math.abs((long) even.get(i) - (long) eventarget.get(i)) / 2;// to consider +2 as one operation.
        }
        for (int i = 0; i < odd.size(); i++) {
            count += Math.abs((long) odd.get(i) - (long) oddtarget.get(i)) / 2; // to consider +2 as one operation.
        }
        return count / 2;// because +2 and -2 is one operation only acc,to problem statement;

    }
}
