//https://www.naukri.com/code360/problems/missing-number_6680467?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse&leftPanelTabValue=PROBLEM
// Solution: https://takeuforward.org/arrays/find-the-missing-number-in-an-array/
public class findMissingNumber_2 {
    public static int missingNumber(int[] a, int N) {
        int xor2 = 0;
        int xor1 = 0;
        for (int i = 0; i < N - 1; i++) {
            xor2 ^= a[i];
            xor1 ^= i + 1;
        }
        xor1 = xor1 ^ N;
        return xor1 ^ xor2;
    }
}
