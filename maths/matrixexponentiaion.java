package maths;

//https://leetcode.com/problems/fibonacci-number/description/
public class matrixexponentiaion {
    public void multiply(int a[][], int b[][]) {
        int n = a.length;
        int m = a[0].length;
        int ans[][] = new int[n][m];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                ans[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = ans[i][j];
            }
        }
    }

    public void power(int[][] m, int n) {
        int f[][] = { { 1, 1 }, { 1, 0 } };
        if (n == 1 || n == 0) {
            return;
        }
        power(m, n / 2);
        multiply(m, m);
        if (n % 2 != 0) {
            multiply(m, f);
        }
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[][] m = { { 1, 1 }, { 1, 0 } };
        power(m, n - 1);
        return m[0][0];

    }
}
