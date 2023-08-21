package maths;

//https://leetcode.com/problems/number-of-1-bits/description/
public class numberofonebits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int helper = 1;
        int result = 0;
        for (int i = 1; i <= 32; i++) {
            if ((helper & n) != 0) {
                result++;
            }
            helper = helper << 1;
        }
        return result;

    }
}
