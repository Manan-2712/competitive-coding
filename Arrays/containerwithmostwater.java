package Arrays;
//https://leetcode.com/problems/container-with-most-water/description/
public class containerwithmostwater {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int currcap = 0;
        while (i < j) {
            int w = j - i;
            int l = Math.min(height[i], height[j]);
            currcap = Math.max(currcap, w * l);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return currcap;

    }
}
