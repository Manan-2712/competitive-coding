//https://www.interviewbit.com/problems/find-permutation/hints/
package Interviewbit.arrays;

import java.util.ArrayList;

public class find_permutation {

    // DO NOT MODIFY THE LIST. IT IS READ ON
    public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        int s = 1;
        int e = B;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'I') {

                res.add(s);
                s++;
            } else {

                res.add(e);
                e--;
            }
        }
        res.add(s);// insertion of remaining element to the list ;
        return res;

    }
}
