//https://www.codingninjas.com/codestudio/problems/jumping-numbers_1069220?leftPanelTab=1
package maths;

import java.util.*;

public class jumpingNumbers {

    public static ArrayList<Integer> jumpingnumbers(int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        LinkedList<Integer> l = new LinkedList<Integer>();
        for (int i = 1; i <= 9 && i <= n; i++) {
            l.add(i);
        }
        while (!l.isEmpty()) {
            int num = l.remove();
            if (num <= n) {
                ans.add(num);
                int lastdigit = num % 10;
                if (lastdigit == 0) {
                    l.add((num * 10) + (lastdigit + 1));
                } else if (lastdigit == 9) {
                    l.add((num * 10) + (lastdigit - 1));
                } else {
                    l.add((num * 10) + (lastdigit - 1));
                    l.add((num * 10) + (lastdigit + 1));
                }
            }
        }
        return ans;

    }
}
