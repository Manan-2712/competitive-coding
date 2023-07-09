package maths;

public class ispowof2 {
    // https://practice.geeksforgeeks.org/problems/power-of-2-1587115620/1
    // Function to check if given number n is a power of two.
    public static boolean isPowerofTwo(long n) {
        if (n == 0) {
            return false;
        }

        int ans = ((int) n & ((int) n - 1));
        if (ans == 0) {
            return true;
        }
        return false;
    }

}
