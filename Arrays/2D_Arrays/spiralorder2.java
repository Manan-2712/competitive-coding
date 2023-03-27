
//https://leetcode.com/problems/spiral-matrix-ii/description/
public class spiralorder2 {
    public int[][] generateMatrix(int n) {
        int rstart = 0;
        int rend = n - 1;
        int cstart = 0;
        int cend = n - 1;
        int res[][] = new int[n][n];
        if (n == 0) {
            return res;
        }
        int num = 1;
        while (rstart <= rend && cstart <= cend) {
            for (int i = cstart; i <= cend; i++) {
                res[rstart][i] = num++;
            }
            rstart++;
            for (int i = rstart; i <= rend; i++) {
                res[i][cend] = num++;
            }
            cend--;
            for (int i = cend; i >= cstart; i--) {
                res[rend][i] = num++;
            }
            rend--;
            for (int i = rend; i >= rstart; i--) {
                res[i][cstart] = num++;
            }
            cstart++;
        }
        return res;

    }
}
