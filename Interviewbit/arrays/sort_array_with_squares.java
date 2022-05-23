//https://www.interviewbit.com/problems/sort-array-with-squares/
package Interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class sort_array_with_squares {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            res.add(A.get(i) * A.get(i));
        }
        Collections.sort(res);
        return res;
    }
}
