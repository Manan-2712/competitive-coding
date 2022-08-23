package coursera.week6_dynamicprogramming_2;

import java.util.Scanner;

public class maximumvalueofarithmeticexpression {

    public static long calculation(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }

    }

    public static long[] min_max(int i, int j, char op[], long m[][], long M[][]) {
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        for (int k = i; k < j; k++) {
            long a = calculation(M[i][k], M[k + 1][j], op[k]);
            long b = calculation(M[i][k], m[k + 1][j], op[k]);
            long c = calculation(m[i][k], M[k + 1][j], op[k]);
            long d = calculation(m[i][k], m[k + 1][j], op[k]);
            min = Math.min(min, Math.min(a, Math.min(b, Math.min(c, d))));
            max = Math.max(max, Math.max(a, Math.max(b, Math.max(c, d))));
        }
        return new long[] { min, max };

    }

    public static long getmaxvalue(String exp) {
        int temp = 0;
        char str[] = exp.toCharArray();
        char op[] = new char[(str.length - 1) / 2 + 1];
        int rows = exp.length() / 2 + 1;

        int cols = exp.length() / 2 + 1;

        long[][] m = new long[rows][cols];
        long[][] M = new long[rows][cols];
        // int temp=0;
        for (int i = 0; i < rows; i++) {

            m[i][i] = Character.getNumericValue(str[temp]);
            M[i][i] = Character.getNumericValue(str[temp]);

            temp += 2;

        }
        for (int i = 1, k = 0; i < str.length; i += 2, k++) {
            op[k] = str[i];
        }
        for (int s = 1; s < rows; s++) {
            for (int i = 0; i < rows - s; i++) {
                int j = i + s;
                long minmax[] = min_max(i, j, op, m, M);
                m[i][j] = minmax[0];
                M[i][j] = minmax[1];

            }
        }
        // for(int i=0;i<rows;i++){
        // for(int j=0;j<cols;j++){
        // System.out.print(M[i][j] +" ");
        // }
        // System.out.println();
        // }
        return M[0][rows - 1];

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getmaxvalue(exp));
    }

}