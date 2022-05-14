//https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
package Interviewbit.arrays;

import java.util.ArrayList;

public class minstepstoinfinitegrid {

    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int prevx = A.get(0);
        int prevy = B.get(0);
        int n = A.size();
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int currx = A.get(i);
            int curry = B.get(i);
            int diffx = Math.abs(currx - prevx);
            int diffy = Math.abs(curry - prevy);
            // ans+=Math.min(diffx,diffy)+Math.abs(diffx-diffy);
            // or
            ans += Math.max(diffx, diffy);
            prevx = currx;
            prevy = curry;
        }
        return ans;
    }
}
