//https://www.codingninjas.com/codestudio/problems/reverse-stack-using-recursion_631875?leftPanelTab=1
package Stacks;

import java.util.Stack;

public class stackreversal {
    public static void transfer(Stack<Integer> s1, Stack<Integer> s2, int n) {
        for (int i = 0; i < n; i++) {
            int temp = s1.peek();
            s1.pop();
            s2.push(temp);
        }

    }

    public static void reverse(Stack<Integer> s1, Stack<Integer> s2, int n) {
        for (int i = 0; i < n; i++) {
            int temp = s1.peek();
            s1.pop();
            transfer(s1, s2, n - i - 1);
            s1.push(temp);
            transfer(s2, s1, n - i - 1);
        }
    }

    public static void reverseStack(Stack<Integer> stack) {
        Stack<Integer> s2 = new Stack<>();
        int n = stack.size();
        reverse(stack, s2, n);

    }

}
