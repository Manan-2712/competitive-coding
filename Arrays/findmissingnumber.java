package Arrays;

//https://leetcode.com/problems/single-number-iii/description/
// video explanantion 
//https://www.youtube.com/watch?v=pnx5JA9LNM4&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=10
public class findmissingnumber {
    public int[] singleNumber(int[] nums) {
        int xxory = 0;
        int res[] = new int[2];
        // taking xor of each element of nums array.
        for (int val : nums) {
            xxory = xxory ^ val;
        }
        // right most set bit mask formula ;
        int rsbm = xxory & -xxory;
        int x = 0;
        int y = 0;
        for (int val : nums) {
            // if rightmost set bit of an element of nums array is 0. then this
            if ((rsbm & val) == 0) {
                x = x ^ val;
            }
            // else this;
            else {
                y = y ^ val;
            }
        }
        res[0] = x;
        res[1] = y;

        return res;
    }
}
