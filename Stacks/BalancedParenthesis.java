//https://www.interviewbit.com/problems/balanced-parantheses/
package Stacks;

import java.util.Stack;

public class BalancedParenthesis {
    public int solve(String A) {
        char ch[] = A.toCharArray();
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                st.push(ch[i]);
            } else if (ch[i] == ')' && !st.isEmpty() && st.peek() == '(') {
                st.pop();
            } else {
                return 0;
            }
        }

        if (st.isEmpty()) {
            return 1;
        }
        return 0;
    }
}
