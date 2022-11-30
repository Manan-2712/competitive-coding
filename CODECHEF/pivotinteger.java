//https://leetcode.com/contest/weekly-contest-321/problems/find-the-pivot-integer/
package CODECHEF;
public class pivotinteger {
    public int pivotInteger(int n) {
        int leftsum = 0;
        int rightsum = n * (n + 1) / 2;
        for (int i = 1; i <= n; i++) {
            rightsum -= i;
            if (leftsum == rightsum) {
                return i;
            }
            if (leftsum > rightsum) {
                return -1;
            }
            leftsum += i;
        }
        return -1;

    }
}
