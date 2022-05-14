//https://www.interviewbit.com/problems/pick-from-both-sides/
package Interviewbit.arrays;

import java.util.ArrayList;

public class pickfrombothsides {

    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int currsum = 0;
        int maxsum = 0;
        for (int i = 0; i < B; i++) {
            currsum += A.get(i);
        }
        maxsum = currsum;
        int inc = n - 1;
        int exc = B - 1;
        while (inc >= 0 && exc >= 0) {
            currsum += A.get(inc--);
            currsum -= A.get(exc--);
            maxsum = Math.max(currsum, maxsum);
        }
        return maxsum;
    }
}