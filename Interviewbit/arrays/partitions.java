package Interviewbit.arrays;

public class partitions {

    public int solve(int A, int[] B) {
        int totalsum = 0;
        for (int i = 0; i < A; i++) {
            totalsum += B[i];
        }
        if (totalsum % 3 != 0) {
            return 0;
        }
        int ans = 0;
        int one_third = totalsum / 3;
        int two_third = 2 * one_third;
        int sum = 0;
        int one_third_count = 0;
        for (int i = 0; i < A - 1; i++) {
            sum += B[i];
            if (sum == two_third) {
                ans += one_third_count;
            }
            if (sum == one_third) {
                one_third_count++;
            }
        }

        return ans;
    }
}
