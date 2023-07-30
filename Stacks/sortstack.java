package Stacks;
//https://www.codingninjas.com/studio/problems/sort-a-stack_985275?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
import java.util.*;
import java.io.*;

public class sortstack {

    public static void sortstackinsert(Stack<Integer> stack, int num) {
        if (stack.isEmpty() || (!stack.isEmpty()) && stack.peek() < num) {
            stack.push(num);
            return;
        }
        int n = stack.peek();
        stack.pop();
        sortstackinsert(stack, num);
        stack.push(n);
    }

    public static void sortStack(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        int num = stack.peek();
        stack.pop();
        sortStack(stack);
        sortstackinsert(stack, num);

    }

}
