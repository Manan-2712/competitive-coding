//https://www.codingninjas.com/codestudio/problems/insert-an-element-at-its-bottom-in-a-given-stack_1171166?leftPanelTab=1

package Stacks;

import java.util.*;

public class InsertionAtBottom {

    public static Stack<Integer> pushAtBottom(Stack<Integer> myStack, int x) {
        if (myStack.isEmpty()) {
            myStack.push(x);
            return myStack;
        }
        int num = myStack.peek();
        myStack.pop();
        pushAtBottom(myStack, x);
        myStack.push(num);
        return myStack;
    }
}
