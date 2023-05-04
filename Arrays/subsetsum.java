import java.util.*;
import java.io.*;

public class subsetsum {

    public static void subsetsumsort(int index, int sum, ArrayList<Integer> subset, int N, int nums[]) {
        if (index == N) {
            subset.add(sum);
            return;
        }
        subsetsumsort(index + 1, sum + nums[index], subset, N, nums);
        subsetsumsort(index + 1, sum, subset, N, nums);

    }

    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int N = num.length;
        subsetsumsort(0, 0, res, N, num);
        Collections.sort(res);
        return res;
    }

}
