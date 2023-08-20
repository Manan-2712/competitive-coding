package maths;
//https://leetcode.com/problems/sum-of-two-integers/description
public class addtwonumber {
    public int getSum(int a, int b) {
        int carry = -1, sum = -1;
        while (carry != 0) {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return sum;
    }
}
