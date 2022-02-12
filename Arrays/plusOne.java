// https://www.interviewbit.com/problems/add-one-to-number/
package Arrays;
public class plusOne {
    public int[] plusone(int[] A) {

        if (A.length == 1) {
            if (A[0] < 9) {
                A[0] += 1;
                return A;
            } else {
                int res[] = new int[2];
                res[0] += 1;
                return res;
            }
        }
        int j = 0;
        while (A[j] == 0) {
            j++;

        }
        int n = A.length;
        int a[] = new int[n - j];
        for (int i = 0; i < a.length; i++) {
            a[i] = A[i + j];
        }
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] < 9) {
                a[i] += 1;
                return a;
            }
            a[i] = 0;
        }
        int res[] = new int[a.length + 1];
        res[0] = 1;
        return res;
    }
}
