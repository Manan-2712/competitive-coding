//https://www.interviewbit.com/problems/total-moves-for-bishop/
package Interviewbit.maths;

public class totalmovesforBishop {

    public int solve(int A, int B) {

        int topleft = Math.min(A - 1, B - 1);
        int bottomleft = Math.min(8 - A, B - 1);
        int topright = Math.min(A - 1, 8 - B);
        int bottomright = Math.min(8 - A, 8 - B);
        return topleft + bottomleft + bottomright + topright;

    }
}
