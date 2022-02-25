//https://www.codingninjas.com/codestudio/problems/minimum-cost-to-make-string-valid_1115770?leftPanelTab=1
package Stacks;

import java.util.*;

public class minimumcost_to_makeStringvalid {

    public static int findMinimumCost(String str) {
        if (str.length() % 2 != 0) {
            return -1;
        }
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '{') {
                st.push(ch);
            } else {
                if (!st.isEmpty() && st.peek() == '{') {
                    st.pop();
                } else {
                    st.push(ch);
                }
            }

        }
        int a = 0;
        int b = 0;
        while (!st.isEmpty()) {
            if (st.peek() == '{') {
                b++;
            }
            if (st.peek() == '}') {
                a++;
            }
            st.pop();
        }
        int ans = ((a + 1) / 2) + ((b + 1) / 2);
        return ans;
    }
}
