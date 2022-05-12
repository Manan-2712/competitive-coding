//https://www.interviewbit.com/problems/minimum-lights-to-activate/
package InterviewBit;

import java.util.*;

public class minlightstoactivate {

    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        int n = A.size();
        int i = 0;
        if (B >= n) {
            return 1;
        }
        while (i < n) {
            int left = Math.max(i - B + 1, 0);
            int right = Math.min(i + B - 1, n - 1);
            boolean bulbfound = false;
            while (right >= left) {
                if (A.get(right) == 1) {
                    bulbfound = true;
                    break;
                }
                right--;

            }
            if (!bulbfound) {
                return -1;
            }
            count++;
            i = right + B;
        }
        return count;
    }
}
