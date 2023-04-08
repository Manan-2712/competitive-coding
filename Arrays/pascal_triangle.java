package Arrays;
//https://leetcode.com/problems/pascals-triangle/description/
//https://www.youtube.com/watch?v=bR7mQgwQ_o8
import java.util.*;
public class pascal_triangle {
    public List<Integer> generaterow(int row) {
        List<Integer> res = new ArrayList<>();
        int ans = 1;
        res.add(1);
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            res.add(ans);
        }
        return res;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = generaterow(i);
            ans.add(temp);
        }
        return ans;

    }
}
